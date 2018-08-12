<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
<script type="text/javascript" charset="utf-8" src="ueditor1_4_3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor1_4_3/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<div align="center">
<h3>企业日常管理系统</h3>
</div>
<a href="GetMessageList">主页</a>
<h2 align="center">${message.messageTitle }</h2>
${message.messageContent }
<div align="right">发布人ID：${message.employeeID }发布时间：${message.publishTime }</div>
<div align="left">
<p>回复</p>
<p><font color="red">${error }</font></p>
<form action="CommitReply" method="post">
<script id="editor" type="text/plain" style="width:1024px;height:200px;"></script>
<input type="hidden" name="messageID" value="${message.messageID }">
    <input type="submit" value="提交">
</form>
<hr>
<c:forEach items="${replies }" var="reply">
<div>
${reply.replyContent }
<div align="right">
回复人ID：${reply.employeeID }
回复时间：${reply.replyTime }
</div>
<hr>
</div>
</c:forEach>
<div align="center"> 
第<c:forEach varStatus="stat" begin="1" end="${page.totalPage }">
<a href="GetMessage?messageID=${message.messageID }&currentPage=${stat.index}">${stat.index }</a>
</c:forEach>页
</div>
</div>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
</script>
</body>
</html>