<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="user!save">
<p>${title}</p>
 <table>
	<tr>
		<td>昵称：</td>
		<td><input type="text" id="username" name="user.username" value="${user.username}"/></td>
	</tr>
	<tr>
		<td>等级：</td>
		<td><input type="text" id="level" name="user.level" value="${user.level}"/></td>
	</tr>
	<tr>
		<td>状态：</td>
		<td><input type="text" id="status" name="user.status" value="${user.status}"/></td>
	</tr>
	<tr>
		<td>
			<input type="hidden" id="userId" name="userId" value="${user.userId}"/>
			<button type="submit" class="btn btn-primary">提交</button>
		</td>
		<td>
			<button type="button" class="btn btn-default" onclick="javascript:history.back()">返回</button>
		</td>
	</tr>
 </table>
</form>
</body>
</html>