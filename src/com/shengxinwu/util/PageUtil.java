package com.shengxinwu.util;

public class PageUtil {
	
	public static Page createPage( int everyPageCount, int totalCount, int currentPage ){
		Page page = null;
		int totalPage = 1;
		int beginIndex = (currentPage-1)*everyPageCount;
		boolean hasNextPage = false;
		boolean hasPrePage =false;
		
		if( totalCount%everyPageCount == 0 ){
			totalPage = totalCount/everyPageCount;
		}else{
			totalPage = totalCount/everyPageCount + 1;
		}
		
		if( currentPage == 0) currentPage = 1;
		
		if( currentPage == 1 ){
			hasPrePage = false;
			if( totalPage == 1){
				hasNextPage = false;
			}else{
				hasNextPage = true;
			}
			
		}else{
			hasPrePage = true;
			if( totalPage == currentPage ){
				hasNextPage = false;
			}else{
				hasNextPage = true;
			}
		}
		
		return new Page(totalCount,everyPageCount,totalPage,currentPage,beginIndex,hasNextPage,hasPrePage);
	}
}