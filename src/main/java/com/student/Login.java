package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		Student stu=new Student();
		stu.email=request.getParameter("email");
		stu.password=request.getParameter("pass");
		if(stu.email.equals("admin@gmail.com") && stu.password.equals("aditya"))
		{
			Connection con=Db.con();
			String query="select name,email,college from educational natural join personal";
			try {
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				ArrayList<Student> std=new ArrayList<Student>();
				while(rs.next())
				{
					Student obj=new Student();
					obj.name=rs.getString("name");
					obj.email=rs.getString("email");
					obj.college=rs.getString("college");
					std.add(obj);
				}
				session.setAttribute("students", std);
				session.setAttribute("student", stu);
				
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			response.sendRedirect("welcomeadmin.jsp");
			
			
		}
		else if(stu.checkstudent(stu.email))
		{
			String query="select * from educational natural join personal where email=? and password=md5(?) ";
			Connection con=Db.con();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, stu.email);
				ps.setString(2, stu.password);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					
					stu.name=rs.getString("name");
					stu.scholarno=rs.getString("scholarno");
					stu.session=rs.getString("session");
					stu.cgpa=rs.getString("cgpa");
					stu.college=rs.getString("college");
					stu.linkedin=rs.getString("linkedin");
					stu.father=rs.getString("father");
					stu.mother=rs.getString("mother");
					stu.city=rs.getString("city");
					stu.state=rs.getString("state");
					stu.phone=rs.getString("phone");
					
					session.setAttribute("student", stu);
					
					
					response.sendRedirect("welcomeuser1.jsp");
				}
				else
				{
					session.setAttribute("error", "Wrong Password");
					response.sendRedirect("login.jsp");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				session.setAttribute("error", "Something went wrong");
				response.sendRedirect("login.jsp");
				
			}
		}
		else
		{
			session.setAttribute("error", "User Not Found");
			response.sendRedirect("login.jsp");
		}
		
	}

}
