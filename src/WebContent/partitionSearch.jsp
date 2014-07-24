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
</head>

<body>
	<div class="container">
		<form id="searchform" name="partitionForm">
        <div>
        	<input type="text" value="教学楼名称" name="buildingname" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="教室编号" name="serialnumber" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最少上课人数" name="minclassnum" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最多上课人数" name="maxclassnum" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最少考试人数" name="minexamnum" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最多考试人数" name="maxexamnum" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最少有效座位数" name="minavailableseat" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="最多有效座位数" name="maxavailableseat" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="开始周" name="partitionBeginWeek" style="height:30px" onclick="this.value='';focus()">
        	<input type="text" value="结束周" name="partitionEndWeek" style="height:30px" onclick="this.value='';focus()">
        	<select name="partitionDepartment" id="partitionDepartment">
          		<option>教务处</option>
          		<option>学生会</option>
          		<option>教务处</option>
        	</select>
        	<select name="partitionYear" id="partitionYear">
          		<option>2012-2013</option>
          		<option>2013-2014</option>
          		<option>2014-2015</option>
        	</select>
        	<select name="partitionTerm" id="partitionTerm">
          		<option>第一学期</option>
          		<option>第二学期</option>
          		<option>第三学期</option>
        	</select>  
        	<select name="partitionIsUsed" id="partitionIsUsed">
          			<option>0</option>
          			<option>1</option>
        	</select>       	
      	</div>
      	</form>
      	<button style="height:30px;margin-bottom:10px" id="search" class="btn btn-primary">查询</button>
      	
      	<button style="height:30px;margin-bottom:10px" id="searchAll" class="btn btn-primary">查询全部</button>
      	
      	<div id="result"></div>
      	
      	<div>
      		<button href="#create" style="height:30px" data-toggle="modal" class="btn btn-primary">新增</button>
      		<button id="del" style="height:30px" data-toggle="modal" class="btn btn-primary">删除</button>
      		<button id="enable" style="height:30px" data-toggle="modal" class="btn btn-primary">启用</button>
      		<button id="disable" style="height:30px" data-toggle="modal" class="btn btn-primary">停用</button>
      		<div class="modal hide" id="create">
    		<form name="createForm" id="createform">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>教室划分</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" value="教学楼名称" name="buildingname" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="教室编号" name="serialnumber" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="上课人数" name="partitionClassNum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="考试人数" name="partitionExamNum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="最少有效座位数" name="minavailableseat" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="最多有效座位数" name="maxavailableseat" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="开始周" name="partitionBeginWeek" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="结束周" name="partitionEndWeek" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="开始日期" name="partitionBeginDate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="结束日期" name="partitionEndDate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="开始上课时间" name="partitionBeginLession" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" value="结束上课时间" name="partitionEndLession" style="height:30px" onclick="this.value='';focus()">
        			<select name="partitionDepartment">
          				<option>教务处</option>
          				<option>学生会</option>
          				<option>教务处</option>
        			</select>
        			<select name="compus" id="compus">
        				<option></option>
          				<option>东校区</option>
          				<option>南校区</option>
          				<option>北校区</option>
        			</select>
        			<select name="partitionYear">
          				<option>2012-2013</option>
          				<option>2013-2014</option>
          				<option>2014-2015</option>
        			</select>
        			<select name="partitionTerm">
          				<option>第一学期</option>
          				<option>第二学期</option>
          				<option>第三学期</option>
        			</select>  
        			<select name="partitionIsUsed">
          					<option>0</option>
          					<option>1</option>
        			</select>
        			<br/>
        			<s:checkboxlist name="whichday" list="#{'星期一':'1','星期二':'2','星期三':'3','星期四':'4','星期五':'5','星期六':'6','星期日':'7'}" 
          				label="每周使用星期" labelposition="top" listKey="value" listValue="key"> 
       				</s:checkboxlist> 
<!-- 					请选择每周使用星期<br/> -->
<!-- 					<label><input name="whichday" type="checkbox" value="1" />星期一 </label> -->
<!-- 					<label><input name="whichday" type="checkbox" value="2" />星期二 </label> -->
<!-- 					<label><input name="whichday" type="checkbox" value="3" />星期三 </label> -->
<!-- 					<label><input name="whichday" type="checkbox" value="4" />星期四 </label> -->
<!-- 					<label><input name="whichday" type="checkbox" value="5" />星期五 </label> -->
<!-- 					<label><input name="whichday" type="checkbox" value="6" />星期六 </label> -->
<!-- 					<label><input name="whichday" type="checkbox" value="7" />星期日 </label> -->
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
        			<h4>修改教室划分</h4>
      			</div>
      			<div class="modal-body">
        			<input type="text" id="updatepartitionclassnum" name="partitionClassNum" style="height:30px" onclick="this.value='';focus()">       			
        			<input type="text" id="updatepartitionexamnum" name="partitionExamNum" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" id="updatepartitionBeginWeek" name="partitionBeginWeek" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" id="updatepartitionEndWeek" name="partitionEndWeek" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" id="updatepartitionbegindate" name="partitionBeginDate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" id="updatepartitionenddate" name="partitionEndDate" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" id="updatepartitionbeginlession" name="partitionBeginLession" style="height:30px" onclick="this.value='';focus()">
        			<input type="text" id="updatepartitionendlession" name="partitionEndLession" style="height:30px" onclick="this.value='';focus()">
        			<input type="hidden" id="updatepartitionid" name="partitionId">
        			<select name="partitionDepartment" id="updatepartitionDepartment">
          				<option>教务处</option>
          				<option>学生会</option>
          				<option>教务处</option>
        			</select>
        			<select name="partitionYear" id="updatepartitionYear">
          				<option>2012-2013</option>
          				<option>2013-2014</option>
          				<option>2014-2015</option>
        			</select>
        			<select name="partitionTerm" id="updatepartitionTerm">
          				<option>第一学期</option>
          				<option>第二学期</option>
          				<option>第三学期</option>
        			</select>  
        			<select name="partitionIsUsed" id="updatepartitionIsUsed">
          					<option>0</option>
          					<option>1</option>
        			</select>
        			<br/>
        			<s:checkboxlist theme="simple" id="updatepartitionwhichday" name="partitionWhichDay" list="#{'星期一':'1','星期二':'2','星期三':'3','星期四':'4','星期五':'5','星期六':'6','星期日':'7'}" 
         				label="每周使用星期" labelposition="top" listKey="value" listValue="key">
        			</s:checkboxlist>
      			</div>
      			<div class="modal-footer">
        			<button id="update" type="button" class="btn btn-primary">确定</button>
      			</div>
      			</form>
      		</div>
    	</div>
    </div>
    <script type="text/javascript">
    	function updatepartition(i,year,term,department,classnum,examnum,beginweek,endweek,begindate,enddate,beginlession,endlession,isused,whichday) {
    		$("#updatepartitionid").val(i);
    		$("#updatepartitionYear").val(year);
    		$("#updatepartitionTerm").val(term);
    		$("#updatepartitionDepartment").val(department);
    		$("#updatepartitionclassnum").val(classnum);
    		$("#updatepartitionexamnum").val(examnum);
    		$("#updatepartitionBeginWeek").val(beginweek);
    		$("#updatepartitionEndWeek").val(endweek);
    		$("#updatepartitionbegindate").val(begindate);
    		$("#updatepartitionenddate").val(enddate);
    		$("#updatepartitionbeginlession").val(beginlession);
    		$("#updatepartitionendlession").val(endlession);
    		$("#updatepartitionIsUsed").val(isused);
    		$("#updatepartitionwichday").val(whichday);
    	}
//     	function getchange() {
//     		$("#updatepartitionname").change($(this).val());
//     		$("#updatepartitionsimplename").val(this.val);
//     	}

		$("#search").click(
			function() {
				var str="<form id=\"deleteform\"><table class=\"table\"><thead><tr><th>&nbsp;</th><th>学年</th><th>学期</th><th>教学楼</th><th>教室</th><th>划归部门</th><th>教室类型</th><th>有效座位</th><th>上课人数</th><th>考试人数</th><th>开始周</th><th>结束周</th><th>是否启用</th></tr></thead><tbody>";
				$.ajax({
					url:"/cims107/PartitionSearch",
					async:false,
					data: $("#searchform").serialize()
						}).done(
					function(data){
						if (data.length!=0)
						{
							var partition = jQuery.parseJSON(data)
							console.log(data);
							
							$.each(partition,function(i,partition){
								str+=("<tr><td><input id=\"check\" type=\"checkbox\" name=\"partitionid\" value="
										+partition.partitionId+"></td><td>"+String(partition.partitionYear)+"</td><td>"
										+partition.partitionTerm+"</td><td>"+partition.buildingName+"</td><td>"
										+partition.clsSerialNumber+"</td><td>"+partition.partitionDepartment+"</td><td>"
										+partition.clsType+"</td><td>"+partition.clsAvailableSeatNum+"</td><td>"
										+partition.partitionClassNum+"</td><td>"+partition.partitionExamNum+"</td><td>"
										+partition.partitionBeginWeek+"</td><td>"+partition.partitionEndWeek+"</td><td>"
										+partition.partitionIsUsed+
										"</td><td><button href=\"#updatediv\" id=\"updateid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"updatepartition("+partition.partitionId+",'"+partition.partitionYear+"','"
										+partition.partitionTerm+"','"+partition.partitionDepartment+"','"+partition.partitionClassNum+"','"+partition.partitionExamNum+"','"
										+partition.partitionBeginWeek+"','"+partition.partitionEndWeek+"','"+partition.partitionBeginDate+"','"+partition.partitionEndDate+"','"
										+partition.partitionBeginLession+"','"+partition.partitionEndLession+"','"+partition.partitionIsUsed+"','"+partition.partitionWhichDay+"')\">修改</button></td></tr>");						        
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
		
		$("#searchAll").click(
				function() {
					var str="<form id=\"multiform\"><table class=\"table\"><thead><tr><th>&nbsp;</th><th>学年</th><th>学期</th><th>教学楼</th><th>教室</th><th>划归部门</th><th>教室类型</th><th>有效座位</th><th>上课人数</th><th>考试人数</th><th>开始周</th><th>结束周</th><th>是否启用</th></tr></thead><tbody>";
					$.ajax({
						url:"/cims107/PartitionSearchAll",
						async:false,
						data:null
							}).done(
						function(data)
						{
							if (data.length!=0)
							{
								var partition = jQuery.parseJSON(data);
								console.log(data);
								
								$.each(partition,function(i,partition){
									str+=("<tr><td><input id=\"check\" type=\"checkbox\" name=\"partitionid\" value="
											+partition.partitionId+"></td><td>"+String(partition.partitionYear)+"</td><td>"
											+partition.partitionTerm+"</td><td>"+partition.buildingName+"</td><td>"
											+partition.clsSerialNumber+"</td><td>"+partition.partitionDepartment+"</td><td>"
											+partition.clsType+"</td><td>"+partition.clsAvailableSeatNum+"</td><td>"
											+partition.partitionClassNum+"</td><td>"+partition.partitionExamNum+"</td><td>"
											+partition.partitionBeginWeek+"</td><td>"+partition.partitionEndWeek+"</td><td>"
											+partition.partitionIsUsed+
											"</td><td><button href=\"#updatediv\" id=\"updateid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"updatepartition("+partition.partitionId+",'"+partition.partitionYear+"','"
													+partition.partitionTerm+"','"+partition.partitionDepartment+"','"+partition.partitionClassNum+"','"+partition.partitionExamNum+"','"
													+partition.partitionBeginWeek+"','"+partition.partitionEndWeek+"','"+partition.partitionBeginDate+"','"+partition.partitionEndDate+"','"
													+partition.partitionBeginLession+"','"+partition.partitionEndLession+"','"+partition.partitionIsUsed+"','"+partition.partitionWhichDay+"')\">修改</button></td></tr>");					        
						        });
								str+=("</table></form>");
								document.getElementById('result').innerHTML=str;
								//document.getElementById('result').innerHTML=<button href="#del" style="height:30px" data-toggle="modal" class="btn btn-primary">删除</button>;
							}
						else
							document.getElementById('result').innerHTML=null;
						}
					);	
// 					$("#result").load("/cims107/PartitionSearchAll",function(result){
// 						if (result.length!=0)
// 							{
// 								var partition = jQuery.parseJSON(result);
// 								console.log(result);
								
// 								$.each(partition,function(i,partition){
// 									str+=("<tr><td><input id=\"check\" type=\"checkbox\" name=\"partitionid\" value="
// 											+partition.partitionId+"></td><td>"+String(partition.partitionYear)+"</td><td>"
// 											+partition.partitionTerm+"</td><td>"+partition.buildingName+"</td><td>"
// 											+partition.clsSerialNumber+"</td><td>"+partition.partitionDepartment+"</td><td>"
// 											+partition.clsType+"</td><td>"+partition.clsAvailableSeatNum+"</td><td>"
// 											+partition.partitionClassNum+"</td><td>"+partition.partitionExamNum+"</td><td>"
// 											+partition.partitionBeginWeek+"</td><td>"+partition.partitionEndWeek+"</td><td>"
// 											+partition.partitionIsUsed+
// 											"</td><td><button href=\"#updatediv\" id=\"updateid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"updatepartition("+partition.partitionId+",'"+partition.partitionYear+"','"
// 													+partition.partitionTerm+"','"+partition.buildingName+"','"+partition.clsSerialNumber+"','"+partition.partitionDepartment+"','"
// 													+partition.clsType+"','"+partition.clsAvailableSeatNum+"','"+partition.partitionClassNum+"','"+partition.partitionExamNum+"','"
// 													+partition.partitionBeginWeek+"','"+partition.partitionEndWeek+"','"+partition.partitionIsUsed+"')\">修改</button></td></tr>");					        
// 						        });
// 								str+=("</table></form>");
// 								document.getElementById('result').innerHTML=str;
// 					    };
//					});
					});
		
		$("#new").click(
				function() {
					$.ajax({
						url:"/cims107/PartitionCreate",
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
					$.ajax({
						url:"/cims107/PartitionDelete",
						async:false,
						data:$("#multiform").serialize(),
						success: function(result) 
            			{
							alert("删除成功！");
            			}}
					);
					
				});
		$("#enable").click(
				function() {
					$.ajax({
						url:"/cims107/PartitionEnable",
						async:false,
						data:$("#multiform").serialize(),
						success: function(result) 
            			{
							alert("所选项已启用！");
            			}}
					);
					
				});
		$("#disable").click(
				function() {
					$.ajax({
						url:"/cims107/PartitionDisable",
						async:false,
						data:$("#multiform").serialize(),
						success: function(result) 
            			{
							alert("所选项已停用！");
            			}}
					);
					
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
						url:"/cims107/PartitionUpdate",
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