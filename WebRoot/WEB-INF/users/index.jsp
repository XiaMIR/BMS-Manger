<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>图书管理信息系统-作者管理</title>
<link rel=stylesheet href="${pageContext.request.contextPath}/inc/main.css" type="text/css">
<style type="text/css">
</style>
</head>
<body>
	<!-- 引入head.jsp文件 -->
	<%@include file="/inc/head.jsp"%>
	<table align="center" width="980">
		<tr>
			<td align="right"><a href="#">添加用户</a></td>
		</tr>
	</table>
	<table align="center" width="980" class="head" cellpadding="0"
		cellspacing="0">
		<caption>用户列表</caption>
		<tr>
			<th width="150">用户ID</th>
			<th width="300">登录帐户</th>
			<th width="300">真实姓名</th>
			<th width="230">操作</th>
		</tr>
		<c:if test="${not empty requestScope.users}">
			<c:forEach items="${requestScope.users }" var="user"
				varStatus="status">
				<tr>
					<td>${ status.index+1}</td>
					<td>${ user.userName}</td>
					<td>${ user.realName}</td>
					<td>
					删除 修改
					</td>

				</tr>

			</c:forEach>
		</c:if>
		<c:if test="${cur }"></c:if>
	</table>
	
</body>
</html>