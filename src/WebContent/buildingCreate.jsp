<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>Struts Test</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="easyTalk">
	<meta http-equiv="description" content="BuildingCreate">
</head>
<body>
	<s:form name="buildingCreateForm" action="BuildindCreateAction">
		<s:textfield name="buildingname" label="buildingname"></s:textfield>
		<s:textfield name="departmentname" label="departmentname"></s:textfield>
		<s:textfield name="simplename" label="simplename"></s:textfield>
		<s:textfield name="compus" label="compus"></s:textfield>
		<s:textfield name="floor" label="floor"></s:textfield>
		<s:submit label="create"></s:submit>
	</s:form>
	<s:text name="ADDSUCCESS">ADDSUCCESS</s:text>
	<s:actionerror/>
</body>
</html>