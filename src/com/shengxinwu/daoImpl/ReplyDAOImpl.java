package com.shengxinwu.daoImpl;

import com.shengxinwu.dao.ReplyDAO;
import com.shengxinwu.bean.Reply;
import com.shengxinwu.util.DBConnection;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;


public class ReplyDAOImpl implements ReplyDAO{
	public void addReply(Reply reply){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String insertSQL = "insert into tb_reply(replyID,replyContent,replyTime,messageID,memberID) values(?,?,?,?,?)";
		try{
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setInt(1,reply.getReplyID());
			pstmt.setString(2,reply.getReplyContent());
			pstmt.setTimestamp(3,new Timestamp(reply.getReplyTime().getTime()));
			pstmt.setInt(4,reply.getMessageID());
			pstmt.setInt(5,reply.getMemberID());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("ReplyDAOImpl插入Reply出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
	}
	
	public void deleteReplyByID(int replyID){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String deleteSQL = "delete from tb_reply where replyID=?";
		try{
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1,replyID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("ReplyDAOImpl删除Reply出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
	}
	
	public List<Reply> getAllReplyByMessageID(int messageID){
		List<Reply> replys = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findSQL = "select * from tb_reply where messageID=?";
		try{
			pstmt = conn.prepareStatement(findSQL);
			pstmt.setInt(1,messageID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setReplyID(rs.getInt(1));
				reply.setReplyContent(rs.getString(2));
				reply.setReplyTime(rs.getTimestamp(3));
				reply.setMessageID(rs.getInt(4));
				reply.setMemberID(rs.getInt(5));
				replys.add(reply);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("ReplyDAOImpl查询ReplyList出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
			DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
		return replys;
	}
	
	public int getReplyCount(int messageID){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String countSQL = "select count(*) from tb_reply where messageID=?";
		int count = 0;
		try{
			pstmt = conn.prepareStatement(countSQL);
			pstmt.setInt(1,messageID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("ReplyDAOImpl查询Count出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
			DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
		return count;
	}
}