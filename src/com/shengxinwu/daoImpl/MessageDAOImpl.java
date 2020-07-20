package com.shengxinwu.daoImpl;

import com.shengxinwu.dao.MessageDAO;
import com.shengxinwu.bean.Message;
import com.shengxinwu.util.DBConnection;
import com.shengxinwu.util.Page;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.SQLException;


public class MessageDAOImpl implements MessageDAO {
	public void addMessage( Message message ){
		Connection conn = DBConnection.getConnection();
		String addSQL = "insert into tb_message (messageTitle,messageContent,memberID,messagePublishTime) values (?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(addSQL);
			pstmt.setString(1,message.getMessageTitle());
			pstmt.setString(2,message.getMessageContent());
			pstmt.setInt(3,message.getMemberID());
			pstmt.setTimestamp(4,new Timestamp(message.getMessagePublishTime().getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("MessageDAOImpl插入Message出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}
	
	public void deleteMessage(int messageID){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String delSQL = "delete From tb_message Where messageID=?";
		try{
			pstmt = conn.prepareStatement(delSQL);
			pstmt.setInt(1,messageID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("MessageDAOImpl删除Message出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}
	
	public Message getMessageByID(int messageID){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = new Message();
		String getSQL = "select * from tb_message where messageID=?";
		
		try{
			pstmt = conn.prepareStatement(getSQL);
			pstmt.setInt(1,messageID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				message.setMessageID(messageID);
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(rs.getString(3));
				message.setMemberID(rs.getInt(4));
				message.setMessagePublishTime(rs.getTimestamp(5));
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("MessageDAOImpl获取Message出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return message;
	}
	
	public List<Message> getAllMessage(Page page){
		List<Message> messages = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findSQL = "select * from tb_message order by messagePublishTime desc limit ?,?";
		
		try{
			pstmt = conn.prepareStatement(findSQL);
			pstmt.setInt(1,page.getBeginIndex());
			pstmt.setInt(2,page.getEveryPageCount());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Message message = new Message();
				message.setMessageID(rs.getInt(1));
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(rs.getString(3));
				message.setMemberID(rs.getInt(4));
				message.setMessagePublishTime(rs.getTimestamp(5));
				messages.add(message);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("MessageDAOImpl获取MessageList出错");
			System.out.println("------------------");
			System.out.println();
		}finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return messages;
	}
	
	public int getMessageCount(){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String querySQL = "select count(*) from tb_message";
		int count = 0;
		
		try{
			pstmt = conn.prepareStatement(querySQL);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("------------------");
			System.out.println("MessageDAOImpl获取Message出错");
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