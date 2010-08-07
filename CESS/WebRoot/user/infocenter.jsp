<%@ page language="java" import="java.util.*" pageEncoding="GB18030" contentType="text/html;charset=GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <meta http-equiv="Content-Type" content="text/html; charset=GB18030">
  </head>
  
  <body>
 用户界面${username}<br/>
 ${locale}
   <br>
   <form action="user.es" method="post"/>
   <input type="text" name="username"  value="hello"/> 
   <input type="submit" name="submit" value="提交" /> 
   </form>
   <s:debug/>
  </body>
</html>
