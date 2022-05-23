package com.web.f5.service;

import java.util.List;

public interface AdminFaqService extends ObjService {

	List<Object> getListResult(int startCount, int endCount);
	List<Object> getSearchResult(int startCount, int endCount);
	int getListCount();
	Object getContent(String id);
	int getUpdateResult(Object obj);
	int getDeleteResult(String id);
	int getInsertResult(Object obj);
}
