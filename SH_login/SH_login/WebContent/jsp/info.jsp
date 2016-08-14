<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.xhc.entity.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示登陆成功信息</title>
</head>
<body>
	<div id="div_bg">
		<div id="div_context">
			<center>
			<%
				Users user = (Users) session.getAttribute("users");
			%>
			<center>
				<table style="border: 1px green solid;">
					<tr >
						<td colspan="2" style="text-align: center">显示客户信息</td>
					</tr>
					<tr>
						<td>用户名：</td>
						<td><%=user.getUser_name()%></td>
					</tr>
					<tr>
						<td>真实姓名：</td>
						<td><%=user.getReal_name()%></td>
					</tr>
					<tr>
						<td>年龄：</td>
						<td><%=user.getAge()%></td>
					</tr>
					<tr>
						<td>手机号：</td>
						<td><%=user.getPhone_num()%></td>
					</tr>
					<tr>
						<td>地址：</td>
						<td><%=user.getAddress()%></td>
					</tr>
				</table>
				<a href="../index.jsp">首页</a>
			</center>
		</div>
	</div>
</body>
</html>