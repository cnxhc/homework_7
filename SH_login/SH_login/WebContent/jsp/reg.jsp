<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<div id="div_bg">
		<div id="div_context">
			<h2>欢迎注册</h2>
			<form action="users!register.action" method="post">
				<center>
					<table style="width:260px;display:block;">
						<tr>
							<td>用户名:</td>
							<td><input type="text" name="users.user_name"
								required="required" autofocus="autofocus"></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input type="password" name="users.password"
								required="required"></td>
						</tr>
						<tr>
							<td>真实姓名:</td>
							<td><input type="text" name="users.real_name"
								required="required"></td>
						</tr>
						<tr>
							<td>年龄:</td>
							<td><input type="number" name="users.age"
								required="required"></td>
						</tr>
						<tr>
							<td>手机号:</td>
							<td><input type="number" name="users.phone_num"
								required="required"></td>
						</tr>
						<tr>
							<td>地址:</td>
							<td><input type="text" name="users.address"
								required="required"></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="注册" class="sub"></td>
						</tr>
					</table>
				</center>
			</form>
		</div>
	</div>
</body>
</html>