<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>struts2Action</title>
</head>
<body>
  
  <form action="<%=path %>/loginAction.action" method="post"> 
   		pusername:<input type="text" name="username"><br>
   		password:<input type="password" name="password"><br>
   		<input type="submit" value="tijiao">
   </form> 
   
   	<h1>anther mode</h1>
   	<form action="<%=path %>/muserlogin.action" method="post">
   		username:<input type="text" name="username"><br>
   		password:<input type="password" name="password"><br>
   		<input type="submit" value="tijiao">
   	</form>
   	
   	<h1>anther mode</h1>
   	<s:form namespace="/userlogin" action="suserlogin" method="post">
   		<s:textfield name = "us.username"/>用户名：
   		<s:password name = "us.password"/>密码：
   		<s:submit value="提交"  />
   	</s:form>
   
   
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form">
				<div class="form-group">
					 <label for="exampleInputEmail1">Email address</label><input type="email" class="form-control" id="exampleInputEmail1" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" />
				</div>
				<div class="form-group">
					 <label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />
					<p class="help-block">
						Example block-level help text here.
					</p>
				</div>
				<div class="checkbox">
					 <label><input type="checkbox" />Check me out</label>
				</div> <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</div>
   
</body>
</html>