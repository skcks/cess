package cn.es.scorehandle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.es.scorehandle.dao.D2EvlDao;
import cn.es.scorehandle.dao.impl.D2EvlDaoMysql;
import cn.es.scorehandle.model.ExtraScore;

@Service
public class D2ScoreManage {
	D2EvlDao d2EvlDao=null;
	
	
    public ExtraScore queryStudentD2Score(){
		return null;
    }
    
    
    
	public D2EvlDao getD2EvlDao() {
		return d2EvlDao;
	}
	
	@Resource
	public void setD2EvlDao(D2EvlDaoMysql d2EvlDaoMysql) {
		this.d2EvlDao = d2EvlDaoMysql;
	}
}
