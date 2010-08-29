package cn.es.evaluation.dao;

import java.util.List;

import cn.es.evaluation.model.T2Evaluation;

public interface T2EvDao {

	int add(T2Evaluation t2);

	int add(List<T2Evaluation> t2);

	T2Evaluation update(T2Evaluation t2);

	int update(List<T2Evaluation> t2);

	int del(int id);

	int del(List<Integer> ids);

	T2Evaluation getT2(String sourceType, int sourceId, String schoolYear);

	List<T2Evaluation> getT2ByStuID(int studentID);
	
	boolean isExist(T2Evaluation t2);

	boolean confirm(int t2id);

	int cancelSubmit(int t2id);
}
