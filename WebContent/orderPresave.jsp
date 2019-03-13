<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="order!save">
<p>${title}</p>
 <table>
	<tr>
		<td>商品：</td>
		<td><input type="text" id="username" name="order.goods" value="${order.goods}"/></td>
	</tr>
	<tr>
		<td>价格：</td>
		<td><input type="text" id="level" name="order.prices" value="${order.prices}"/></td>
	</tr>
	<tr>
		<td>数量：</td>
		<td><input type="text" id="status" name="order.num" value="${order.num}"/></td>
	</tr>
	<tr>
		<td>状态：</td>
		<td><input type="text" id="status" name="order.orderStatus" value="${order.orderStatus}"/></td>
	</tr>
		<tr>
		<td>用户ID：</td>
		<td><input type="text" id="status" name="order.user.userId" value="${order.user.userId}"/></td>
	</tr>
	<tr>
		<td>
			<input type="hidden" id="orderId" name="orderId" value="${order.orderId}"/>
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