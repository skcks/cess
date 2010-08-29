package cn.es.evaluation.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.es.evaluation.dao.T2EvDao;
import cn.es.evaluation.model.T2Evaluation;

@Component
public class T2EvDaoMysql implements T2EvDao {
	private HibernateTemplate hibernateTemplate;

	public int add(T2Evaluation t2Data) {
		hibernateTemplate.save(t2Data);
		return t2Data.getId();
	}

	public int add(List<T2Evaluation> t2Data) {
		int i = 0;
		for (T2Evaluation t2 : t2Data) {
			hibernateTemplate.save(t2);
			i++;
		}
		return i;
	}

	public int del(int id) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		return session.createQuery("delete from T2Evaluation t2 where t2.id=?").setInteger(1, id).executeUpdate();
	}

	public int del(List<Integer> ids) {
		StringBuilder qlBuf = new StringBuilder("delete from T2Evaluation t2 where t2.id in(");

		for (int i = 0; i < ids.size(); i++) {
			qlBuf.append(ids.get(i));
			qlBuf.append(',');
		}

		qlBuf.deleteCharAt(qlBuf.length() - 1);
		qlBuf.append(')');

		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(qlBuf.toString());
		return q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<T2Evaluation> getT2ByStuID(int studentID) {
		String queryString = "from T2Evaluation t2 where t2.sourceId=?";
		return hibernateTemplate.find(queryString, studentID);
	}

	public T2Evaluation update(T2Evaluation t2Data) {
		hibernateTemplate.update(t2Data);
		return t2Data;
	}

	public T2Evaluation getT2(String sourceType, int sourceId, String schoolYear) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		return (T2Evaluation) session.createQuery("from T2Evaluation t2 where t2.source = ? and t2.sourceId=? and t2.schoolYear=?")
									 .setString(1, sourceType)
									 .setInteger(2, sourceId)
									 .setString(3, schoolYear)
									 .uniqueResult();

	}

	public int update(List<T2Evaluation> t2Data) {
		for (T2Evaluation t2 : t2Data) {
			hibernateTemplate.update(t2);
		}
		return t2Data.size();
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean isExist(T2Evaluation t2) {
		List<?> result=hibernateTemplate.find("from T2Evaluation t2 where t2.sourceID=? and t2.schoolYear=? and t2.source=?",
								t2.getSourceId(),
								t2.getSchoolYear(),
								t2.getSource());
		return result.size()>0?false:true;
	}

	public boolean confirm(int t2id) {
		T2Evaluation t2=hibernateTemplate.get(T2Evaluation.class, t2id);
		if(null==t2 || (!t2.getSource().equalsIgnoreCase("stu"))){
			return false;
		}
		t2.setSubmit(true);
		hibernateTemplate.save(t2);
		return true;
	}

	public int cancelSubmit(int t2id) {
		T2Evaluation t2=hibernateTemplate.get(T2Evaluation.class, t2id);
		
		if (null==t2 ) {
			return -1;
		}
		
		if (!t2.getSource().equalsIgnoreCase("stu")) {
			return 0;
		}
		
		t2.setSubmit(false);
		hibernateTemplate.save(t2);
		
		return t2.getId();
	}

	
}
