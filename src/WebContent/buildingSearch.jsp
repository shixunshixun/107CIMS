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
  	
  	<script>
  		function buildingdelmsg(){
  			if (confirm("您确认要删除所选信息吗？"))
  			document.buildingForm.submit()
  		}
  		function buildingexpmsg(){
  			buildingForm.action = "BuildingImportAction";
  			if (confirm("您确定要导出所选信息吗？"))
  			document.buildingForm.submit()
  		}
  	</script>
</head>

<body>
	<div class="container">
    	<s:form name="buildingForm" action="BuildingSearchAction">
      	<div>
        	<input type="text" value="教学楼名称" name="buildingname" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="教学楼简称" name="simplename" style="height:30px" onclick="this.value='';focus()">
        	<select name="compus" id="compus">
          		<option>东校区</option>
          		<option>南校区</option>
          		<option>北校区</option>
        	</select>
        	<select name="departmentname" id="departmentname">
          		<option>教务处</option>
          		<option>教务处</option>
          		<option>教务处</option>
        	</select>
        	<button style="height:30px" type="submit" class="btn btn-primary">查询</button>
      	</div>
      	</s:form>
		<s:actionerror/>
      		
      	<s:form name="buildingForm" action="buildingDelete">
      	<s:if test="buildinglst!=null">
        	<table class="table">
          		<thead>
            		<tr>
            		<th>&nbsp;</th>
        			<th>名称</th>
              		<th>简称</th>
              		<th>所属校区</th>
              		<th>所属单位</th>
              		<th>总楼层数</th>
            		</tr>
          		</thead>
          		<tbody>
          			<s:iterator value="buildinglst" status="building">
          				<tr>
          					<td><input type="checkbox" name="buildingid" value='<s:property value="buildingId" />' />
          					<td><s:property value="buildingName"></s:property>
							<td><s:property value="buildingSimpleName"></s:property>
							<td><s:property value="buildingDepartment"></s:property>
							<td><s:property value="buildingCompus"></s:property>
							<td><s:property value="buildingFloorNum"></s:property>
							<td><a href="#update" data-toggle="modal" class="btn btn-primary">修改</a>						
					</s:iterator>	
     			</tbody>
			</table>
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
        	<button type="submit" class="btn btn-primary" onclick="buildingdelmsg();">删除</button>
        	<a href="#import" data-toggle="modal" class="btn btn-primary">导入</a>
        	<button type="submit" class="btn btn-primary" onclick="buildingexpmsg();">导出</button>
        </s:if>
        <s:else>
        	<a href="#new" data-toggle="modal" class="btn btn-primary">新增</a>
        	<a href="#import" data-toggle="modal" class="btn btn-primary">导入</a>
        </s:else>
        </s:form>
      		
   
    	<div class="modal hide" id="new">
    		<s:form name="buildingForm" action="BuildingCreateAction">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>新增教学楼</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" value="教学楼名称" name="buildingname" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="教学楼简称" name="simplename" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="楼层数" name="floor" style="height:30px" onclick="this.value='';focus()">
        			<select name="compus" id="compus">
          				<option>东校区</option>
          				<option>南校区</option>
          				<option>北校区</option>
        			</select>
        			<select name="departmentname" id="departmentname">
          				<option>教务处</option>
          				<option>教务处</option>
          				<option>教务处</option>
        			</select>
      			</div>
      			<div class="modal-footer">
        			<button type="submit" class="btn btn-primary">确定</button>
      			</div>
      		</s:form>
			<s:actionerror/>
    	</div>

        <div class="modal hide" id="update">
    		<s:form name="buildingForm" action="buildingUpdate">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>修改教学楼信息</h4>
      			</div>
      			<div class="modal-body">
      			<s:iterator value="buildinglst" status="building">
        			<input type="text" value='<s:property value="buildingName" />' name="buildingname" style="height:30px" onclick="this.value='';focus()" />
        			<input type="text" value='<s:property value="buildingSimpleName" />' name="simplename" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="buildingFloorNum"></s:property>' name="floor" style="height:30px" onclick="this.value='';focus()">
        			<input type="hidden" value='<s:property value="buildingId" />' name="buildingid" style="height:30px" onclick="this.value='';focus()">
        			<select name="compus" id="compus">
          				<option>东校区</option>
          				<option>南校区</option>
          				<option>北校区</option>
        			</select>
        			<select name="departmentname" id="departmentname">
          				<option>教务处</option>
          				<option>教务处</option>
          				<option>教务处</option>
        			</select>
        		</s:iterator>
      			</div>
      			<div class="modal-footer">
        			<button type="submit" class="btn btn-primary">确定</button>
      			</div>
      		</s:form>
			<s:actionerror/>
    	</div>
    		
    	<div class="modal hide" id="import">
    		<s:form name="buildingImportForm" action="buildingImport" enctype="multipart/form-data">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>导入教学楼信息</h4>
      			</div>
      			<div class="modal-body">
        			
						<s:file label="import" theme="simple" name="import"></s:file>
						<s:submit label="import"></s:submit>
					<s:actionerror/>
      			</div>
      			<div class="modal-footer">
        			<button type="submit" class="btn btn-primary">确定</button>
      			</div>
      		</s:form>
			<s:actionerror/>
    	</div>
    </div>
</body>
</html>