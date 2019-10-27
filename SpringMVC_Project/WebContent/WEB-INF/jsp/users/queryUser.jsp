<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询列表</title>
</head>
<body>
	<form action="findUserByCondition.action" method="post">
		用户名：<input type="text" name="username" />&nbsp;&nbsp;
		性别：<input type="text" name="gender" />
		<input type="submit" value="查找" />
	</form>
	<hr/>
	<h2>搜索结果</h2>
	<table width="300px;" border=1>
		<tr>
			<td>顾客名</td>
			<td>性别</td>
			<td>电子邮箱</td>
			<td>省会</td>
			<td>城市</td>
		</tr>
		
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
