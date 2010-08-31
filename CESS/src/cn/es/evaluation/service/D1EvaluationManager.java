package cn.es.evaluation.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.es.evaluation.dao.D1EvDao;
import cn.es.evaluation.dao.impl.D1EvDaoMysql;
import cn.es.evaluation.model.D1Evaluation;

@Service
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
		d1EvDao.confirm(d1ID);
		return true;

	}

	public boolean cancelSubmit(int d1ID) {
		D1Evaluation d1 = d1EvDao.get(d1ID);
		d1.setSubmit(false);
		d1EvDao.update(d1);
		return true;

	}

	private boolean doEvaluation(D1Evaluation d1, String sourceType) {
		if (d1EvDao.isExist(d1.getId()) > 0) {
			return false;
		}
		d1EvDao.save(d1);
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
