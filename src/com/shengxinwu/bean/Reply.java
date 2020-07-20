package com.shengxinwu.bean;

import java.util.Date;

public class Reply{
	private int replyID;
	private String replyContent;
	private Date replyTime;
	private int messageID;
	private int memberID;
	
	public int getReplyID(){
		return replyID;
	}

	public void setReplyID(int paramOfBAT){
		replyID=paramOfBAT;
	}

	
	public String getReplyContent(){
		return replyContent;
	}

	public void setReplyContent(String paramOfBAT){
		replyContent=paramOfBAT;
	}
	
	public Date getReplyTime(){
		return replyTime;
	}

	public void setReplyTime(Date paramOfBAT){
		replyTime=paramOfBAT;
	}

	public int getMessageID(){
		return messageID;
	}

	public void setMessageID(int paramOfBAT){
		messageID=paramOfBAT;
	}

	public int getMemberID(){
		return memberID;
	}

	public void setMemberID(int paramOfBAT){
		memberID=paramOfBAT;
	}
}