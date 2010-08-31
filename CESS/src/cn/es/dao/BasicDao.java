package cn.es.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

public interface BasicDao<T> {

	public Serializable save(T entity);

	public int saveOrUpdate(List<T> entitys);

	public void update(T entity);

	public int delete(Serializable... ids);

	public int isExist(Serializable... ids);

	public T get(Serializable id);

	public QueryResult<T> getPageData(int startIndex, int maxCount, String whereQL, Object[] params,
			LinkedHashMap<String, String> orderFeilds);

	public QueryResult<T> getOrderListData(int startIndex, int maxCount, LinkedHashMap<String, String> orderFeilds);

	public QueryResult<T> getListData(int startIndex, int maxCount);

	public QueryResult<T> getAllData();

}
