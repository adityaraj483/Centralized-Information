package com.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Update2")
public class Update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Student stu=(Student)session.getAttribute("student");
		stu.name=req.getParameter("name");
		stu.father=req.getParameter("father");
		stu.mother=req.getParameter("mother");
		stu.city=req.getParameter("city");
		stu.state=req.getParameter("state");
		stu.phone=req.getParameter("phone");
		
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
		res.sendRedirect("welcomeuser2.jsp");
	}

}
