<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<title>图书管理信息系统-登录</title>
<style type="text/css">
table {
	font-size: 12px;
}

table caption {
	font-size: 14px;
}
</style>
<script type="text/javascript">
	function checkForm(myForm) {
		var msg = "";
		var setFocused = false;
		if (myForm.userName.value == "") {
			msg += "帐号不能为空！\n";
			myForm.userName.focus();
			setFocused = true;
		}

		if (myForm.password.value == "") {
			msg += "密码不能为空！\n";
			if (!setFocused) {
				myForm.password.focus();
				setFocused = true;
			}
		}

		if (msg != "") {
			alert(msg);
			return false;
		}

		return true;

	}
</script>
</head>
<body>
	<table align="center">
		<tr>
		<!--EL表大式 ${pageContext.request.contextPath} -->
			<td><img src="${pageContext.request.contextPath}/images/head.jpg">
			</td>
		</tr>
	</table>
	<form action="LoginServlet" name="form1" method="post"
		onsubmit="return checkForm(this);">
		<input type="hidden" name="method" value="login">
		<table align="center">
			<caption>用户登录</caption>
			<tr>
				<td>用户帐号</td>
				<td><input type="text" style="width: 150px" name="userName">
				</td>
			</tr>
			<tr>
				<td>用户密码</td>
				<td><input type="password" style="width: 150px" name="password">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录">
					<input type="reset" value="清空">
					<a href="register.jsp"> 注册</a></td>
			</tr>
			<c:if test="${not empty requestScope.msg }"> 
			<tr>
			<td colspan="2" align="center" > 
			${requestScope.msg}
			</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>