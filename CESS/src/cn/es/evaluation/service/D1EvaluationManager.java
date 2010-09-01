package cn.es.evaluation.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.es.evaluation.dao.D1EvDao;
import cn.es.evaluation.dao.impl.D1EvDaoMysql;
import cn.es.evaluation.model.D1Evaluation;

@Component
public class D1EvaluationManager {
	private D1EvDao d1EvDao = null;


	public boolean doSelfEvaluation(D1Evaluation d1) {
		return this.doEvaluation(d1, "stu");
	}

	
	public boolean doEvgpEvaluation(D1Evaluation d1) {
		return this.doEvaluation(d1, "evgp");
	}

	
	public boolean doInstEvaluation(D1Evaluation d1) {
		return this.doEvaluation(d1, "inst");
	}

	
	public boolean submitData(int d1ID) {
		d1EvDao.confirm(d1ID,true);
		return true;

	}

	public boolean cancelSubmit(int d1ID) {
		d1EvDao.confirm(d1ID,false);
		return false;
	}

	public int removeD1(int id) {
		return this.d1EvDao.delete(id);
	}
	
	private boolean doEvaluation(D1Evaluation d1, String sourceType) {
		if (0!=d1EvDao.isExist(d1.getId())) {
			System.out.println("Found !");
			return false;
		}
		d1EvDao.save(d1);
		System.out.println("add a new D1Evaluation!");
		return true;
	}

	public D1EvDao getD1EvDao() {
		return d1EvDao;
	}

	@Resource
	public void setD1EvDao(D1EvDaoMysql d1EvDaoMysql) {
		this.d1EvDao = d1EvDaoMysql;
	}
}
