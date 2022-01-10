<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		padding:0;
		margin:0;
		background: rgb(68,255,198);
		background: radial-gradient(circle, rgba(68,255,198,1) 3%, rgba(0,255,227,1) 100%, rgba(0,18,36,0.613960113960114) 100%);
	}
	.container{
		width:100vw;
		height:auto;
		box-shadow:3px 0px 5px #333;
		display:flex;
		justify-content:space-between;
	}
	.container h1{
		padding:0;margin:0;
		text-transform:uppercase;
		color:white;
		margin-top:8px;
	}
	.container div{
		height: 100%;
    	display: flex;
    	padding:10px;
   	 align-content: space-around;
   	 flex-wrap: wrap;
    flex-direction: column;
    justify-content: space-evenly;
	
	}
	ul{
	padding:none;
	margin:0;
	display:flex;
	float:left;
	}
	ul li{
		margin-top:10px;
		margin-right:10px;
		list-style:none;
		padding-top:5px;
		padding-bottom:5px;
		padding-right:10px;
		display:block;
	}
	
	.links{
	display:block;
		border-left:2px solid white;
		box-sizing:border-box;
		display:inline-block;
		color:black;
		text-decoration:none;
		cursor:pointer;
	}
	.links:hover{
	border-color:green;
	color:red;
	}
	.links:active{
	color:orange;}
	.register_container{
		width:60%;
		background: rgb(68,255,198);
		background: radial-gradient(circle, rgba(68,255,198,1) 3%, rgba(0,255,227,1) 100%, rgba(0,18,36,0.613960113960114) 100%);
		box-shadow:7px 7px 13px #333;
		margin:3%;
		margin-left:20%;
		border-radius:15px;
		display:grid;
		justify-content:center;
		align-content:center;
	}
	.register_container h1{
		width:100%;
		padding:8px;
		border-radius:5px;
		background:orange;
		color:white;
		text-transform:uppercase;
		box-shadow:3px 3px 5px #333;
	}
	.register_container input{
		padding:7px 5px;
		margin-bottom:10px;
		border-radius:4px;
		border:none;
		border-bottom:2px solid orange;
		outline:none;
		width:100%;
		trnasition:.15s linear;
	}
	.register_container input[type="submit"]{
		width:80%;
		margin-left:10%;
		border:none;
	}
	.register_container input:hover{
		border-bottom:2px solid #0f0;
	}
	
	.register_container input[type="submit"]:hover{
	border:none;
	cursor:pointer;
		transform:scale(1.1);
		background:#ddd;
	}
	.register_container select{
		padding:7px 5px;
		margin-bottom:10px;
		border-radius:4px;
		border:none;
		outline:none;
		width:103%;
	}
	.msg{
		float:right;
		margin-top:8px;
		padding:10px 0px;
		border-radius:5px;
		color:white;
		
	}
	#logoutbtn{
		padding:8px 10px;
		margin-bottom:10px;
		margin-top:10px;
		margin-right:20px;
		border-radius:4px;
		border:2px solid white;
		color:white;
		outline:none;
		background:none;
		trnasition:.15s linear;
	}
	#logoutbtn:hover{
		background:red;
		cursor:pointer;
	}
	#username{
	 font-family: Arial, Helvetica, sans-serif;
	 }
</style>
</head>
<body>

<% 
	if(session.getAttribute("student")==null)
		response.sendRedirect("login.jsp");
	
%>
<div class="container">

	<ul>
	<li>
		<a class="links" href="welcomeuser1.jsp">Educational Information</a>
	</li>
	<li>
		<a class="links" href="welcomeuser2.jsp">Personal Information</a>
	</li>
	</ul>
	<form action="Logout" method="post">
		<input id="logoutbtn"type="submit" value="LogOut">
	</form>

</div>

<span class="msg" style="background:red">${error}</span>
<span class="msg" style="background:#7fff00">${success }</span>
<%
	response.setHeader("Cache-Control","no-store,no-cache");
	session.removeAttribute("error");
	session.removeAttribute("success");
%>
<h1 id="username">Welcome ${student.name}</h1>
<div class="register_container">

<form action="Update1" method="post">
	Name :<input type="text" name="name" value="${student.name}"><br>
	Scholar Number :<input type="text" name="scholarno" value="${student.scholarno}"><br>
	College:<input type="text" name="college" value="${student.college}"><br>
	Session :<input type="text" name="session" value="${student.session}"><br>
	CGPA :<input type="text" name="cgpa" value="${student.cgpa}"><br>
	LinkedIn :<input type="text" name="linkedin" value="${student.linkedin}"><br>
	<input type="submit" value="Update" />
</form>

</div>
</body>
</html>