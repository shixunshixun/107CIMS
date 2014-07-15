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
	<meta http-equiv="description" content="BuildingImport">
</head>
<body>
	<s:form name="buildingImportForm" action="BuildindImportAction" enctype="multipart/form-data">
		<s:file label="import" theme="simple" name="import"></s:file>
		<s:submit label="import"></s:submit>
	</s:form>
	<s:actionerror/>
</body>
</html>