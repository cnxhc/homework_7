<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xhc.entity.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<div id="div_bg">
		<div id="div_context">
			<h2>恭喜你！<a href="info.jsp"><s:property value="Users.getUser_name()"/></a>，登录成功</h2>
			
		</div>
	</div>
</body>
</html>