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
	<meta http-equiv="description" content="BuildingSearch">

	<script type="text/javascript">
		function delete()
		{
			buildingForm.action = "BuildingDeleteAction";
			buildingForm.submit();
		}
		function export()
		{
			buildingForm.action = "BuildingExportAction";
			buildingForm.submit();
		}
	</script>

	<script type="text/javascript">
		function checkAll()
		{
			var listc = document.getElementsByName("listCheck");
			if(document.getElementById("CheckAll").checked==true)
			{
				for(var i=0;i<listc.length;i++)
				{
					listc[i].checked=true;
				}
			}
			else
			{
				for(var i=0;i<listc.length;i++)
				{
					listc[i].checked=false;
				}
			}
		}
	</script>
</head>

<body>
	<s:form name="buildingForm" action="BuildindSearchAction">
		<s:textfield name="buildingname" label="buildingname"></s:textfield>
		<s:textfield name="departmentname" label="departmentname"></s:textfield>
		<s:textfield name="simplename" label="simplename"></s:textfield>
		<s:textfield name="compus" label="compus"></s:textfield>
		<s:submit label="query"></s:submit>
	
		<s:checkbox name="CheckAll" id="CheckAll" onclick="checkAll()"/>全选<br/>
		<s:iterator value="buildinglist" status="building">			
			<s:checkbox id="buildingid" name="buildingid"></s:checkbox>
			<s:property value="building.buildingname"></s:property>
			<s:property value="building.simplename"></s:property>
			<s:property value="building.departmentname"></s:property>
			<s:property value="building.compus"></s:property>
			<s:property value="building.floor"></s:property>
			<s:submit lable="update" onclick="window.location.href='buildingUpdate.jsp'"></s:submit>
			<br/>		
		</s:iterator>

		<s:submit lable="create" onclick="window.location.href='buildingCreate.jsp'"></s:submit>
		<s:submit lable="import" onclick="window.location.href='buildingimport.jsp'"></s:submit>
		<s:submit label="delete" onclick=delete()></s:submit>
		<s:submit label="export" onclick=export()></s:submit>
	</s:form>
	<s:actionerror/>
</body>
</html>