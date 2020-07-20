package com.shengxinwu.factory;

import com.shengxinwu.daoImpl.MemberDAOImpl;

public class MemberDAOImplFactory{
	public static MemberDAOImpl getMemberDAOImpl(){
		return new MemberDAOImpl();
	}
}
