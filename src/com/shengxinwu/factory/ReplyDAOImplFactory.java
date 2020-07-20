package com.shengxinwu.factory;

import com.shengxinwu.daoImpl.ReplyDAOImpl;

public class ReplyDAOImplFactory{
	public static ReplyDAOImpl getReplyDAOImpl(){
		return new ReplyDAOImpl();
	}
}