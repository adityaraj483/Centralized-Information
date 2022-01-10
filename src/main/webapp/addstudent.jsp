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
	#forget{
	color:white;}
	#forget:hover{
	
	color:red;
	}
	.register_container{
		width:60%;
		background: rgb(68,255,198);
background: radial-gradient(circle, rgba(68,255,198,1) 3%, rgba(0,255,227,1) 100%, rgba(0,18,36,0.613960113960114) 100%);
		box-shadow:7px 7px 13px #333;
		margin:10%;
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
	
</style>
</head>

<body>
<%
	if(session.getAttribute("student")==null)
		response.sendRedirect("login.jsp");
%>

<div class="container">
<h1>Student Management System</h1>
<form action="Logout" method="post">
	<input id="logoutbtn" type="submit" value="LogOut">
</form>
</div>

<span class="msg" style="background:red">${error}</span>
<span class="msg" style="background:#7fff00">${success}</span><br>

<%
	session.removeAttribute("error");
	session.removeAttribute("success");
	response.setHeader("Cache-Control","no-store,no-cache");
%>

<div class="register_container">
<form action="Register" method="post">
	<h1>Enter credentials</h1>
	<input type="text" name="name" placeholder="Name"><br>
		<input type="email" name="email" placeholder="Email"><br>
		<input type="password" name="pass" placeholder="Password"><br>
	<select class="security" name="question">
      <option value="Select a question from the following options?">Select a question from the following options?</option>
      <option value="What is your favorite color?">What is your favorite color?</option>
      <option value="What is the name of your first pet?">What is the name of your first pet?</option>
   </select>
   <br>
   
   	<input type="text" name="answer" placeholder="Answer"> <br>
	<input type="submit" value="Add student">

</form>
</div>
</body>
</html>