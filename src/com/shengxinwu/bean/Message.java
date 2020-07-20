package com.shengxinwu.bean;


import java.util.Date;

public class Message {
	private int messageID;
	private String messageTitle;
	private String messageContent;
	private int memberID;
	private Date messagePublishTime;
	

	public int getMessageID(){
		return messageID;
	}

	public void setMessageID(int paramOfBAT){
		messageID=paramOfBAT;
	}

	public String getMessageTitle(){
		return messageTitle;
	}

	public void setMessageTitle(String paramOfBAT){
		messageTitle=paramOfBAT;
	}	

	public String getMessageContent(){
		return messageContent;
	}

	public void setMessageContent(String paramOfBAT){
		messageContent=paramOfBAT;
	}	
	
	public int getMemberID(){
		return memberID;
	}

	public void setMemberID(int paramOfBAT){
		memberID=paramOfBAT;
	}

	public Date getMessagePublishTime(){
		return messagePublishTime;
	}

	public void setMessagePublishTime(Date paramOfBAT){
		messagePublishTime=paramOfBAT;
	}
}