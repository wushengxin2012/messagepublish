package com.shengxinwu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import com.shengxinwu.dao.MessageDAO;
import com.shengxinwu.factory.MessageDAOImplFactory;
import com.shengxinwu.bean.Member;
import com.shengxinwu.bean.Message;


public class PublishMessage extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String messageTitle = request.getParameter("messageTitle");
		String messageContent = request.getParameter("messageContent");
		Member member = (Member)request.getSession().getAttribute("member");
		
		if(member == null){
			request.setAttribute("error","需要先登录");
			dispatcher = servletContext.getRequestDispatcher("/publishMessage.jsp");
		}else{
			if(messageTitle == null || "".equals(messageTitle)){
				request.setAttribute("error","标题不能为空");
				dispatcher = servletContext.getRequestDispatcher("/publishMessage.jsp");
			}else{
				MessageDAO messageDAO = MessageDAOImplFactory.getMessageDAOImpl();
				Message message = new Message();
				message.setMessageTitle(messageTitle);
				message.setMessageContent(messageContent);
				message.setMemberID(member.getMemberID());
				message.setMessagePublishTime(new Date());
				messageDAO.addMessage(message);
				dispatcher = servletContext.getRequestDispatcher("/MessageListAction?page=1");
			}
		}
		dispatcher.forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		doGet(request,response);
	}
}