<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<body>
<div>
<c:choose>
<c:when test="${empty sessionScope.employee}">
没有进行身份识别，请先进行身份识别！
<a href="statusRecoginise.jsp">身份验证</a>
</c:when>
<c:otherwise>
<ul>
<li>员工编号：${employee.employeeID }</li>
<li>员工姓名：${employee.employeeName }</li>
<li>员工性别：${employee.employeeSex?"男":"女" }</li>
<li>出生日期：${employee.employeeBirth }</li>
<li>办公室电话：${employee.employeePhone }</li>
<li>住址：${employee.employeePlace }</li>
<li>管理层领导：${employee.isLead()?'是':'否' }</li>
</ul>
<a href="publishNewMsg.jsp">发布消息</a>
</c:otherwise>
</c:choose>
</div>

</body>
</html>