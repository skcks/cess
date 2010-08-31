package cn.es.dao;

import java.util.ArrayList;
import java.util.List;

public class QueryResult<T> {
	private List<T> listData = new ArrayList<T>();
	private int totalCount = 0;
	
	public List<T> getListData() {
		return listData;
	}
	public void setListData(List<T> listData) {
		this.listData = listData;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
