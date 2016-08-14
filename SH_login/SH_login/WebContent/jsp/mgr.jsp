<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.xhc.entity.*"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>
</head>
<body>
	<div id="div_bg">
		<div id="div_context">
			<h2>全部的客户信息</h2>
			<%
				List<Users> list = (List) session.getAttribute("users");
				Iterator it = list.iterator();
			%>
			<center>
				<table style="border: 1px green solid;">
					<%
						int i = 0;
						while (it.hasNext()) {
							Users user = (Users) it.next();
					%>
					<tr <%if (i % 2 == 0) {%> bgcolor="#f0f8ff" <%}%>>
						<td><%=user.getId()%></td>
						<td><%=user.getUser_name()%></td>
						<td style="display: none"><%=user.isIsadmin()%></td>
						<td><a href="users!get.action?users.id=<%=user.getId()%>">查看</a></td>
						<td><a href="users!delete.action?users.id=<%=user.getId()%>">删除</a></td>
					</tr>
					<%
						i++;
						}
					%>

				</table>
				<a href="../index.jsp">首页</a>
			</center>
		</div>
	</div>
</body>
</html>