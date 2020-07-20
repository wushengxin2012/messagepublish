package com.shengxinwu.bean;

import java.util.Date;

public class Member {
	private int memberID;
	private String memberPassword;
	private String memberName;
	private boolean memberSex;
	private Date memberBirth;
	private boolean isAdminister;
	
	public int getMemberID(){
        return memberID;
	}

	public void setMemberID(int paramOfBAT){
        memberID=paramOfBAT;
	}
	
	public String getMemberPassword(){
			return memberPassword;
	}

	public void setMemberPassword(String paramOfBAT){
			memberPassword=paramOfBAT;
	}

	public String getMemberName(){
		return memberName;
	}

	public void setMemberName(String paramOfBAT){
		memberName=paramOfBAT;
	}
	
	
	public boolean getMemberSex(){
		return memberSex;
	}

	public void setMemberSex(boolean paramOfBAT){
			memberSex=paramOfBAT;
	}
	
	public Date getMemberBirth(){
			return memberBirth;
	}

	public void setMemberBirth(Date paramOfBAT){
			memberBirth=paramOfBAT;
	}

	public boolean getIsAdminister(){
			return isAdminister;
	}

	public void setIsAdminister(boolean paramOfBAT){
			isAdminister=paramOfBAT;
	}
}