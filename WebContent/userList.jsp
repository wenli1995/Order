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
	function deleteUser(userId){
		if(confirm("确定删除这条记录吗")){
			$.post("user!delete",{userId:userId},function(result){
				var result=eval('('+result+')');
				if(result.error){		
					alert(result.error);
				}else{
					alert("删除成功");
					window.location.href="${pageContext.request.contextPath}/user!list";
				}
			});
		}
	}
</script>
</head>
<body>
<div class="querydiv">
 <form method="post" action="user!list">
	昵称：<input type="text" name="qryUser.username" value="${qryUser.username}"/>
	等级：<input type="text" name="qryUser.level" value="${qryUser.level}"/>
	状态：<input type="text" name="qryUser.status" value="${qryUser.status}"/>
	<button type="submit" class="btn btn-primary">查询</button>
 </form>
</div>
<div class="adddiv">
<button type="button" class="btn btn-primary" onclick="javascript:window.location='user!preSave'">添加用户信息</button>
</div>
<table class="table">
  <tr>
  	<th>序号</th>
  	<th>昵称</th>
  	<th>等级</th>
  	<th>状态</th>
  	<th>操作</th>
  </tr>
  <c:forEach var="userItem" items="${userlist}">
  <tr>
  	<td>${userItem.userId}</td>
  	<td>${userItem.username}</td>
  	<td>${userItem.level}</td>
  	<td>${userItem.status}</td>
  	<td>
  		<button type="button" class="btn btn-primary" onclick="javascript:window.location='user!preSave?userId=${userItem.userId}'">修改</button>&nbsp;&nbsp;
  		<button type="button" class="btn btn-default" onclick="deleteUser('${userItem.userId}')">删除</button>
  	</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>