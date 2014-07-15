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

	<link href="css/bootstrap.css" rel="stylesheet"/>
  	<link href="css/bootstrap-responsive.css" rel="stylesheet"/>
  	<script src="js/jquery-1.11.1.min.js"></script>
  	<script src="js/bootstrap.js"></script>

	<script type="text/javascript">
		function deleteBuilding()
		{
			buildingForm.action = "BuildingDeleteAction";
			buildingForm.submit();
		}
		function exportExcel()
		{
			buildingForm.action = "BuildingExportAction";
			buildingForm.submit();
		}
	</script>

	<script type="text/javascript">
		function checkAll()
		{
			var listc = document.getElementsByName("buildingid");
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
	<div class="container">
  		<div>
    		<h1 align="center">欢迎进入教室管理系统</h1>
  		</div>
  		<div class="row">
    		<div class="span4">
      			<ul>
        			<li><a href="#manage">教学楼管理</a> </li>
        			<li><a href="#">教室管理</a></li>
        			<li><a href="#">教室划分</a></li>
     	 		</ul>
    		</div>
    	<div class="span6" id="manage">
    		<s:form name="buildingForm" action="BuildingSearchAction">
      		<div>
        		<input type="text" value="教学楼名称" name="" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="教学楼简称" name="" style="height:30px" onclick="this.value='';focus()">
        		<select name="select" id="select">
          			<option value="east">东校区</option>
          			<option value="south">南校区</option>
          			<option value="north">北校区</option>
        		</select>
        		<select id="school">
          			<option value="first">教务处</option>
          			<option value="second">单位二</option>
          			<option value="third">单位三</option>
        		</select>
        		<button style="height:30px" type="submit" class="btn btn-primary">查询</button>
      		</div>
      		<div>
        		<table class="table">
          		<thead>
            		<tr>
            		<th>&nbsp;</th>
        			<th>名称</th>
              		<th>简称</th>
              		<th>所属校区</th>
              		<th>所属单位</th>
              		<th>总楼层数</th>
              		<th><s:checkbox name="CheckAll" id="CheckAll" onclick="checkAll()"/>全选</th>
            		</tr>
          		</thead>
          		
          		<s:iterator value="buildinglst" status="building">
          			<tbody>
          				<tr>			
							<td><s:checkbox id="buildingid" name="buildingId"></s:checkbox></td>
							<td><s:property value="buildingName"></s:property></td>
							<td><s:property value="buildingSimpleName"></s:property></td>
							<td><s:property value="buildingDepartment"></s:property></td>
							<td><s:property value="buildingCompus"></s:property></td>
							<td><s:property value="buildingFloorNum"></s:property></td>
							<td><a href="#update" data-toggle="modal" class="btn btn-primary">修改</a>
						</tr>
					</tbody>		
				</s:iterator>
        		</table>
        	</div>
      		<div class="pagination">
        		<ul>
          			<li class="active"><a href="#">1</a></li>
          			<li><a href="#">2</a></li>
          			<li><a href="#">3</a></li>
          			<li><a href="#">4</a></li>
          			<li><a href="#">5</a></li>
        		</ul>
      		</div>
      		<ul class="pager">
        		<li><a href="#">前一页</a></li>
        		<li><a href="#">后一页</a></li>
      		</ul>
        	<a href="#new" data-toggle="modal" class="btn btn-primary">新增</a>
        	</s:form>
			<s:actionerror/>

    		<div class="modal hide" id="new">
    			<s:form name="buildingForm" action="BuildindCreateAction">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>新增教学楼</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" value="教学楼名称" name="" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="教学楼简称" name="" style="height:30px" onclick="this.value='';focus()">
        			<select name="select" id="select">
          				<option value="east">东校区</option>
          				<option value="南校区">南校区</option>
          				<option value="north">北校区</option>
        			</select>
        			<select id="school">
          				<option value="教务处">教务处</option>
          				<option value="second">单位二</option>
          				<option value="third">单位三</option>
        			</select>
      			</div>
      			<div class="modal-footer">
        			<button type="button" class="btn btn-primary">确定</button>
      			</div>
      			</s:form>
				<s:actionerror/>
    		</div>


        	<button>删除</button>
        	<button>导入</button>
        	<button>导出</button>
        	
    	</div>
  	</div>
</div>
</body>
</html>