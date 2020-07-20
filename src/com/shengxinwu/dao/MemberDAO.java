package com.shengxinwu.dao;

import com.shengxinwu.bean.Member;

public interface MemberDAO {
	public void addMember(Member member);
	public void deleteMember(int memberID);
	public Member getMemberByID(int memberID);
}