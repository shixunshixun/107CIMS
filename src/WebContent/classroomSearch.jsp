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
	<meta http-equiv="description" content="ClassroomSearch">

	<link href="css/bootstrap.css" rel="stylesheet"/>
  	<link href="css/bootstrap-responsive.css" rel="stylesheet"/>
  	<script src="js/jquery-1.11.1.min.js"></script>
  	<script src="js/bootstrap.js"></script>
</head>

<body>
	<div class="container">
    		<form id="searchform" name="classroomform">
      		<div>
        		<input type="text" value="教学楼名称" name="buildingname" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="教室编号" name="clsSerialNumber" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="教室楼层" name="clsFloor" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="最少上课人数" name="minClassNum" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="最多上课人数" name="maxClassNum" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="最少考试人数" name="minExamNum" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="最多考试人数" name="maxExamNum" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="面积" name="area" style="height:30px" onclick="this.value='';focus()">
        		<select name="compus" id="compus">
        			<option></option>
          			<option>东校区</option>
          			<option>南校区</option>
          			<option>北校区</option>
        		</select>
        		<select name="departmentname" id="departmentname">
        			<option></option>
          			<option>教务处</option>
          			<option>教务处</option>
          			<option>教务处</option>
        		</select>
        		<select name="clsType" id="type">
        			<option></option>
          			<option>语音室</option>
          			<option>多媒体教室</option>
        		</select>
        		<select name="clsLocation" id="location">
        			<option></option>
          			<option>东南</option>
          			<option>西北</option>
        		</select>
        		<select name="clsIsAmphi" id="isamphi">
        			<option></option>
          			<option>1</option>
          			<option>2</option>
        		</select>
        		<select name="clsShape" id="shape">
        			<option></option>
          			<option>扇形</option>
          			<option>矩形</option>
        		</select>
        		<select name="clsHasMicrophone" id="hasmicrophone">
        			<option></option>
          			<option>1</option>
          			<option>2</option>
        		</select>
        		<select name="clsUsage" id="usage">
        			<option></option>
          			<option>上课</option>
          			<option>语音</option>
        		</select>
        		<select name="clsIsUsed" id="isused">
        			<option></option>
          			<option>1</option>
					<option>2</option>
        		</select>
        		
      		</div>
      		</form>
			<button style="height:30px;margin-bottom:10px" id="search" class="btn btn-primary">查询</button>
      		<div id="result"></div>
        		<button href="#clsnew" data-toggle="modal" class="btn btn-primary">新增</button>
        		<button id="del" style="height:30px" data-toggle="modal" class="btn btn-primary">删除</button>

    		<div class="modal hide" id="clsnew">
    			<form name="createForm" id="createform">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>新增教室</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" value="教学楼名称" name="buildingName" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="教室编号" name="clsSerialNumber" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="教室楼层" name="clsFloor" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="上课人数" name="clsClassNum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="考试人数" name="clsExamNum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="最长行座位数" name="clsMaxRow" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="最宽列座位数" name="clsMaxCol" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="横走廊位置" name="clsHCorridorLocate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="竖走廊位置" name="clsVCorridorLocate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="面积" name="clsArea" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="总座位数" name="clsSeatNum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="有效座位数" name="clsAvailableSeatNum" style="height:30px" onclick="this.value='';focus()">
        			<select name="buildingCompus" id="compus">
						<option></option>
						<option>东校区</option>
						<option>南校区</option>
						<option>北校区</option>
					</select>
					<select name="buildingDepartment" id="departmentname">
						<option></option>
						<option>教务处</option>
						<option>教务处</option>
						<option>教务处</option>
					</select>
					<select name="clsType" id="type">
						<option></option>
						<option>语音室</option>
						<option>多媒体教室</option>
					</select>
					<select name="clsLocation" id="location">
						<option></option>
						<option>东南</option>
						<option>西北</option>
					</select>
					<select name="clsIsAmphi" id="isamphi">
						<option></option>
						<option>1</option>
						<option>2</option>
					</select>
					<select name="clsShape" id="shape">
						<option></option>
						<option>扇形</option>
						<option>矩形</option>
					</select>
					<select name="clsHasMicrophone" id="hasmicrophone">
						<option></option>
						<option>1</option>
						<option>2</option>
					</select>
					<select name="clsUsage" id="usage">
						<option></option>
						<option>上课</option>
						<option>语音</option>
					</select>
					<select name="clsIsUsed" id="isused">
						<option></option>
						<option>1</option>
						<option>2</option>
					</select>
				</div>
				<div class="modal-footer">
        			<button id="new" type="button" class="btn btn-primary">确定</button>
      			</div>
      			</form>
    		</div>

        	<div class="modal hide" id="clsupdate">
    			<form name="updateForm" id="updateform">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>修改教室信息</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" name="buildingName" id="updatebuildingname" style="height:30px" onclick="focus()">
        			<input type="text" name="clsSerialNumber" id="updateserialnumber" style="height:30px" onclick="focus()">
        			<input type="text" name="clsFloor" id="updatefloor" style="height:30px" onclick="focus()">
        			<input type="text" name="clsClassNum" id="updateclassnum" style="height:30px" onclick="focus()">
        			<input type="text" name="clsExamNum" id="updateexamnum" style="height:30px" onclick="focus()">
        			<input type="text" name="clsMaxRow" id="updatemaxrow" style="height:30px" onclick="focus()">
        			<input type="text" name="clsMaxCol" id="updatemaxcol" style="height:30px" onclick="focus()">
        			<input type="text" name="clsHCorridorLocate" id="updatehcorridorlocate" style="height:30px" onclick="focus()">
        			<input type="text" name="clsVCorridorLocate" id="updatevcorridorlocate" style="height:30px" onclick="focus()">
        			<input type="text" name="clsArea" id="updatearea" style="height:30px" onclick="focus()">
        			<input type="text" name="clsSeatNum" id="updateseatnum" style="height:30px" onclick="focus()">
        			<input type="text" name="clsAvailableSeatNum" id="updateavailableseatnum" style="height:30px" onclick="focus()">
        			<input type="hidden" name="clsId" id="updateclsid" style="height:30px" onclick="focus()">
        			<select name="buildingCompus" id="updatecompus">
        				<option></option>
          				<option>东校区</option>
          				<option>南校区</option>
          				<option>北校区</option>
        			</select>
        			<select name="buildingDepartment" id="updatedepartmentname">
        				<option></option>
          				<option>教务处</option>
          				<option>教务处</option>
          				<option>教务处</option>
        			</select>
        			<select name="clsType" id="updateclstype">
        			    <option></option>
          				<option>语音室</option>
          				<option>多媒体教室</option>
        			</select>
        			<select name="clsLocation" id="updateclslocation">
        				<option></option>
          				<option>东南</option>
          				<option>西北</option>
        			</select>
        			<select name="clsIsAmphi" id="updateclsisamphi">
        				<option></option>
          				<option>1</option>
          				<option>2</option>
        			</select>
        			<select name="clsShape" id="updateclsshape">
        				<option></option>
          				<option>扇形</option>
          				<option>矩形</option>
        			</select>
        			<select name="clsHasMicrophone" id="updateclshasmicrophone">
        				<option></option>
          				<option>1</option>
          				<option>2</option>
        			</select>
        			<select name="clsUsage" id="updateclsusage">
        				<option></option>
          				<option>上课</option>
          				<option>语音</option>
        			</select>
        			<select name="clsIsUsed" id="updateclsisused">
        				<option></option>
          				<option>1</option>
          				<option>2</option>
        			</select>
      			</div>
      			<div class="modal-footer">
        			<button id="update" type="button" class="btn btn-primary">确定</button>
      			</div>
				</form>
    		</div> 		
    </div>
    <script type="text/javascript">
    	function updatebuilding(i,name,floor,classnum,examnum,maxrow,maxcol,hcorridorlocate,vcorridorlocate,area,seatnum,availableseatnum,compus,departmentname,type,location,isamphi,shape,hasmicrophone,usage,isused) {
    		$("#updateclsid").val(i);
    		$("#updatebuildingname").val(name);
    		$("#updatefloor").val(floor);
    		$("#updateclassnum").val(classnum);
    		$("#updateexamnum").val(examnum);
    		$("#updatemaxrow").val(maxrow);
			$("#updatemaxcol").val(maxcol);
			$("#updatehcorridorlocate").val(hcorridorlocate);
			$("#updatevcorridorlocate").val(vcorridorlocate);
			$("#updatearea").val(area);
			$("#updateseatnum").val(seatnum);
			$("#updateavailableseatnum").val(availableseatnum);
			$("#updatecompus").val(compus);
			$("#updatedepartmentname").val(departmentname);
			$("#updateclstype").val(type);
			$("#updateclslocation").val(location);
			$("#updateclsisamphi").val(isamphi);
			$("#updateclsshape").val(shape);
			$("#updateclshasmicrophone").val(hasmicrophone);
			$("#updateclsusage").val(usage);
			$("#updateclsisused").val(isused);
    	}
//     	function getchange() {
//     		$("#updatebuildingname").change($(this).val());
//     		$("#updatebuildingsimplename").val(this.val);
//     	}

		$("#search").click(
			function() {
				var str="<form id=\"deleteform\"><table class=\"table\"><thead><tr><th>&nbsp;</th><th>教学楼名称</th><th>教室编号</th><th>教室类型</th><th>所属单位</th><th>教室形状</th><th>上课人数</th><th>考试人数</th><th>总座位数</th><th>有效座位数</th><th>最长行座位数</th><th>最宽列座位数</th><th>竖走廊位置</th><th>横走廊位置</th><th>楼层</th><th>是否阶梯教室</th><th>教室用途</th><th>启用标志</th></thead><tbody>";
				$.ajax({
					url:"/cims107/ClassroomSearch",
					async:false,
					data: $("#searchform").serialize()
						}).done(
					function(data){
						if (data.length!=0)
						{
							var classroom = jQuery.parseJSON(data)
							console.log(data);
							
							$.each(classroom,function(i,classroom){
								str+=("<tr><td><input id=\"check\" type=\"checkbox\" name=\"buildingid\" value="
										+classroom.clsId+"></td><td>"+String(classroom.building.buildingName)+"</td><td>"+classroom.clsSerialNumber+"</td><td>"+classroom.clsType+"</td><td>"+classroom.building.buildingDepartment+"</td><td>"+classroom.clsShape+"</td><td>"+classroom.clsClassNum+"</td><td>"+classroom.clsExamNum+"</td><td>"+classroom.clsSeatNum+"</td><td>"+classroom.clsAvailableSeatNum+"</td><td>"+classroom.clsMaxRow+"</td><td>"+classroom.clsMaxCol+"</td><td>"+classroom.clsVCorridorLocate+"</td><td>"+classroom.clsHCorridorLocate+"</td><td>"+classroom.clsFloor+"</td><td>"+classroom.clsIsAmphi+"</td><td>"+classroom.clsUsage+"</td><td>"+classroom.clsIsUsed+"</td><td><button href=\"#updatediv\" id=\"updateid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"updatebuilding("+classroom.clsId+",'"+classroom.building.buildingName+"','"+classroom.clsSerialNumber+"','"+classroom.clsType+"','"+classroom.building.buildingDepartment+"',"+classroom.clsShape+"',"+classroom.clsClassNum+"',"+classroom.clsExamNum+"',"+classroom.clsSeatNum+"',"+classroom.clsAvailableSeatNum+"',"+classroom.clsMaxRow+"',"+classroom.clsMaxCol+"',"+classroom.clsVCorridorLocate+"',"+classroom.clsHCorridorLocate+"',"+classroom.clsFloor+"',"+classroom.clsIsAmphi+"',"+classroom.clsUsage+"',"+classroom.clsIsUsed+")\">修改</button></td></tr>");					        
					        });
							str+=("</table></form>");
							document.getElementById('result').innerHTML=str;
							//document.getElementById('result').innerHTML=<button href="#del" style="height:30px" data-toggle="modal" class="btn btn-primary">删除</button>;
						}
						else
							document.getElementById('result').innerHTML=null;
					}	
				);
				
			});
		
		$("#new").click(
				function() {
					$.ajax({
						url:"/cims107/ClassroomCreate",
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
							url:"/cims107/ClassroomDelete",
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
						url:"/cims107/ClassroomUpdate",
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