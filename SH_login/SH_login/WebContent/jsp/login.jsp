<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<div id="div_bg">
		<div id="div_context">
			<h2>欢迎登录</h2>
			<form action="users!login.action" method="post">
				<center>
					<table style="width: 260px; display: block;">
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
							<td colspan="2"><input type="submit" value="登录" class="sub"></td>
						</tr>
					</table>

				</center>


			</form>
		</div>
	</div>
</body>
</html>