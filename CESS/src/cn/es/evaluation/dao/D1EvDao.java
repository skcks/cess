package cn.es.evaluation.dao;

import java.util.List;

import cn.es.evaluation.model.D1Evaluation;

public interface D1EvDao {

	int add(D1Evaluation d1Data);

	int add(List<D1Evaluation> d1Data);

	D1Evaluation update(D1Evaluation d1Data);

	int update(List<D1Evaluation> d1Data);

	int del(int id);

	int del(List<Integer> ids);

	boolean exist(int studentID,String sourceType);
	
	D1Evaluation getD1ByStuID(int studentID, String shcoolYear);

	List<D1Evaluation> getD1ByStuID(int studentID);

	D1Evaluation getD1ByID(int id);
}
