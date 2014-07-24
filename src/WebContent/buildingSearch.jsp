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
  	
</head>

<body>
	<div class="container" style="height:500px;">
		<form id="searchform" name="buildingForm">
        <div>
        	<label>教学楼名称</label>
        	<input type="text" name="buildingName">
        	<label>教学楼简称</label>
        	<input type="text" name="buildingSimpleName">
        	<label>校区</label>
        	<select name="buildingCompus">
        		<option></option>
          		<option>东校区</option>
          		<option>南校区</option>
          		<option>北校区</option>
        	</select>
        	<label>单位</label>
        	<select name="buildingDepartment">
        		<option></option>
          		<option>教务处</option>
          		<option>教务处</option>
          		<option>教务处</option>
        	</select>
        	
      	</div>
      	</form>
      	<button style="height:30px;margin-bottom:10px;float:right" id="search" class="btn btn-primary">查询</button>
      	<div id="result"></div>
      	<div>
      		<button href="#create" style="height:30px" data-toggle="modal" class="btn btn-primary">新增</button>
      		<button id="del" style="height:30px" data-toggle="modal" class="btn btn-primary">删除</button>
      		<div class="modal hide" id="create">
    		<form name="createForm" id="createform">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>新增教学楼</h4>
      			</div>
      			<div class="modal-body">
      				<ul>
						<li>
						<label>教学楼名称：</label>
						<input type="text" name="buildingName">
						</li>
						<li>
						<label>教学楼简称：</label>
						<input type="text" name="buildingSimpleName">
						</li>
						<li>
						<label>楼&nbsp;&nbsp;&nbsp;层&nbsp;&nbsp;&nbsp;数&nbsp;：</label>
						<input type="text" name="buildingFloorNum">
						</li>
						<li>
						<label>校区：</label>
						<select name="buildingCompus" id="compus">
							<option>东校区</option>
							<option>南校区</option>
							<option>北校区</option>
						</select>
						</li>
						<li>
						<label>单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：</label>
						<select name="buildingDepartment" id="departmentname">
							<option>教务处</option>
							<option>教务处</option>
							<option>教务处</option>
						</select>
						</li>
        			</ul>
      			</div>
      			<div class="modal-footer">
        			<button id="new" type="button" class="btn btn-primary">确定</button>
      			</div>
      			</form>
      		</div>
      		
      		<div class="modal hide" id="updatediv">
    		<form name="updateForm" id="updateform">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>修改教学楼</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" id="updatebuildingname" name="buildingName" style="height:30px" onclick="focus()">
        			<input type="text" id="updatebuildingsimplename" name="buildingSimpleName" style="height:30px" onclick="focus()">
        			<input type="text" id="updatebuildingfloor" name="buildingFloorNum" style="height:30px" onclick="focus()">
        			<input type="hidden" id="updatebuildingid" name="buildingId" >
        			<select name="buildingCompus" id="updatebuildingcompus">
          				<option>东校区</option>
          				<option>南校区</option>
          				<option>北校区</option>
        			</select>
        			<select name="buildingDepartment" id="updatebuildingdepartmentn">
          				<option>教务处</option>
          				<option>教务处</option>
          				<option>教务处</option>
        			</select>
      			</div>
      			<div class="modal-footer">
        			<button id="update" type="button" class="btn btn-primary">确定</button>
      			</div>
      			</form>
      		</div>
    	</div>
    </div>
    <script type="text/javascript">
    	function updatebuilding(i,name,simplename,compus,department,floor) {
    		$("#updatebuildingid").val(i);
    		$("#updatebuildingname").val(name);
    		$("#updatebuildingsimplename").val(simplename);
    		$("#updatebuildingcompus").val(compus);
    		$("#updatebuildingdepartment").val(department);
    		$("#updatebuildingfloor").val(floor);
    	}
//     	function getchange() {
//     		$("#updatebuildingname").change($(this).val());
//     		$("#updatebuildingsimplename").val(this.val);
//     	}

		$("#search").click(
			function() {
				var str="<form id=\"deleteform\"><table class=\"table\"><thead><tr><th>&nbsp;</th><th>名称</th><th>简称</th><th>所属校区</th><th>所属单位</th><th>总楼层数</th></tr></thead><tbody>";
				$.ajax({
					url:"/cims107/BuildingSearch",
					async:false,
					data: $("#searchform").serialize()
						}).done(
					function(data){
						if (data.length!=0)
						{
							var building = jQuery.parseJSON(data)
							console.log(data);
							
							$.each(building,function(i,building){
								str+=("<tr><td><input id=\"check\" type=\"checkbox\" name=\"buildingid\" value="
										+building.buildingId+"></td><td>"+String(building.buildingName)+"</td><td>"
										+building.buildingSimpleName+"</td><td>"+building.buildingDepartment+"</td><td>"
										+building.buildingCompus+"</td><td>"+building.buildingFloorNum+
										"</td><td><button href=\"#updatediv\" id=\"updateid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"updatebuilding("+building.buildingId+",'"+building.buildingName+"','"+building.buildingSimpleName+"','"+building.buildingCompus+"','"+building.buildingDepartment+"',"+building.buildingFloorNum+")\">修改</button></td></tr>");					        
					        });
							str+=("</table></form>");
							document.getElementById('result').innerHTML=str;
							//document.getElementById('result').innerHTML=<button href="#del" style="height:30px" data-toggle="modal" class="btn btn-primary">删除</button>;
						}	
					}	
				);
				
			});
		
		$("#new").click(
				function() {
					$.ajax({
						url:"/cims107/BuildingCreate",
						async:false,
						data: $("#createform").serialize(),
						success: function(result) 
            			{
							alert("添加成功！");
            			}}
					);
					
				});
		$("#del").click(
				function() {
					if (confirm("您确认要删除所选信息吗？")){
						$.ajax({
							url:"/cims107/BuildingDelete",
							async:false,
							data:$("#deleteform").serialize(),
							success: function(result) 
            				{
								alert("删除成功！");
            				}}
						);
					}
				});
		$("#update").click(
			function() {
					/*$('#check').on('click', '#updateid', function() { 
					    window.s = $(this).parent().parent().find("input").val();
					});*/
						
					//	$(this).parent().html("<a href=javascript:  class=save>保存</a>")
					//$("#update").load("#updatediv");
					console.log($("#updateform").serialize());
					$.ajax({
						url:"/cims107/BuildingUpdate",
						async:false,
						data: $("#updateform").serialize(),
						success: function(result) 
            			{
							alert("修改成功！");
            			}}
					);
					
				});
	</script>
</body>
</html>