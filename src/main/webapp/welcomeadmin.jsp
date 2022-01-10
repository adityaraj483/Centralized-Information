<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	margin-top:-10px;
	 font-family: Arial, Helvetica, sans-serif;
	 }
	 
	 .table_container{
		width:80%;
		height:500px;
		overflow:auto;
		background: rgb(68,255,198);
		background: radial-gradient(circle, rgba(68,255,198,1) 3%, rgba(0,255,227,1) 100%, rgba(0,18,36,0.613960113960114) 100%);
		box-shadow:7px 7px 13px #333;
		margin:3%;
		margin-left:10%;
		border-radius:5px;
		display:flex;
		flex-direction:column;
	}
	.table-heading{
		width:96%;
		margin-left:2%;
		padding:8px 0px;
		display:flex;
		justify-content:space-between;
		margin-bottom:5px;
		border-radius:5px;
		text-align:center;
		font-size:1.5rem;
	}
	.rows{
		width:96%;
		margin-left:2%;
		box-shadow:1px 0px 2px #333;
		padding:8px 0px;
		display:flex;
		justify-content:space-between;
		margin-bottom:5px;
		border-radius:5px;
	}
	.bottomcontainer{
		width:80%;
		margin-left:10%;
		padding:8px 0px;
		display:flex;
		justify-content:space-between;
		margin-bottom:5px;
		border-radius:5px;
		
	}
	#email{
		
		width:80%;
		padding:7px;
		border:none;
		outline:none;
		border-radius:5px;
	}
	.btn{
		padding:5px;
		border:2px solid white;
		outline:none;
		border-radius:5px;
		background:none;
		transform:scale(1.1);
		transition:.2s;
	}
	#removebtn{
		border:2px solid red;;
		color:red;
	}
	#addbtn{
		border:none;
		background:#7fff00;
		color:white;
	}
	#removebtn:hover ,#addbtn:hover{
		trnasform:scale(1.2);
		box-shadow:3px 5px 5px #333;
	}
</style>
</head>
<body>

<%
	if(session.getAttribute("student")==null)
		response.sendRedirect("login.jsp");
%>
<div class="container">
<h1>Centralized Information</h1>
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
<h1 id="username" >Welcome Admin</h1>

<div class="table_container">
	<div class="table-heading">
		<span>Name</span>
		<span>Email</span>
		<span>College</span>
	</div>
	<c:forEach items="${students}" var="stu">
	<div class="rows">
		<span>${stu.name}</span>
		<span>${ stu.email}</span>
		<span>${stu.college}</span>
	</div>
	</c:forEach>

</div>
<div class="bottomcontainer">

<div style="width:90%">
	<form action="Remove" method="post">
		<input id="email" type="email" placeholder="enter student email" name="email">
		<input class="btn" id="removebtn" type="submit" value="Remove user">
	</form>
</div>

<form action="addstudent.jsp" method="post">
	<input class="btn" id="addbtn" type="submit" value="Add user">
</form>

</div>


</body>
</html>