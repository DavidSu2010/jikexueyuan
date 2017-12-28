<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
  </head>
  
  <body>
    	<s:form namespace="/userlogin" action="loginAction" method="post">
   			<s:label value = "登录信息"/><br/>
   			<s:label value = "用户名："/><s:textfield name="us.username" /><br/>
			<s:label value = "密码："/><s:password name="us.password" /><br/>
   			<s:submit value="登录"  />
   		</s:form>
  </body>
</html>
