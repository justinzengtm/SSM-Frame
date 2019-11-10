<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
	<from action="login.action" method="post">
		用户名：<input type="text" name="username" /></br>
		密码：    &nbsp;&nbsp;&nbsp;<input type="password" name="password" /></br>
		<input type="submit" value="登录"/>
		<!-- 显示校验错误信息 -->
		<c:if test="${allErrors != null }">
			<c:forEach items="${allErrors}" var="error">
				</br><font color="red">${error.defaultMessage}</font>
			</c:forEach>
		</c:if>
	</from>
</body>
</html>
