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

	public int confirm(Serializable id,boolean state) {
		String updateQL = "update " + GenricsUtil.getEntityName(entityClazz) + " o set o.submit=? where o."
				+ GenricsUtil.getIdName(entityClazz)
				+"=?";
		System.out.println("updateQL = "+updateQL);
		
		return   sessionFactory.getCurrentSession().createQuery(updateQL).setParameter(0, state).setParameter(1, id).executeUpdate();
		//return hibernateTemplate.bulkUpdate(updateQL,state,id);
	}
	
}
