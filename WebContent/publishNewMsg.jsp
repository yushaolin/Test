<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8" src="ueditor1_4_3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor1_4_3/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
<title>在此处插入标题</title>
</head>
<body>
<div align="center">
<h3>企业日常管理系统</h3>
</div>
<a href="GetMessageList">主页</a>
<div>
<p><font color="red">${requestScope.error }</font></p>
<form action="MsgPublish" method="post">
<p>消息标题：<input type="text" name="title" size="50"></p>
消息内容：
<script id="editor" type="text/plain" style="width:1024px;height:200px;"></script>
    <input type="submit" value="编辑完成">
</form>
</div>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
</script>
</body>
</html>