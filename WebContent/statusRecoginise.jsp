<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>身份识别*登录状态确认</title>
</head>
<body>
<div align="center">
<h3>企业日常管理系统</h3>
</div>
<div>
<font color="red">${requestScope.error}</font>
<form action="StatusRecoginise" method="post">
<p>员工编号：<input type="text" name="employeeID" value="${param.employeeID }"></p>
<p>系统口令：<input type="password" name="password"></p>
<p><input type="submit" value="提交"><input type="reset" value="重置">
<a href="GetMessageList" style="color:red">暂不登陆</a></p>
</form>
</div>
</body>
</html>