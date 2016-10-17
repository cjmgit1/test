<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="Show?method=Add" method="post">
			<table width="60%"  style="background: activeborder">
				<Tr>
					<Td>主  题</Td><Td colspan="2">
						<input type="text" name="title">
						<input type="hidden" name="hid" value="${u.id }">
					</Td>
				</Tr>
				<Tr>                                                         
					<Td>内  容</Td><Td colspan="2">
					<textarea rows="10" cols="30" name="neirong">
					
					
					</textarea>
					</Td>
				</Tr>
				<Tr>
					<TD colspan="3">
						
					</TD>
				</Tr>
				
				<Tr>
					<Td><input type="submit" value="提交"/><Td>
					<td>
						<input type="button" value="返回">
					</Td>
					<Td align="left"></Td>
				</Tr>
			</table>
		<form>
  </body>
</html>
