package com.neuedu.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

public class PageTool {

	
	public static String PAGE_INDEX_KEY = "pageIndex";
	
	public static String PAGE_SIZE_KEY = "pageSize";
	
	public static String PAGE_COURT_KEY = "pageCount";
	
	public static String LIST_STRING_PAGE_KEY = "listStringPage";
	
	public static String START_INDEX_KEY = "startIndex";
	
	public static int PAGE_INDEX_DEFAULT = 1;
	
	public static int PAGE_SIZE_DEFAULT = 2;

	public static synchronized int getPageIndex(String strPageIndex, Model model) {
		int pageIndex = PAGE_INDEX_DEFAULT;
		if(strPageIndex != null && strPageIndex.matches("\\d+")) {
			pageIndex = Integer.parseInt(strPageIndex);
		}
		model.addAttribute(PageTool.PAGE_INDEX_KEY, pageIndex);  
		return pageIndex;
		}

	public static synchronized int getPageSize(String strPageSize, Model model) {  
		int pageSize = PAGE_SIZE_DEFAULT;
		if(strPageSize != null && strPageSize.matches("\\d+")) {
			pageSize = Integer.parseInt(strPageSize);
		}
	model.addAttribute(PageTool.PAGE_SIZE_KEY, pageSize);  
	return pageSize;
	}
	public static synchronized void setPageCount(int pageSize, int dataCount, Model model) {
		int pageCount = 0;
		if(dataCount % pageSize == 0) {  
			pageCount = dataCount / pageSize;
		}else {
			pageCount = (dataCount / pageSize) + 1;
		}
		model.addAttribute(PageTool.PAGE_COURT_KEY, pageCount);
		List<String> listStringPage = new ArrayList<String>();  
		for (int i = 1; i <= pageCount; i++) 
		{  
			listStringPage.add(String.valueOf(i));
		}
		model.addAttribute(PageTool.LIST_STRING_PAGE_KEY, listStringPage);
	}

		public static synchronized void setStartIndex(int pageSize, int pageIndex, Map<String, Object> mapParameter)
		{
			int startIndex = (pageIndex - 1) * pageSize;  
			mapParameter.put(PageTool.START_INDEX_KEY, startIndex);  
			mapParameter.put(PageTool.PAGE_SIZE_KEY, pageSize);
		}

}


