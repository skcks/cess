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

	public T2EvaluationManager() {
	}

	public List<T2Evaluation> queryStudentT2Info(int stuId) {
		return t2Dao.getT2ByStuID(stuId);
	}

	public int modify(T2Evaluation t2) {	
		return t2Dao.update(t2).getId();
	}

	public List<T2Evaluation> listSchoolYearT2(int studentId) {
		return t2Dao.getT2ByStuID(studentId);
	}

	public T2Evaluation queryT2SpecialnSchoolYear(String sourceType, int sourceId, String schoolYear) {
		return t2Dao.getT2(sourceType, sourceId, schoolYear);
	}

	public boolean confirm(T2Evaluation t2) {
	
		return t2Dao.confirm(t2.getId());
	}

	public int cancelConfirm(int t2ID) {
		return t2Dao.cancelSubmit(t2ID);
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
		if (t2Dao.isExist(t2)) {
			return 0;
		}
		return t2Dao.add(t2);
	}

	public T2EvDao getT2Dao() {
		return t2Dao;
	}

	@Resource
	public void setT2Dao(T2EvDaoMysql t2EvDaoMysql) {
		this.t2Dao = t2EvDaoMysql;
	}

}
