package com.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Forget")
public class Forget extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu=new Student();
		HttpSession session=request.getSession();
		stu.email=request.getParameter("email");
		stu.password=request.getParameter("pass");
		stu.question=request.getParameter("question");
		stu.answer=request.getParameter("answer");
		if(stu.forgetpassword(stu))
		{
			session.setAttribute("success", "Password changed");
			response.sendRedirect("login.jsp");
		}
		else
		{
			session.setAttribute("error", "Invalid credentials");
			response.sendRedirect("forget.jsp");
		}
	}

}
