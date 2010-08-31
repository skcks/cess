package cn.es.evaluation.dao;


import java.util.List;

import cn.es.dao.BasicDao;
import cn.es.evaluation.model.T2Evaluation;

public interface T2EvDao extends BasicDao<T2Evaluation>{
	public List<T2Evaluation> getT2ByStuID(int stuId);
	public T2Evaluation getSchoolYearT2(String sourceType, int sourceId, String schoolYear);
}
