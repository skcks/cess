package cn.es.evaluation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.es.evaluation.dao.T2EvDao;
import cn.es.evaluation.dao.impl.T2EvDaoMysql;
import cn.es.evaluation.model.T2Evaluation;

@Service
public class T2EvaluationManager {
	private T2EvDao t2Dao = null;

	public T2EvaluationManager() {}

	public List<T2Evaluation> queryStudentT2Info(int stuId) {
		return t2Dao.getT2ByStuID(stuId);
	}

	public void modify(T2Evaluation t2) {
		 t2Dao.update(t2);	
	}

	
	public T2Evaluation queryT2SpecialnSchoolYear(String sourceType, int sourceId, String schoolYear) {
		return t2Dao.getSchoolYearT2(sourceType, sourceId, schoolYear);
	}

	public int confirm(T2Evaluation t2) {
		t2.setSubmit(true);
		t2Dao.save(t2);
		return t2.getId();
	}

	public int cancelConfirm(int t2ID) {
		T2Evaluation t2= t2Dao.get(t2ID);
		t2.setSubmit(false);
		t2Dao.save(t2);
		return t2ID;
	}
	
	public int doSelfEval(T2Evaluation t2) {
		t2.setSource("stu");
		return doEvaluation(t2);
	}

	public int doGroupEval(T2Evaluation t2) {
		t2.setSource("evgp");
		return doEvaluation(t2);
	}

	public int doInstEval(T2Evaluation t2) {
		t2.setSource("inst");
		return doEvaluation(t2);
	}

	private int doEvaluation(T2Evaluation t2) {
		t2Dao.save(t2);
		return t2.getId();
	}

	public T2EvDao getT2Dao() {
		return t2Dao;
	}

	@Resource
	public void setT2Dao(T2EvDaoMysql t2EvDaoMysql) {
		this.t2Dao = t2EvDaoMysql;
	}

}
