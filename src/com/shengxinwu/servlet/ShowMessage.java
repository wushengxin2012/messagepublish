package com.shengxinwu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.shengxinwu.bean.Message;
import com.shengxinwu.bean.Member;
import com.shengxinwu.dao.MessageDAO;
import com.shengxinwu.factory.MessageDAOImplFactory;
import com.shengxinwu.dao.MemberDAO;
import com.shengxinwu.factory.MemberDAOImplFactory;
import com.shengxinwu.dao.ReplyDAO;
import com.shengxinwu.factory.ReplyDAOImplFactory;


public class ShowMessage extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/showMessage.jsp");
		int messageID = Integer.parseInt(request.getParameter("messageID"));
		MessageDAO messageDAO = MessageDAOImplFactory.getMessageDAOImpl();
		Message message = messageDAO.getMessageByID(messageID);
		request.setAttribute("message",message);
		MemberDAO memberDAO = MemberDAOImplFactory.getMemberDAOImpl();
		Member member = memberDAO.getMemberByID(message.getMemberID());
		request.setAttribute("member",member);
		ReplyDAO replyDAO = ReplyDAOImplFactory.getReplyDAOImpl();
		List replyList = replyDAO.getAllReplyByMessageID(message.getMessageID());
		request.setAttribute("replyList",replyList);
		dispatcher.forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doGet(request,response);
	}
}