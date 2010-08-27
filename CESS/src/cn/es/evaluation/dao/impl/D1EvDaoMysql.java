package cn.es.evaluation.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.es.evaluation.model.D1Evaluation;

@Component
public class D1EvDaoMysql implements cn.es.evaluation.dao.D1EvDao {
	private HibernateTemplate hibernateTemplate;

	public int add(D1Evaluation d1Data) {
		hibernateTemplate.save(d1Data);
		return d1Data.getId();
	}

	public int add(List<D1Evaluation> d1Data) {
		int i = 0;
		for (D1Evaluation d1 : d1Data) {
			hibernateTemplate.save(d1);
			i++;
		}
		return i;
	}

	public int del(int id) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		return session.createQuery("delete from D1Evaluation d1 where d1.id=?").setInteger(1, id).executeUpdate();
	}

	public int del(List<Integer> ids) {
		StringBuilder qlBuf = new StringBuilder("delete from D1Evaluation d1 where d1.id in(");
		for (int i = 0; i < ids.size(); i++) {
			qlBuf.append(ids.get(i));
			qlBuf.append(',');
		}
		qlBuf.deleteCharAt(qlBuf.length() - 1);
		qlBuf.append(')');
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(qlBuf.toString());
		return q.executeUpdate();
	}

	public D1Evaluation getD1ByStuID(int studentID, String shcoolYear) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		return (D1Evaluation) session.createQuery("from D1Evaluation d1 where d1.id=? and d1.schoolYear=?").setInteger(
				1, studentID).setString(2, shcoolYear).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<D1Evaluation> getD1ByStuID(int studentID) {
		String queryString = "from D1Evaluation d1 where d1.studentID=?";
		return hibernateTemplate.find(queryString, studentID);
	}

	public D1Evaluation update(D1Evaluation d1Data) {
		hibernateTemplate.update(d1Data);
		return d1Data;
	}

	public int update(List<D1Evaluation> d1Data) {
		for (D1Evaluation d1 : d1Data) {
			hibernateTemplate.update(d1);
		}
		return d1Data.size();
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean exist(int sourceID, String sourceType) {
		boolean retval = false;
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		D1Evaluation d1Evaluation = (D1Evaluation) 
				session.createQuery("from D1Evaluation d where d.sourceID=? and source=?")
			    		.setInteger(1, sourceID)
			    		.setString(2, sourceType)
			    		.uniqueResult();
		if (null != d1Evaluation)
			retval = true;

		return retval;
	}

	public D1Evaluation getD1ByID(int id) {
		return hibernateTemplate.get(D1Evaluation.class, id);
	}

}
