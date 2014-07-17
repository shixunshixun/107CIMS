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
	<meta http-equiv="description" content="PartitionSearch">

	<link href="css/bootstrap.css" rel="stylesheet"/>
  	<link href="css/bootstrap-responsive.css" rel="stylesheet"/>
  	<script src="js/jquery-1.11.1.min.js"></script>
  	<script src="js/bootstrap.js"></script>
  	
  	<script>
  		function partitiondelmsg(){
  			if (confirm("您确认要删除所选信息吗？"))
  			document.partitionForm.submit()
  		}
  		function partitionexpmsg(){
  			if (confirm("您确定要导出所选信息吗？"))
  			document.partitionForm.submit()
  		}
  	</script>
</head>

<body>
	<div class="container">
    	<s:form name="partitionForm" action="PartitionSearchAction">
      	<div>
        	<input type="text" value="教学楼名称" name="buildingname" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="教室编号" name="serialnumber" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最少上课人数" name="minclassnum" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最多上课人数" name="maxclassnum" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最少考试人数" name="minexamnum" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最多考试人数" name="maxexamnum" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最少有效座位数" name="minavailableseat" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最多有效座位数" name="maxavailableseat" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="开始周" name="beginweek" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="结束周" name="endweek" style="height:30px" onclick="this.value='';focus()">
        	<select name="departmentname" id="departmentname">
          		<option>教务处</option>
          		<option>学生会</option>
          		<option>教务处</option>
        	</select>
        	<select name="pyear" id="pyear">
          		<option>2012-2013</option>
          		<option>2013-2014</option>
          		<option>2014-2015</option>
        	</select>
        	<select name="pterm" id="pterm">
          		<option>第一学期</option>
          		<option>第二学期</option>
          		<option>第三学期</option>
        	</select>  
        	<select name="type" id="type">
          			<option>语音室</option>
          			<option>多媒体教室</option>
        	</select> 
        	<select name="pisused" id="pisused">
          			<option>0</option>
          			<option>1</option>
        		</select>    	
        	<button style="height:30px" type="submit" class="btn btn-primary">查询</button>
      	</div>
      	</s:form>
		<s:actionerror/>
      	
      	
        
      	<s:form name="partitionForm" action="partitionDelete">
      	<s:if test="partitionlst!=null">
        	<table class="table">
          		<thead>
            		<tr>
            		<th>&nbsp;</th>
        			<th>学年</th>
              		<th>学期</th>
              		<th>教学楼</th>
              		<th>教室</th>
              		<th>划归部门</th>
              		<th>教室类型</th>
              		<th>有效座位</th>
              		<th>上课人数</th>
              		<th>考试人数</th>
              		<th>开始周</th>
              		<th>结束周</th>
              		<th>是否启用</th>
            		</tr>
          		</thead>
          		<tbody>
          			<s:iterator value="partitionlst" status="partition">
          				<tr>
          					<td><input type="checkbox" name="partitionid" value='<s:property value="pId" />' />
          					<td><s:property value="pYear"></s:property>
							<td><s:property value="pTerm"></s:property>
							<td><s:property value="buildingName"></s:property>
							<td><s:property value="clsSerialNumber"></s:property>
							<td><s:property value="pDepartment"></s:property>
							<td><s:property value="clsType"></s:property>
							<td><s:property value="clsAvailableSeatNum"></s:property>
							<td><s:property value="pClassNum"></s:property>
							<td><s:property value="pExamNum"></s:property>
							<td><s:property value="pBeginWeek"></s:property>
							<td><s:property value="pEndWeek"></s:property>
							<td><s:property value="pIsUsed"></s:property>
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
        	<button type="submit" class="btn btn-primary" onclick="partitiondelmsg();">删除</button>
        	<a href="#import" data-toggle="modal" class="btn btn-primary">导入</a>
        	<button type="submit" class="btn btn-primary" onclick="partitionexpmsg();">导出</button>
        </s:if>
        </s:form>
        <s:actionerror/>	
   
    	<div class="modal hide" id="new">
    		<s:form name="partitionForm" action="PartitionCreateAction">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>新增教学楼</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" value="教学楼名称" name="partitionname" style="height:30px" onclick="this.value='';focus()">
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
    		<s:form name="partitionForm" action="partitionUpdate">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>修改教学楼信息</h4>
      			</div>
      			<div class="modal-body">
      			<s:iterator value="partitionlst" status="partition">
        			<input type="text" value='<s:property value="partitionName" />' name="partitionname" style="height:30px" onclick="this.value='';focus()" />
        			<input type="text" value='<s:property value="partitionSimpleName" />' name="simplename" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value='<s:property value="partitionFloorNum"></s:property>' name="floor" style="height:30px" onclick="this.value='';focus()">
        			<input type="hidden" value='<s:property value="partitionId" />' name="partitionid" style="height:30px" onclick="this.value='';focus()">
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
</body>
</html>