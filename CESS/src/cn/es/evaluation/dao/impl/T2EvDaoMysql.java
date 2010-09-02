package cn.es.evaluation.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

import cn.es.dao.DaoSupport;

import cn.es.evaluation.dao.T2EvDao;
import cn.es.evaluation.model.T2Evaluation;

@Component
public class T2EvDaoMysql extends DaoSupport<T2Evaluation> implements T2EvDao {
	@SuppressWarnings("unchecked")
	public List<T2Evaluation> getT2ByStuID(int stuId) {
		String queryString = "from T2Evaluation t2 where t2.studentId=?";
		return this.getHibernateTemplate().find(queryString, stuId);
	}

	public T2Evaluation getSchoolYearT2(String sourceType, int sourceId, String schoolYear) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from T2Evaluation t2 where t2.sourceType=? and t2.sourceId=? and t2.schoolYear=?");
		return (T2Evaluation) query.uniqueResult();
	}
}
