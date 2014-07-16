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
  		function buildingmsg(){
  			if (confirm("您确认要删除所选信息吗？"))
  			document.buildingForm.submit()
  		}
  		function clsmsg(){
  			if (confirm("您确认要删除所选信息吗？"))
  			document.classroomForm.submit()
  		}
  	</script>
</head>

<body>
	<div class="container">
  		<div>
    		<h1 align="center">欢迎进入教室管理系统</h1>
  		</div>
  		<div class="row">
    		<div class="span2">
      			<ul>
        			<li><a href="#buildingmanage">教学楼管理</a> </li>
        			<li><a href="#classroommanage" onclick="document.getElementById('buildingmanage').style.display='none'&document.getElementById('classroommanage').style.display='block'">教室管理</a></li>
        			<li><a href="#">教室划分</a></li>
     	 		</ul>
    		</div>
    	<div class="span8" id="buildingmanage">
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
        		<button type="submit" class="btn btn-primary" onclick="buildingmsg();">删除</button>
        		<a href="#new" data-toggle="modal" class="btn btn-primary">新增</a>
        		<button>导入</button>
        		<button>导出</button>
        	</s:if>
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
    	</div>
    	
    	
    	<div class="span8" id="classroommanage" style="display: none">
    		<s:form name="classroomForm" action="ClassroomSearchAction">
      		<div>
        		<input type="text" value="教学楼名称" name="buildingname" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="教室编号" name="serialnumber" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="教室楼层" name="floor" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="最少上课人数" name="minClassNum" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="最多上课人数" name="maxClassNum" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="最少考试人数" name="minExamNum" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="最多考试人数" name="maxExamNum" style="height:30px" onclick="this.value='';focus()">
        		<input type="text" value="面积" name="area" style="height:30px" onclick="this.value='';focus()">
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
        		<select name="type" id="type">
          			<option>语音室</option>
          			<option>多媒体教室</option>
        		</select>
        		<select name="location" id="location">
          			<option>东南</option>
          			<option>西北</option>
        		</select>
        		<select name="isamphi" id="isamphi">
          			<option>1</option>
          			<option>2</option>
        		</select>
        		<select name="shape" id="shape">
          			<option>扇形</option>
          			<option>矩形</option>
        		</select>
        		<select name="hasmicrophone" id="hasmicrophone">
          			<option>0</option>
          			<option>1</option>
        		</select>
        		<select name="usage" id="usage">
          			<option>上课</option>
          			<option>语音</option>
        		</select>
        		<select name="isused" id="isused">
          			<option>0</option>
          			<option>1</option>
        		</select>
        		<button style="height:30px" type="submit" class="btn btn-primary">查询</button>
      		</div>
      		</s:form>
			<s:actionerror/>
			
      		<s:form name="classroomForm" action="ClassroomDeleteAction">
      			<s:if test="classroomlst!=null">
        		<table class="table">
          		<thead>
            		<tr>
            		<th>&nbsp;</th>
        			<th>教学楼名称</th>
              		<th>教室编号</th>
              		<th>教室类型</th>
              		<th>所属单位</th>
              		<th>教室形状</th>
              		<th>上课人数</th>
              		<th>考试人数</th>
              		<th>总座位数</th>
              		<th>有效座位数</th>
              		<th>最长行座位数</th>
              		<th>最宽列座位数</th>
              		<th>竖走廊位置</th>
              		<th>横走廊位置</th>
              		<th>楼层</th>
              		<th>是否阶梯教室</th>
              		<th>教室用途</th>
              		<th>启用标志</th>
            		</tr>
          		</thead>
          		<s:iterator value="classroomlst" status="classroom">
          			<tbody>
          				<tr>			
							<td><input type="checkbox" name="clsid" value='<s:property value="clsId" />' />
							<td><s:property value="buildingName"></s:property>
							<td><s:property value="clsSerialNumber"></s:property>
							<td><s:property value="clsType"></s:property>
							<td><s:property value="buildingDepartment"></s:property>
							<td><s:property value="clsShape"></s:property>
							<td><s:property value="clsClassNum"></s:property>
							<td><s:property value="clsExamNum"></s:property>
							<td><s:property value="clsSeatNum"></s:property>
							<td><s:property value="clsAvailableSeatNum"></s:property>
							<td><s:property value="clsMaxRow"></s:property>
							<td><s:property value="clsMaxCol"></s:property>
							<td><s:property value="clsVCorridorLocate"></s:property>
							<td><s:property value="clsHCorridorLocate"></s:property>
							<td><s:property value="clsFloor"></s:property>
							<td><s:property value="clsIsAmphi"></s:property>
							<td><s:property value="clsUsage"></s:property>
							<td><s:property value="clsIsUsed"></s:property>
							<td><a href="#clsupdate" data-toggle="modal" class="btn btn-primary">修改</a>
							<td><a href="#seatmanage" data-toggle="modal" class="btn btn-primary">座位维护</a>
						</tr>
					</tbody>		
				</s:iterator>
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
        		<a href="#clsnew" data-toggle="modal" class="btn btn-primary">新增</a>
        		<button type="submit" class="btn btn-primary" onclick="clsmsg();">删除</button>
        		<button>导入</button>
        		<button>导出</button>
        		</s:if>
        	</s:form>
      		
    		<div class="modal hide" id="clsnew">
    			<s:form name="classroomForm" action="ClassroomCreateAction">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>新增教室</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" value="教学楼名称" name="buildingname" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="教室编号" name="serialnumber" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="教室楼层" name="floor" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="上课人数" name="classnum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="考试人数" name="examnum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="最长行座位数" name="maxrow" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="最宽列座位数" name="maxcol" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="横走廊位置" name="hcorridorlocate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="竖走廊位置" name="vcorridorlocate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="面积" name="area" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="总座位数" name="seatnum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="有效座位数" name="availableseatnum" style="height:30px" onclick="this.value='';focus()">
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
        			<select name="type" id="type">
          				<option>语音室</option>
          				<option>多媒体教室</option>
        			</select>
        			<select name="location" id="location">
          				<option>东南</option>
          				<option>西北</option>
        			</select>
        			<select name="isamphi" id="isamphi">
          				<option>1</option>
          				<option>2</option>
        			</select>
        			<select name="shape" id="shape">
          				<option>扇形</option>
          				<option>矩形</option>
        			</select>
        			<select name="hasmicrophone" id="hasmicrophone">
          				<option>0</option>
          				<option>1</option>
        			</select>
        			<select name="usage" id="usage">
          				<option>上课</option>
          				<option>语音</option>
        			</select>
        			<select name="isused" id="isused">
          				<option>0</option>
          				<option>1</option>
        			</select>
      			</div>
      			<div class="modal-footer">
        			<button type="submit" class="btn btn-primary">确定</button>
      			</div>
      			</s:form>
				<s:actionerror/>
    		</div>

        	<div class="modal hide" id="clsupdate">
    			<s:form name="classroomForm" action="classroomUpdate">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>修改教学楼信息</h4>
      			</div>
      			<div class="modal-body">
      			<s:iterator value="classroomlst" status="classroom">
        			<input type="text" value='<s:property value="buildingName"/>' name="buildingname" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsSerialNumber"/>' name="serialnumber" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsFloor"/>' name="floor" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsClassNum"/>' name="classnum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsExamNum"/>' name="examnum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsMaxRow"/>' name="maxrow" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsMaxCol"/>' name="maxcol" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsHCorridorLocate"/>' name="hcorridorlocate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsVCorridorLocate"/>' name="vcorridorlocate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsArea"/>' name="area" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsSeatNum"/>' name="seatnum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="clsAvailableSeatNum"/>' name="availableseatnum" style="height:30px" onclick="this.value='';focus()">
        			<select name="compus" id="compus">
        				<option><s:property value="buildingCompus"/></option>
          				<option>东校区</option>
          				<option>南校区</option>
          				<option>北校区</option>
        			</select>
        			<select name="departmentname" id="departmentname">
        				<option><s:property value="buildingDepartment"/></option>
          				<option>教务处</option>
          				<option>教务处</option>
          				<option>教务处</option>
        			</select>
        			<select name="type" id="type">
        			    <option><s:property value="clsType"/></option>
          				<option>语音室</option>
          				<option>多媒体教室</option>
        			</select>
        			<select name="location" id="location">
        				<option><s:property value="clsLocation"/></option>
          				<option>东南</option>
          				<option>西北</option>
        			</select>
        			<select name="isamphi" id="isamphi">
        				<option><s:property value="clsIsAmphi"/></option>
          				<option>1</option>
          				<option>2</option>
        			</select>
        			<select name="shape" id="shape">
        				<option><s:property value="clsShape"/></option>
          				<option>扇形</option>
          				<option>矩形</option>
        			</select>
        			<select name="hasmicrophone" id="hasmicrophone">
        				<option><s:property value="clsHasMicrophone"/></option>
          				<option>0</option>
          				<option>1</option>
        			</select>
        			<select name="usage" id="usage">
        				<option><s:property value="clsUsage"/></option>
          				<option>上课</option>
          				<option>语音</option>
        			</select>
        			<select name="isused" id="isused">
        				<option><s:property value="clsIsUsed"/></option>
          				<option>0</option>
          				<option>1</option>
        			</select>
        		</s:iterator>
      			</div>
      			<div class="modal-footer">
        			<button type="submit" class="btn btn-primary">确定</button>
      			</div>
      			</s:form>
				<s:actionerror/>
    		</div>
    	</div>
  	</div>
</div>
</body>
</html>