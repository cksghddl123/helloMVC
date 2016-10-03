<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<style>
div.ex{
	text-align: center;
	width: 37%;
	padding: 10px;
	border: 5px solid grey;
	margin: 20px;
}
</style>
<body>
	<h1>You register successfully!</h1>
	<ul>
		<li>Id : ${customer.id}</li>
		<li>password : ${customer.password}</li>
		<li>gender : ${customer.gender}</li>
		<li>Name : ${customer.name}</li>
		<li>Email : ${customer.email}</li>
	</ul>
	
	<p> <a href="/helloMVC"> Go to home page!</a></p>
</body>
</html>