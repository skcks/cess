package cn.es.evaluation.dao;

import java.util.List;

import cn.es.evaluation.model.T2Evaluation;

public interface T2EvDao {

	int add(T2Evaluation d1Data);

	int add(List<T2Evaluation> d1Data);

	T2Evaluation update(T2Evaluation d1Data);

	int update(List<T2Evaluation> d1Data);

	int del(int id);

	int del(List<Integer> ids);

	T2Evaluation getT2ByStuID(int studentID, String shcoolYear);

	List<T2Evaluation> getT2ByStuID(int studentID);

}
