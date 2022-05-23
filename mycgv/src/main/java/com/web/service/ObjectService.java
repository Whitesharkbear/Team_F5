package com.web.service;

import java.util.List;

public interface ObjectService {
	int getInsertResult(Object obj);
	List<Object> getListResult(int startCount, int endCount);
//	List<Object> getListResult(Map<String,String> param);
	Object getContent(String id);
	int getListCount();
	void getUpdateHits(String id);
	int getUpdateResult(Object obj);
	int getDeleteResult(String id);
	//String getFilename(String id);
}
