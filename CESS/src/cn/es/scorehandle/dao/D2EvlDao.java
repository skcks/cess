package cn.es.scorehandle.dao;


import java.util.Set;

import cn.es.dao.BasicDao;
import cn.es.scorehandle.model.ExtraScore;



public interface D2EvlDao extends BasicDao<ExtraScore>{
	public Set<ExtraScore> getD2ByStuId(int stuId);
}
