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

<body onload="setletter();searchAll();">
	<div style="height:700px;">
		<form id="searchform" name="partitionForm">
        <div style="margin-left:2%">
        	<label><font class="fiveword">教学楼名</font>称</label>
			<input type="text" name="buildingname">
			<label><font class="fourword">教室编</font>号</label>
			<input type="text" name="serialnumber">
        	<label><font class="sixword">最少上课人</font>数</label>
			<input type="text" name="minclassnum">
			<label><font class="sixword">最多上课人</font>数</label>
			<input type="text" name="maxclassnum">
			<div>
			<label><font class="sixword">最少考试人</font>数</label>
			<input type="text" name="minexamnum">
			<label><font class="sixword">最多考试人</font>数</label>
			<input type="text" name="maxexamnum">
			<label>最少有效座位数</label>
			<input type="text" name="minavailableseat">
			<label>最多有效座位数</label>
			<input type="text" name="maxavailableseat">
			<label><font class="threeword">开始</font>周</label>
			<input type="text" name="partitionBeginWeek">
			<label><font class="threeword">结束</font>周</label>
			<input type="text" name="partitionEndWeek">
			<label><font class="twoword">单</font>位</label>
        	<select name="partitionDepartment">
        		<option></option>
          		<option>教务处</option>
          		<option>医教处</option>
          		<option>软件学院</option>
        	</select>
        	<label><font class="twoword">校</font>区</label>
        	<select name="compus">
        		<option></option>
          		<option>东校区</option>
          		<option>南校区</option>
          		<option>北校区</option>
        	</select>
        	<label><font class="fourword">教室类</font>型</label>
        	<select name="type">
        		<option></option>
          		<option>语音室</option>
          		<option>多媒体教室</option>
        	</select>
        	<label><font class="twoword">学</font>年</label>
        	<select name="partitionYear">
        		<option></option>
          		<option>2012-2013</option>
          		<option>2013-2014</option>
          		<option>2014-2015</option>
        	</select>
        	<label><font class="twoword">学</font>期</label>
        	<select name="partitionTerm">
        		<option></option>
          		<option>第一学期</option>
          		<option>第二学期</option>
          		<option>第三学期</option>
        	</select>  
        	<label><font class="fourword">启用状</font>态</label>
        	<select name="partitionIsUsed" id="searchIsUsed">
        		<option></option>
          		<option>启用</option>
          		<option>停用</option>
        	</select>    
        	</div>
      	</div>
      	</form>
      	<button style="height:30px;margin-bottom:10px;position:relative;left:90%" id="search" class="btn btn-primary">查询</button>
      	<button style="height:30px;margin-bottom:10px;display:none" id="searchdistribute" class="btn btn-primary">查询可分配资源</button> 
      	<button style="height:30px;margin-bottom:10px;display:none" id="goback" class="btn btn-primary">返回</button>
      	<div id="result"></div>
      	
      	<div>
      		<button id="gotonew" data-toggle="modal" class="btn btn-primary">划分资源</button>
      		<button id="del"  data-toggle="modal" class="btn btn-primary">删除</button>
      		<button id="enable"  data-toggle="modal" class="btn btn-primary">启用</button>
      		<button id="disable"  data-toggle="modal" class="btn btn-primary">停用</button>
      		<div class="modal hide" id="create">
    		<form name="createForm" id="createform">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>教室划分</h4>
      			</div>
      			<div class="modal-body">
				<table>
					<tr>
					<td style="width:18px;">&nbsp;</td>
        			<td><input type="hidden" id="newbuildingname" name="buildingname">
        			<input type="hidden" id="newcompus" name="compus">教室名称：</td>
        			<td><input type="text" id="newclsserialnum" name="serialnumber" readonly="readonly"></td>
        			</tr>
        			<tr>
        			<td>&nbsp;</td>
					<td>上课人数：</td>
        			<td><input type="text" id="newclsnum" name="partitionClassNum" readonly="readonly" onclick="focus()"></td>
					<td>&nbsp;</td>
					<td>考试人数：</td>
        			<td><input type="text" id="newexamnum" name="partitionExamNum" readonly="readonly" onclick="focus()"></td>
					</tr>
				</table>
				<table>
					<tr>
        			<td><input type="radio" id="newweek" name="weekanddate" value="week" checked="true" onclick="radioclick();"></td>
					<td>教学周：</td>
        			<td><input type="number" id="newbeginweek" name="partitionBeginWeek" min="1" onclick="beginweek();focus()">
        			<input type="number" id="newendweek" name="partitionEndWeek" min="1" onclick="endweek();focus()"></td>
					</tr>
					<tr>
        			<td><input type="radio" id="newdate" name="weekanddate" value="date" onclick="radioclick();"></td>
					<td>日期：</td>
        			<td><input type="date" id="newbegindate" name="partitionBeginDate" style="width:130px;" onclick="begindate();focus()">
        			<input type="date" id="newenddate" name="partitionEndDate" style="width:130px;" onclick="enddate();focus()"><td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					<td>节次：</td>
        			<td><input type="number" id="newbeginlession" name="partitionBeginLession" min="1" max="15" onclick="focus()">
        			<input type="number" id="newendlession" name="partitionEndLession" min="1" max="15" onclick="endlession();focus()"></td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					<td>单位：</td>
        			<td><input type="text" id="newpartitionDepartment" name="partitionDepartment">
              <a id="spsh" onclick="spreadorshrink();" style="display:inline-block;">单位查询</a>
              <div style="display:none;" id="departmentsearch" class="week">
                <label>单位号</label>
            	<input type="text" name="departmentId" id="departmentid">
            	<label>单位名称</label>
            	<input type="text" name="departmentName" id="departmentname">
                <button id="department" type="button" class="btn btn-primary">确定</button>
              </div>
              <div id="departmentresult"></div>
              </td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					<td>年份：</td>
        			<td><select name="partitionYear">
          				<option>2012-2013</option>
          				<option>2013-2014</option>
          				<option>2014-2015</option>
        			</select></td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					<td>学期：</td>
        			<td><select name="partitionTerm">
          				<option>第一学期</option>
          				<option>第二学期</option>
          				<option>第三学期</option>
        			</select></td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					<td>启用状态：</td>
        			<td><select name="partitionIsUsed" id="newIsused">
          				<option>启用</option>
          				<option>停用</option>
        			</select></td>
        			</tr>
				</table>
				<div class="week">
        			<s:checkboxlist name="whichday" list="#{'星期一':'1','星期二':'2','星期三':'3','星期四':'4','星期五':'5','星期六':'6','星期日':'7'}" 
          				label="每周使用星期" labelposition="top" listKey="value" listValue="key"> 
       				</s:checkboxlist> 
       			</div>
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
        			<button id="new" type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
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
				<table>
					<tr>
      				<td><input type="radio" id="updateweek" name="upweekanddate" value="week" class="radio" onclick="upradioclick();"></td>
					<td>教学周：</td>
        			<td><input type="number" id="updatepartitionBeginWeek" name="partitionBeginWeek" min="1" onclick="beginweek();focus()">
        			<input type="number" id="updatepartitionEndWeek" name="partitionEndWeek" min="1" onclick="endweek();focus()">
					</td>
					</tr>
					<tr>
        			<td><input type="radio" id="updatedate" name="upweekanddate" value="date" class="radio" onclick="upradioclick();"></td>
					<td>日期：</td>
        			<td><input type="date" id="updatebegindate" name="partitionBeginDate" style="width:130px;" onclick="begindate();focus()">
					<input type="date" id="updateenddate" name="partitionEndDate" style="width:130px;" onclick="enddate();focus()"></td>
        			<input type="hidden" id="updatepartitionid" name="partitionId">
					</tr>
					<tr>
					<td>&nbsp;</td>
					<td>单位：</td>
        			<td><select name="partitionDepartment" id="updatepartitionDepartment">
          				<option>教务处</option>
          				<option>医教处</option>
          				<option>软件学院</option>
        			</select></td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					<td>年份：</td>
        			<td><select name="partitionYear" id="updatepartitionYear">
          				<option>2012-2013</option>
          				<option>2013-2014</option>
          				<option>2014-2015</option>
        			</select></td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					<td>学期：</td>
        			<td><select name="partitionTerm" id="updatepartitionTerm">
          				<option>第一学期</option>
          				<option>第二学期</option>
          				<option>第三学期</option>
        			</select> </td> 
					</tr>
				</table>
<!--         			<br/> -->
<%--         			<s:checkboxlist theme="simple" id="updatepartitionwhichday" name="partitionWhichDay" list="#{'星期一':'1','星期二':'2','星期三':'3','星期四':'4','星期五':'5','星期六':'6','星期日':'7'}"  --%>
<%--          				label="每周使用星期" labelposition="top" listKey="value" listValue="key"> --%>
<%--         			</s:checkboxlist> --%>
      			</div>
      			<div class="modal-footer">
        			<button id="update" type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
      			</div>
      			</form>
      		</div>

    	</div>
    </div>
    <script type="text/javascript">
	    function setletter(){
			$("font").filter('.twoword').css("letter-spacing",document.body.scrollWidth/25); 
			$("font").filter('.threeword').css("letter-spacing",document.body.scrollWidth/40); 
			$("font").filter('.fourword').css("letter-spacing",document.body.scrollWidth/80); 
			$("font").filter('.fiveword').css("letter-spacing",document.body.scrollWidth/130); 
			$("font").filter('.sixword').css("letter-spacing",document.body.scrollWidth/300); 
		}
	    function changepage(k,j){
			var i;
			for(i=1;i<=j;i++){
				if(i==k){
					document.getElementById("page"+i).style.display="table";
				}
				else{
					document.getElementById("page"+i).style.display="none";
				}
			}
		}
    	function updatepartition(i,year,term,department,beginweek,endweek,begindate,enddate) {
    		$("#updatepartitionid").val(i);
    		$("#updatepartitionYear").val(year);
    		$("#updatepartitionTerm").val(term);
    		$("#updatepartitionDepartment").val(department);
    		$("#updatepartitionBeginWeek").val(beginweek);
    		$("#updatepartitionEndWeek").val(endweek);
    		$("#updatebegindate").val(begindate);
    		$("#updateenddate").val(enddate);
    		if (beginweek != 0){
    			document.getElementById("updatebegindate").disabled = true;
    			document.getElementById("updateenddate").disabled = true;
    			document.getElementById("updateweek").checked = true;
    		}
    		if (begindate != ''){
    			document.getElementById("updatepartitionBeginWeek").disabled = true;
    			document.getElementById("updatepartitionEndWeek").disabled = true;
    			document.getElementById("updatedate").checked = true;   			
    		}    		
 //   		$("#updatepartitionwichday").listKey(whichday);
    	}
		function newpartition(name,compus,serialnum,clsnum,examnum){
			$("#newbuildingname").val(name);
			$("#newcompus").val(compus);
			$("#newclsserialnum").val(serialnum);
			$("#newclsnum").val(clsnum);
			$("#newexamnum").val(examnum);
			document.getElementById("newbeginweek").disabled = false;
			document.getElementById("newendweek").disabled = false;
			document.getElementById("newbegindate").disabled = true;
			document.getElementById("newenddate").disabled = true;
		}
		function spreadorshrink(){
    		document.getElementById("departmentsearch").style.display='block';
    	}
    	function department(name){
    		$("#newpartitionDepartment").val(name);
    	}
		function radioclick(){
			var val=$('input:radio[name="weekanddate"]:checked').val();
			if(val == "week"){
				document.getElementById("newbeginweek").disabled = false;
				document.getElementById("newendweek").disabled = false;
				document.getElementById("newbegindate").disabled = true;
				document.getElementById("newenddate").disabled = true;
			}
			if(val == "date"){
				document.getElementById("newbegindate").disabled = false;
				document.getElementById("newenddate").disabled = false;				
				document.getElementById("newbeginweek").disabled = true;
				document.getElementById("newendweek").disabled = true;
			}			
		}
		
		function upradioclick(){
			var upval=$('input:radio[name="upweekanddate"]:checked').val();
			if(upval == "week"){
				document.getElementById("updatepartitionBeginWeek").disabled = false;
				document.getElementById("updatepartitionEndWeek").disabled = false;
				document.getElementById("updatebegindate").disabled = true;
				document.getElementById("updateenddate").disabled = true;
			}
			if(upval == "date"){
				document.getElementById("updatebegindate").disabled = false;
				document.getElementById("updateenddate").disabled = false;				
				document.getElementById("updatepartitionBeginWeek").disabled = true;
				document.getElementById("updatepartitionEndWeek").disabled = true;
			}
		}
		
		function endlession(){
			document.getElementById("newendlession").min = document.getElementById("newbeginlession").value;
		}
		
		function beginweek(){
			document.getElementById("newbeginweek").max = document.getElementById("newendweek").value;
			document.getElementById("updatepartitionBeginWeek").max = document.getElementById("updatepartitionEndWeek").value;
		}
		
		function endweek(){
			document.getElementById("newendweek").min = document.getElementById("newbeginweek").value;
			document.getElementById("updatepartitionEndWeek").min = document.getElementById("updatepartitionBeginWeek").value;
		}
		
		function begindate(){
			document.getElementById("newbegindate").max = document.getElementById("newenddate").value;
			document.getElementById("updatebegindate").max = document.getElementById("updateenddate").value;
		}
		
		function enddate(){
			document.getElementById("newenddate").min = document.getElementById("newbegindate").value;
			document.getElementById("updateenddate").min = document.getElementById("updatebegindate").value;
		}

		$("#search").click(
			function() {
				if ($("#searchIsUsed option:selected").val() == "启用")
					$("#searchIsUsed option:selected").val(1);
				if ($("#searchIsUsed option:selected").val() == "停用")
					$("#searchIsUsed option:selected").val(2);
				var str="<form id=\"multiform\">";
				$.ajax({
					url:"/cims107/PartitionSearch",
					async:false,
					cache:false,
					data: $("#searchform").serialize(),
					dataType:"json",
					success: function(data){
						var k=0;
						var j=1;
						if (data.length!=0)
						{
							$.each(data,function(i,data){
								if(k==10){
									k=0;
									str+="</table>";
									j++;
									}
									if(k==0){
										if(j==1){
											str+=("<table id=\"page"+j+"\"class=\"table\"><thead><tr><th>&nbsp;</th><th>学年</th><th>学期</th><th>教学楼</th><th>教室</th><th>划归部门</th><th>教室类型</th><th>有效座位</th><th>上课人数</th><th>考试人数</th><th>开始周</th><th>结束周</th><th>划分是否启用</th></tr></thead><tbody>");
										}
										else{
											str+=("<table id=\"page"+j+"\" class=\"table\" style=\"display:none;\"><thead><tr><th>&nbsp;</th><th>学年</th><th>学期</th><th>教学楼</th><th>教室</th><th>划归部门</th><th>教室类型</th><th>有效座位</th><th>上课人数</th><th>考试人数</th><th>开始周</th><th>结束周</th><th>划分是否启用</th></tr></thead><tbody>");
										}
									}
								var building = data.classroom.building
								if (data.partitionIsUsed == 1)
									var partitionIsUsed = "启用";
								if (data.partitionIsUsed == 2)
									var partitionIsUsed = "停用";
								str+=("<tr><td><input id=\"check\" type=\"checkbox\" name=\"partitionid\" value="
										+data.partitionId+"></td><td>"+data.partitionYear+"</td><td>"
										+data.partitionTerm+"</td><td>"+building.buildingName+"</td><td>"
										+data.classroom.clsSerialNumber+"</td><td>"+data.partitionDepartment+"</td><td>"
										+data.classroom.clsType+"</td><td>"+data.classroom.clsAvailableSeatNum+"</td><td>"
										+data.partitionClassNum+"</td><td>"+data.partitionExamNum+"</td><td>"
										+data.partitionBeginWeek+"</td><td>"+data.partitionEndWeek+"</td><td>"
										+partitionIsUsed+
										"</td><td><button href=\"#updatediv\" id=\"updateid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"updatepartition("+data.partitionId+",'"+data.partitionYear+"','"
										+data.partitionTerm+"','"+data.partitionDepartment+"','"+data.partitionBeginWeek+"','"+data.partitionEndWeek+"','"+data.partitionBeginDate+"','"+data.partitionEndDate+"')\">修改</button></td></tr>");						        
								k++;
							});
							str+=("</table></form>");
							str+=("<div>");
							for(k=1;k<=j;k++){
								str+=("<a class=\"button button-primary\"onclick=\"changepage("+k+","+j+")\">第"+k+"页</a>");
							}
							str+=("</div>");
							document.getElementById('result').innerHTML=str;
							if (data.error != null)
								alert(data.error);
							//document.getElementById('result').innerHTML=<button href="#del"  data-toggle="modal" class="btn btn-primary">删除</button>;
						}
						else{
							document.getElementById('result').innerHTML=null;
							alert("没有结果！");
						}
				}	
			});
			}
		);
		
			function searchAll() {
				var str="<form id=\"multiform\">";
				$.ajax({
					url:"/cims107/PartitionSearchAll",
					async:false,
					cache:false,
					data:null,
					dataType:"json",
					success: function(data){
						var k=0;
						var j=1;
						if (data.length!=0)
						{
							$.each(data,function(i,data){
								if(k==10){
								k=0;
								str+="</table>";
								j++;
								}
								if(k==0){
									if(j==1){
										str+=("<table id=\"page"+j+"\"class=\"table\"><thead><tr><th>&nbsp;</th><th>学年</th><th>学期</th><th>教学楼</th><th>教室</th><th>划归部门</th><th>教室类型</th><th>有效座位</th><th>上课人数</th><th>考试人数</th><th>开始周</th><th>结束周</th><th>划分是否启用</th></tr></thead><tbody>");
									}
									else{
										str+=("<table id=\"page"+j+"\" class=\"table\" style=\"display:none;\"><thead><tr><th>&nbsp;</th><th>学年</th><th>学期</th><th>教学楼</th><th>教室</th><th>划归部门</th><th>教室类型</th><th>有效座位</th><th>上课人数</th><th>考试人数</th><th>开始周</th><th>结束周</th><th>划分是否启用</th></tr></thead><tbody>");
									}
								}
								var building = data.classroom.building;
								if (data.partitionIsUsed == 1)
									var partitionIsUsed = "启用";
								if (data.partitionIsUsed == 2)
									var partitionIsUsed = "停用";
								str+=("<tr><td><input id=\"check\" type=\"checkbox\" name=\"partitionid\" value="
									+data.partitionId+"></td><td>"+data.partitionYear+"</td><td>"
									+data.partitionTerm+"</td><td>"+building.buildingName+"</td><td>"
									+data.classroom.clsSerialNumber+"</td><td>"+data.partitionDepartment+"</td><td>"
									+data.classroom.clsType+"</td><td>"+data.classroom.clsAvailableSeatNum+"</td><td>"
									+data.partitionClassNum+"</td><td>"+data.partitionExamNum+"</td><td>"
									+data.partitionBeginWeek+"</td><td>"+data.partitionEndWeek+"</td><td>"
									+partitionIsUsed+
									"</td><td><button href=\"#updatediv\" id=\"updateid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"updatepartition("+data.partitionId+",'"+data.partitionYear+"','"
										+data.partitionTerm+"','"+data.partitionDepartment+"','"+data.partitionBeginWeek+"','"+data.partitionEndWeek+"','"+data.partitionBeginDate+"','"+data.partitionEndDate+"')\">修改</button></td></tr>");
								k++;
						    });
							str+=("</table></form>");
							str+=("<div>");
							for(k=1;k<=j;k++){
								str+=("<a class=\"button button-primary\"onclick=\"changepage("+k+","+j+")\">第"+k+"页</a>");
							}
							str+=("</div>");
							document.getElementById('result').innerHTML=str;
							if (data.error != null)
								alert(data.error);
								//document.getElementById('result').innerHTML=<button href="#del"  data-toggle="modal" class="btn btn-primary">删除</button>;
						}
						else{
							document.getElementById('result').innerHTML=null;
							alert("没有结果！");
						}
				}
			});	
		}
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
				
		$("#gotonew").click(
				function() {
					document.getElementById("search").style.display="none";
					document.getElementById("gotonew").style.display="none";
					document.getElementById("del").style.display="none";
					document.getElementById("enable").style.display="none";
					document.getElementById("disable").style.display="none";
					document.getElementById("searchdistribute").style.display="inline-block";	
					document.getElementById("goback").style.display="inline-block";
				});
		$("#goback").click(
				function() {
					document.getElementById("search").style.display="inline-block";
					document.getElementById("gotonew").style.display="inline-block";
					document.getElementById("del").style.display="inline-block";
					document.getElementById("enable").style.display="inline-block";
					document.getElementById("disable").style.display="inline-block";
					document.getElementById("searchdistribute").style.display="none";	
					document.getElementById("goback").style.display="none";
					document.getElementById('result').innerHTML=null;
				});
		$("#new").click(
				function() {
					if($("#newbeginlession").val() == "" || $("#newendlession").val() == ""){  
				    	alert("请填写上课节数!");  
				    	return false;  
				    }
					var val=$('input:radio[name="weekanddate"]:checked').val();
					if(val == "week"){
						if($("#newbeginweek").val() == "" || $("#newendweek").val() == ""){  
					    	alert("请填写划分时段!");  
					    	return false;  
					    }
					}
					if(val == "date"){
						if($("#newbegindate").val() == "" || $("#newenddate").val() == ""){  
					    	alert("请填写划分时段!");  
					    	return false;  
					    }
					}
					var reg = new RegExp("^[0-9]*$");
					if(!reg.test($("#newbeginweek").val()) && $("#newbeginweek").val() != "" || !reg.test($("#newendweek").val()) && $("#newendweek").val() != ""){
	 			    	alert("数字输入错误！");
	 			    	return false;
	 			    }
					if ($("#newIsused option:selected").val() == "启用")
						$("#newIsused option:selected").val(1);
					if ($("#newIsused option:selected").val() == "停用")
						$("#newIsused option:selected").val(2);
					$.ajax({
						url:"/cims107/PartitionCreate",
						async:false,
						cache:false,
						data: $("#createform").serialize(),
						dataType:"json",
						success: function(result) 
            			{
							if(result.success != null)
								alert(result.success);
							if(result.error != null)
								alert(result.error);
            			}}
					);
					
				});
		$("#searchdistribute").click(
				function() {
					if ($("#searchIsUsed option:selected").val() == "启用")
						$("#searchIsUsed option:selected").val(1);
					if ($("#searchIsUsed option:selected").val() == "停用")
						$("#searchIsUsed option:selected").val(2);
					var str="<form id=\"deleteform\">";
					$.ajax({
						url:"/cims107/PartitionSearchDistributableCls",
						async:false,
						cache:false,
						data: $("#searchform").serialize(),
						dataType:"json",
						success: function(data){
							var k=0;
							var j=1;
							if (data.length!=0)
							{
								$.each(data,function(i,data){
									if(k==10){
										k=0;
										str+="</table>";
										j++;
										}
										if(k==0){
											if(j==1){
												str+=("<table id=\"page"+j+"\"class=\"table\"><thead><tr><th>教学楼</th><th>教室</th><th>教室类型</th><th>有效座位</th><th>上课人数</th><th>考试人数</th></tr></thead><tbody>");
											}
											else{
												str+=("<table id=\"page"+j+"\" class=\"table\" style=\"display:none;\"><thead><tr><th>教学楼</th><th>教室</th><th>教室类型</th><th>有效座位</th><th>上课人数</th><th>考试人数</th></tr></thead><tbody>");
											}
										}
								//	var building = jQuery.parseJSON(partition.building)
									str+=("<tr><td>"+data.building.buildingName+"</td><td>"
											+data.clsSerialNumber+"</td><td>"+data.clsType+"</td><td>"+data.clsAvailableSeatNum+"</td><td>"
											+data.clsClassNum+"</td><td>"+data.clsExamNum+"</td><td>"+
											"</td><td><button href=\"#create\" id=\"newid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"newpartition('"+data.building.buildingName+"','"+data.building.buildingCompus+"','"
											+data.clsSerialNumber+"',"+data.clsClassNum+","+data.clsExamNum+")\">划分</button></td></tr>");						        
						        	k++;
								});
								str+=("</table></form>");
								str+=("<div>");
								for(k=1;k<=j;k++){
									str+=("<a class=\"button button-primary\"onclick=\"changepage("+k+","+j+")\">第"+k+"页</a>");
								}
								str+=("</div>");
								document.getElementById('result').innerHTML=str;
								if(data.error!=null)
									alert(data.error);
								//document.getElementById('result').innerHTML=<button href="#del"  data-toggle="modal" class="btn btn-primary">删除</button>;
							}
							else{
								document.getElementById('result').innerHTML=null;
								alert("没有结果！");
							}
					}	
				});
				
			});
		$("#department").click(
				function() {
					var str="<table class=\"table\"><thead><th>单位名称</th></thead><tbody>";
					$.ajax({
						url:"/cims107/DepartmentSearch",
						async:false,
						cache:false,
						data:{departmentId:$("#departmentid").val(),departmentName:$("#departmentname").val()},
						dataType:"json",
						success: function(data){
							if (data.error == null){
								if (data.length!=0)
								{
									$.each(data,function(i,data){
										str+=("<tr><td onclick=\"department('"+data.departmentName+"')\">"+data.departmentName+"</td></tr>");
									 });						        
									str+=("</tbody></table>");
									document.getElementById('departmentresult').innerHTML=str;
								}
								else{
									document.getElementById('departmentresult').innerHTML=null;
									alert("没有结果！");
								}
							}
							else
								alert(data.error);
						}	
					});
				});
		$("#del").click(
				function() {
					var checked_num = $("input[name='partitionid']:checked").length;
					if (checked_num == 0) {
						alert("至少选择一项");
						return false;
					}						
					else if (confirm("您确认要删除所选信息吗？")){
						$.ajax({
							url:"/cims107/PartitionDelete",
							async:false,
							cache:false,
							data:$("#multiform").serialize(),
							dataType:"json",
							success: function(result) 
	            			{
								if(result.success != null)
									alert(result.success);
								if(result.error != null)
									alert(result.error);
								document.getElementById('search').click();
	            			}}
						);
					}
				});
		$("#enable").click(
				function() {
					var checked_num = $("input[name='partitionid']:checked").length;
					if (checked_num == 0) {
						alert("至少选择一项");
						return false;
					}						
					else {
						$.ajax({
							url:"/cims107/PartitionEnable",
							async:false,
							cache:false,
							data:$("#multiform").serialize(),
							dataType:"json",
							success: function(result) 
	            			{
								if(result.success != null)
									alert(result.success);
								if(result.error != null)
									alert(result.error);
								document.getElementById('search').click();
	            			}}
						);
					}
				});
		$("#disable").click(
				function() {
					var checked_num = $("input[name='partitionid']:checked").length;
					if (checked_num == 0) {
						alert("至少选择一项");
						return false;
					}						
					else {
						$.ajax({
							url:"/cims107/PartitionDisable",
							async:false,
							cache:false,
							data:$("#multiform").serialize(),
							dataType:"json",
							success: function(result) 
	            			{
								if(result.success != null)
									alert(result.success);
								if(result.error != null)
									alert(result.error);
								document.getElementById('search').click();
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
					if(document.getElementById("updatebegindate").disabled == true){
						document.getElementById("updatebegindate").disabled = false;
						document.getElementById("updateenddate").disabled = false;
						($("#updatebegindate")).val('');
						($("#updateenddate")).val('');
					}
					if(document.getElementById("updatepartitionBeginWeek").disabled == true){
						document.getElementById("updatepartitionBeginWeek").disabled = false;
						document.getElementById("updatepartitionEndWeek").disabled = false;
						($("#updatepartitionBeginWeek")).val('');
						($("#updatepartitionEndWeek")).val('');
					}
					if ($("#updatepartitionIsUsed option:selected").val() == "启用")
						$("#updatepartitionIsUsed option:selected").val(1);
					if ($("#updatepartitionIsUsed option:selected").val() == "停用")
						$("#updatepartitionIsUsed option:selected").val(2);
					$.ajax({
						url:"/cims107/PartitionUpdate",
						async:false,
						cache:false,
						data: $("#updateform").serialize(),
						dataType:"json",
						success: function(result) 
            			{
							if(result.success != null)
								alert(result.success);
							if(result.error != null)
								alert(result.error);
							document.getElementById('search').click();
            			}}
					);
					
				});
	</script>
</body>
</html>