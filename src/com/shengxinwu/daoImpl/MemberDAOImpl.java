package com.shengxinwu.daoImpl;

import com.shengxinwu.dao.MemberDAO;
import com.shengxinwu.bean.Member;
import com.shengxinwu.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;

public class MemberDAOImpl implements MemberDAO {
	public void addMember(Member member){
		String insertSQL = "insert tb_member(memberID,memberPassword,memberName,memberSex,memberBirth,isAdminister) values(?,?,?,?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setInt(1,member.getMemberID());
			pstmt.setString(2,member.getMemberPassword());
			pstmt.setString(3,member.getMemberName());
			pstmt.setBoolean(4,member.getMemberSex());
			pstmt.setTimestamp(5,new Timestamp(member.getMemberBirth().getTime()));
			pstmt.setBoolean(6,member.getIsAdminister());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("MemberDAOImpl插入Member出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
	}
	
	public void deleteMember(int memberID){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String deleteSQL = "delete from tb_member where memberID=?";
		try{
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1,memberID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("MemberDAOImpl删除member出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
	}
	
	public Member getMemberByID(int memberID){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findSQL = "select * from tb_member where memberID=?";
		Member member = new Member();
		try{
			pstmt = conn.prepareStatement(findSQL);
			pstmt.setInt(1,memberID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				member.setMemberID(rs.getInt(1));
				member.setMemberPassword(rs.getString(2));
				member.setMemberName(rs.getString(3));
				member.setMemberSex(rs.getBoolean(4));
				member.setMemberBirth(rs.getTimestamp(5));
				member.setIsAdminister(rs.getBoolean(6));
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("MemberDAOImpl获取Member出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
		return member;
	}
}