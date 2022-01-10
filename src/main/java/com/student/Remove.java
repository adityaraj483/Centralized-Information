package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		Student stu=new Student();
		HttpSession session=request.getSession();
		if(stu.checkstudent(email))
		{
			if(stu.removestudent(email))
			{
				session.setAttribute("success","Removed");

				Connection con = Db.con();
				String query = "select name,email,college from educational natural join personal";
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					ArrayList<Student> std = new ArrayList<Student>();
					while (rs.next()) {
						Student obj = new Student();
						obj.name = rs.getString("name");
						obj.email = rs.getString("email");
						obj.college = rs.getString("college");
						std.add(obj);
					}
					session.setAttribute("students", std);
					response.sendRedirect("welcomeadmin.jsp");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			else
			{
				session.setAttribute("error","Error");
				response.sendRedirect("welcomeadmin.jsp");	
			}
		}
		else
		{
			session.setAttribute("error","Student not found");
			response.sendRedirect("welcomeadmin.jsp");
		}
		
	}

}
