package com.shengxinwu.util;

public class Page{
	private int totalCount; //ҳ����ܼ�¼��Ŀ
	private int everyPageCount;	//ÿҳ��ʾ��¼��Ŀ
	private int totalPage;	//�ܵ�ҳ��
	private int currentPage;		//��ǰҳ
	private int beginIndex;
	private boolean hasNextPage;	//�Ƿ�����һҳ
	private boolean hasPrePage;		//�Ƿ�����һҳ
	
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