package com.shengxinwu.factory;

import com.shengxinwu.daoImpl.MessageDAOImpl;

public class MessageDAOImplFactory{
	public static MessageDAOImpl getMessageDAOImpl(){
		return new MessageDAOImpl();
	}
}