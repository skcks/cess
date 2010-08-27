package cn.es.evaluation.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.es.evaluation.dao.D1EvDao;
import cn.es.evaluation.dao.impl.D1EvDaoMysql;
import cn.es.evaluation.model.D1Evaluation;

@Component
public class D1EvaluationManager {
	private D1EvDao d1EvDao = null;

	public D1EvaluationManager() {
	}

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
		D1Evaluation d1 = d1EvDao.getD1ByID(d1ID);
		d1.setSubmit(true);
		return d1EvDao.update(d1).isSubmit() ? true : false;
	}

	public boolean cancelSubmit(int d1ID) {
		D1Evaluation d1 = d1EvDao.getD1ByID(d1ID);
		d1.setSubmit(false);
		return d1EvDao.update(d1).isSubmit() ? true : false;
	}

	private boolean doEvaluation(D1Evaluation d1, String sourceType) {
		if (null == d1 || !d1.getSource().equalsIgnoreCase(sourceType)
				|| d1EvDao.exist(d1.getSourceId(), d1.getSource()))
			return false;
		return d1EvDao.add(d1) > 0 ? true : false;
	}

	public boolean d1Validata(D1Evaluation d1) {
		boolean retVal = true;
		retVal = retVal && d1.getPoliticalBeliefs() > 0 && d1.getPoliticalBeliefs() <= 6;
		retVal = retVal && d1.getPoliticalStudy() > 0 && d1.getPoliticalStudy() <= 7;
		retVal = retVal && d1.getHealth() > 0 && d1.getHealth() <= 6;
		retVal = retVal && d1.getSocialPractice() > 0 && d1.getSocialPractice() <= 5;
		retVal = retVal && d1.getSocialWork() > 0 && d1.getSocialWork() <= 5;
		retVal = retVal && d1.getPoliticalBeliefs() > 0 && d1.getPoliticalBeliefs() <= 7;
		retVal = retVal && d1.getAbideLaw() > 0 && d1.getAbideLaw() <= 6;
		retVal = retVal && d1.getStudyAttitude() > 0 && d1.getStudyAttitude() <= 7;
		retVal = retVal && d1.getPolite() > 0 && d1.getPolite() <= 5;
		retVal = retVal && d1.getKeepMorality() > 0 && d1.getKeepMorality() <= 6;
		retVal = retVal && d1.getLifestyleHealthHabit() > 0 && d1.getLifestyleHealthHabit() <= 5;
		retVal = retVal && d1.getThrift() > 0 && d1.getThrift() <= 5;
		return retVal;
	}

	public D1EvDao getD1EvDao() {
		return d1EvDao;
	}

	@Resource
	public void setD1EvDao(D1EvDaoMysql d1EvDaoMysql) {
		this.d1EvDao = d1EvDaoMysql;
	}
}
