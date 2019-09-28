<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<h1>注册用户</h1>
	<table  border=1>
		<tr>
			<td>顾客名</td>
			<td>性别</td>
			<td>电子邮箱</td>
			<td>省会</td>
			<td>城市</td>
		</tr>
		<!-- 使用JSTL的c标签来遍历服务端的用户表数据userList -->
		<c:forEach items="${userList }" var="user">
			<tr>
				<td>${user.username }</td>
				<td>${user.gender }</td>
				<td>${user.email }</td>
				<td>${user.province }</td>
				<td>${user.city }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
