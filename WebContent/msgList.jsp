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
<div align="center">
<h3>企业日常管理系统</h3>
</div>
<div style="width: 20%; height:100%; float: left;">
<jsp:include page="index.jsp"></jsp:include>
</div>
<div style="width: 80%;height:100%;">
<br>
<c:forEach items="${requestScope.messages }" var="message">
<dt>>><a href="GetMessage?messageID=${message.messageID }">${message.messageTitle }</a></dt>
<dd><div align="right">发布人ID：${message.employeeID }发布时间：${message.publishTime }</div></dd>
</c:forEach>
<div align="center">
<c:choose>
<c:when test="${page.hasPrePage }">
<a href="GetMessageList?currentPage=1">首页</a>|
<a href="GetMessageList?currentPage=${page.currentPage-1 }">上一页</a>
</c:when>
<c:otherwise>
首页|上一页
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${page.hasNexPage }">
<a href="GetMessageList?currentPage=${page.currentPage+1 }">下一页</a>|
<a href="GetMessageList?currentPage=${page.totalPage}">尾页</a>
</c:when>
<c:otherwise>
下一页|尾页
</c:otherwise>
</c:choose>
当前为第${page.currentPage }页，共${page.totalPage }页
</div>
</div>

</body>
</html>