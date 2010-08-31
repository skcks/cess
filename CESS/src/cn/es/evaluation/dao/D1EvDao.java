package cn.es.evaluation.dao;

import java.io.Serializable;

import cn.es.dao.BasicDao;
import cn.es.evaluation.model.D1Evaluation;



public interface D1EvDao extends BasicDao<D1Evaluation>{
	public int confirm(Serializable id);
}
