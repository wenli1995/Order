<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function deleteOrder(orderId){
		if(confirm("确定删除这条记录吗")){
			$.post("order!delete",{orderId:orderId},function(result){
				var result=eval('('+result+')');
				if(result.error){		
					alert(result.error);
				}else{
					alert("删除成功");
					window.location.href="${pageContext.request.contextPath}/order!list";
				}
			});
		}
	}
</script>
</head>
<body>
<div class="querydiv">
 <form method="post" action="order!list">
	商品：<input type="text" name="qryOrder.goods" value="${qryOrder.goods}"/>
	订单状态：<input type="text" name="qryOrder.orderStatus" value="${qryOrder.orderStatus}"/>
	用户名称：<input type="text" name="qryOrder.user.username" value="${qryOrder.user.username}"/>
	<button type="submit" class="btn btn-primary">查询</button>
 </form>
</div>
<div class="adddiv">
<button type="button" class="btn btn-primary" onclick="javascript:window.location='order!preSave'">添加订单信息</button>
</div>
<table class="table">
  <tr>
  	<th>序号</th>
  	<th>商品</th>
  	<th>数量</th>
  	<th>价格</th>
  	<th>订单状态</th>
  	<th>订单用户名称</th>
  </tr>
  <c:forEach var="item" items="${orderlist}">
  <tr>
  	<td>${item.orderId}</td>
  	<td>${item.goods}</td>
  	<td>${item.num}</td>
  	<td>${item.prices}</td>
  	<td>${item.orderStatus}</td>
  	<td>${item.user.username}</td>
  	<td>
  		<button type="button" class="btn btn-primary" onclick="javascript:window.location='order!preSave?orderId=${item.orderId}'">修改</button>&nbsp;&nbsp;
  		<button type="button" class="btn btn-default" onclick="deleteOrder('${item.orderId}')">删除</button>
  	</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>