package cn.es.evaluation.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import cn.es.dao.DaoSupport;

import cn.es.evaluation.dao.D1EvDao;
import cn.es.evaluation.model.D1Evaluation;
import cn.es.util.GenricsUtil;

@Component
public class D1EvDaoMysql extends DaoSupport<D1Evaluation> implements D1EvDao {
	public D1EvDaoMysql() {
		super();
	}

	public int confirm(Serializable id) {
		String updateQL = "update " + GenricsUtil.getEntityName(entityClazz) + " t set t.isSubmit=1 where t."
				+ GenricsUtil.getIdName(entityClazz)
				+"=?";
		System.out.println("updateQL = "+updateQL);
		return sessionFactory.getCurrentSession().createQuery(updateQL).setParameter(1, id).executeUpdate();
	}
}
