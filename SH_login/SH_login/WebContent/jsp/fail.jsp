<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录失败</title>
</head>
<body>
	<div id="div_bg">
		<div id="div_context">
			<h2>登录失败，请注册一个账号！</h2>
			<% response.setHeader("refresh", "3;URL=reg.jsp");%>
			
		</div>
	</div>
</body>
</html>