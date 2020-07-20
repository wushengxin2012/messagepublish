package com.shengxinwu.dao;

import com.shengxinwu.bean.Message;
import com.shengxinwu.util.Page;
import java.util.List;

public interface MessageDAO{
	public void addMessage(Message message);
	public void deleteMessage(int messageID);
	public Message getMessageByID(int messageID);
	public List<Message> getAllMessage(Page page);
	public int getMessageCount();
}