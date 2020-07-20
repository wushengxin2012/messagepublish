package com.shengxinwu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.shengxinwu.dao.MemberDAO;
import com.shengxinwu.factory.MemberDAOImplFactory;
import com.shengxinwu.bean.Member;

public class Recognise extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String memberID = request.getParameter("memberID");
		String password = request.getParameter("memberPassword");
		
		if(memberID == null || memberID.equals("")){
			request.setAttribute("error","账户信息不能为空");
			dispatcher = servletContext.getRequestDispatcher("/recognise.jsp");
		}else{
			if(password == null || password.equals("")){
				request.setAttribute("error","密码不能为空");
				dispatcher = servletContext.getRequestDispatcher("/recognise.jsp");
			}else{
				MemberDAO memberDAO = MemberDAOImplFactory.getMemberDAOImpl();
				Member member = memberDAO.getMemberByID(Integer.parseInt(memberID));				
				if(member == null){
					request.setAttribute("error","账户信息不存在");
					dispatcher = servletContext.getRequestDispatcher("/recognise.jsp");
				}else{
					if( !(member.getMemberPassword().equals(password)) ){
						request.setAttribute("error","密码不对");
						dispatcher = servletContext.getRequestDispatcher("/recognise.jsp");
					}else{
						request.getSession().setAttribute("member",member);
						dispatcher = servletContext.getRequestDispatcher("/index.jsp");
					}
				}
			}
		}
		dispatcher.forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}