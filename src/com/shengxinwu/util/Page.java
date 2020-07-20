package com.shengxinwu.util;

public class Page{
	private int totalCount; //页面的总记录数目
	private int everyPageCount;	//每页显示记录数目
	private int totalPage;	//总的页数
	private int currentPage;		//当前页
	private int beginIndex;
	private boolean hasNextPage;	//是否有下一页
	private boolean hasPrePage;		//是否有上一页
	
	public Page( int int1, int int2, int int3, int int4,int int5, boolean boo1, boolean boo2 ){
		totalCount = int1;
		everyPageCount = int2;
		totalPage = int3;
		currentPage = int4;
		beginIndex = int5;
		hasNextPage = boo1;
		hasPrePage = boo2;
	}
	
	public int getTotalCount(){
		return totalCount;
	}
	
	public void setTotalCount( int int1 ){
		totalCount = int1;
	}
	
	public int getEveryPageCount(){
		return everyPageCount;
	}
	
	public void setEveryPageCount( int int2 ){
		everyPageCount = int2;
	}
	
	public int getTotalPage(){
		return totalPage;
	}
	
	public void setTotalPage(int int3){
		totalPage = int3;
	}
	
	public int getCurrentPage(){
		return currentPage;
	}
	
	public void setCurrentPage(int int4){
		currentPage = int4;
	}

	public int getBeginIndex(){
		return beginIndex;
	}

	public void setBeginIndex(int paramOfBAT){
		beginIndex=paramOfBAT;
	}

	public boolean getHasNextPage(){
		return hasNextPage;
	}
	
	public void setHasNextPage(boolean boo1){
		hasNextPage = boo1;
	}
	
	public boolean getHasPrePage(){
		return hasPrePage;
	}
	
	public void setHasPrePage(boolean boo2){
		hasPrePage = boo2;
	}
}