package com.student;

import java.sql.*;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class Student {
	String email,name,scholarno,session,cgpa,college,linkedin,password,question,answer;//Educational information
	String father,mother,city,state,phone; //Personal information
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScholarno() {
		return scholarno;
	}
	public void setScholarno(String scholarno) {
		this.scholarno = scholarno;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean addstudent(Student s)
	{
		Student stu=new Student();
		if(stu.checkstudent(s.email))
			return false;
		
		
		String query="insert into educational (email,name,password,question,answer) values(?,?,md5(?),?,md5(?))";
		Connection con=Db.con();
		PreparedStatement ps=null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, s.email);
			ps.setString(2, s.name);
			ps.setString(3, s.password);
			ps.setString(4, s.question);
			ps.setString(5, s.answer);
			int res1=ps.executeUpdate();
			
			ps=con.prepareStatement("insert into personal (email) values(?)");
			ps.setString(1, s.email);
			int res2=ps.executeUpdate();
			
			if(res1>0 && res2>0)
			{
				System.out.println("student Added");
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return false;
		
	}
	
	public boolean removestudent(String email)
	{
		System.out.println(email);
		String query="delete from educational where email=\""+email+"\"";
		System.out.println(query);
		Statement st=null;
		Connection con=null;
		try {
			con=Db.con();
			st=con.createStatement();
			int res=st.executeUpdate(query);
			
			if(res>0)
				return true;
			else
				return false;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean updatestudent(Student stu)
	{
		
		String query1="update educational set name=?,scholarno=?,session=?,cgpa=?,college=?,linkedin=? where email=?";
		String query2="update personal set father=?,mother=?,city=?,state=?,phone=? where email=?";
		Connection con=Db.con();
		PreparedStatement ps=null,ps2=null;
		try {
			ps=con.prepareStatement(query1);
			ps.setString(1, stu.name);
			ps.setString(2, stu.scholarno);
			ps.setString(3, stu.session);
			ps.setString(4, stu.cgpa);
			ps.setString(5, stu.college);
			ps.setString(6, stu.linkedin);
			ps.setString(7, stu.email);
			int res1=ps.executeUpdate();
			
			ps2=con.prepareStatement(query2);
			ps2.setString(1, stu.father);
			ps2.setString(2, stu.mother);
			ps2.setString(3, stu.city);
			ps2.setString(4, stu.state);
			ps2.setString(5, stu.phone);
			ps2.setString(6, stu.email);
			int res2=ps2.executeUpdate();
	
			
			if(res1>0 && res2>0)
			{
				return true;
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps2!=null) {
				try {
					ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean checkstudent(String email)
	{
		String query="select * from educational where email=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=Db.con();
			ps=con.prepareStatement(query);
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				return true;	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	public boolean forgetpassword(Student stu)
	{
		String query="select * from educational where email=? and question=? and answer=md5(?)";
		Connection con=Db.con();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, stu.email);
			ps.setString(2, stu.question);
			ps.setString(3, stu.answer);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ps=con.prepareStatement("update educational set password=md5(?) where email=?");
				ps.setString(1, stu.password);
				ps.setString(2, stu.email);
				int res=ps.executeUpdate();
				
				if(res>0) {
					
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
