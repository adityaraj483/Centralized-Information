package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Update1")
public class Update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession session=req.getSession();
		Student stu=(Student)session.getAttribute("student");
		stu.name=req.getParameter("name");
		stu.scholarno=req.getParameter("scholarno");
		stu.college=req.getParameter("college");
		stu.session=req.getParameter("session");
		stu.cgpa=req.getParameter("cgpa");
		stu.linkedin=req.getParameter("linkedin");
		
		if(stu.updatestudent(stu))
		{
			session.setAttribute("success", "Updated");
			System.out.println("updated");
		}
		else
		{
			session.setAttribute("error", "Not updated");
			System.out.println("not updated");	
		}
		res.sendRedirect("welcomeuser1.jsp");
	}
}
