package com.shengxinwu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.shengxinwu.util.Page;
import com.shengxinwu.util.PageUtil;
import com.shengxinwu.dao.MessageDAO;
import com.shengxinwu.factory.MessageDAOImplFactory;


public class MessageList extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/messageList.jsp");
		MessageDAO messageDAO = MessageDAOImplFactory.getMessageDAOImpl();
		int totalCount = messageDAO.getMessageCount();
		int currentPage = Integer.parseInt(request.getParameter("page"));
		if(currentPage == 0) currentPage = 1;
		Page page = PageUtil.createPage(5,totalCount,currentPage);
		request.getSession().setAttribute("page",page);
		List messageList = messageDAO.getAllMessage(page);
		request.setAttribute("messageList",messageList);
		dispatcher.forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		doGet(request,response);
	}
}