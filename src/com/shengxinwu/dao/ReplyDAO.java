package com.shengxinwu.dao;

import com.shengxinwu.bean.Reply;
import java.util.List;

public interface ReplyDAO{
	public void addReply(Reply reply);
	public void deleteReplyByID(int replyID);
	public List<Reply> getAllReplyByMessageID(int messageID);
	public int getReplyCount(int messageID);
}