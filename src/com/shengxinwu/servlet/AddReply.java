package com.shengxinwu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import com.shengxinwu.factory.ReplyDAOImplFactory;
import com.shengxinwu.bean.Reply;
import com.shengxinwu.bean.Member;

public class AddReply extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/ShowMessageAction");
		Member member = (Member)request.getSession().getAttribute("member");
		if(member == null){
			request.setAttribute("error","ÐèÒªÏÈµÇÂ¼");
		}else{
			String replyContent = request.getParameter("replyContent");
			int messageID = Integer.parseInt((String)request.getParameter("messageID"));
			Reply reply = new Reply();
			reply.setReplyContent(replyContent);
			reply.setReplyTime(new Date());
			reply.setMessageID(messageID);
			reply.setMemberID(member.getMemberID());
			ReplyDAOImplFactory.getReplyDAOImpl().addReply(reply);
		}
		dispatcher.forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doGet(request,response);
	}
}
