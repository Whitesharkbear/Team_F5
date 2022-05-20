package com.web.dao;

import java.util.List;

public interface CgvObjectDAO {
	int insert(Object obj);	
	List<Object> select(int startCount, int endCount);
	Object select(String str);
	void updateHits(String id);
	int update(Object obj);
	int delete(String id);
	int execTotalCount();
	String selectFile(String id);
}
