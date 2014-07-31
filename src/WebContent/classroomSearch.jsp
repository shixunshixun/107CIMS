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

<body onload="setletter()">
	<div style="height:700px;width:100%;">
    		<form id="searchform" name="classroomform">
      		<div style="margin-left:2%">
				<label><font class="fiveword">教学楼名</font>称</label>
				<input type="text" name="buildingname">
				<label><font class="fourword">教室编</font>号</label>
				<input type="text" name="clsSerialNumber">
				<label><font class="fourword">教室楼</font>层</label>
				<input type="text" name="clsFloor">
				<label><font class="sixword">最少上课人</font>数</label>
				<input type="text" name="minClassNum">
				<div id="displaylist">
					<label><font class="sixword">最多上课人</font>数</label>
					<input type="text" name="maxClassNum">
					<label><font class="sixword">最少考试人</font>数</label>
					<input type="text" name="minExamNum">
					<label><font class="sixword">最多考试人</font>数</label>
					<input type="text" name="maxExamNum">
					<label><font class="twoword">面</font>积</label>
					<input type="text" name="area">
					<label><font class="twoword">校</font>区</label>
					<select name="compus" id="compus">
						<option></option>
						<option>东校区</option>
						<option>南校区</option>
						<option>北校区</option>
					</select>
					<label><font class="twoword">单</font>位</label>
					<select name="departmentname">
						<option></option>
						<option>教务处</option>
						<option>教务处</option>
						<option>教务处</option>
					</select>
					<label><font class="fourword">教室类</font>型</label>
					<select name="clsType">
						<option></option>
						<option>语音室</option>
						<option>多媒体教室</option>
					</select>
					<label><font class="twoword">方</font>位</label>
					<select name="clsLocation">
						<option></option>
						<option>东南</option>
						<option>西北</option>
					</select>
					<label><font class="fourword">阶梯教</font>室</label>
					<select name="clsIsAmphi" id="searchisamphi">
						<option></option>
						<option>是</option>
						<option>否</option>
					</select>
					<label><font class="fourword">教室形</font>状</label>
					<select name="clsShape">
						<option></option>
						<option>扇形</option>
						<option>矩形</option>
					</select>
					<label><font class="twoword">话</font>筒</label>
					<select name="clsHasMicrophone" id="searchhasmicrophone">
						<option></option>
						<option>有话筒</option>
						<option>无话筒</option>
					</select>
					<label><font class="fourword">教室用</font>途</label>
					<select name="clsUsage">
						<option></option>
						<option>上课</option>
						<option>语音</option>
					</select>
					<label><font class="fourword">启用状</font>态</label>
					<select name="clsIsUsed" id="searchisused">
						<option></option>
						<option>启用</option>
						<option>停用</option>
					</select>
        		</div>
        		<a id="spsh" onclick="spreadorshrink()">展开</a>
      		</div>
      		</form>
			<button style="height:30px;margin-bottom:10px;float:right" id="search" class="btn btn-primary">查询</button>
      		<div id="result"></div>
        		<button href="#clsnew" data-toggle="modal" class="btn btn-primary">新增</button>
        		<button id="del" data-toggle="modal" class="btn btn-primary">删除</button>

    		<div class="modal hide" id="clsnew">
    			<form name="createForm" id="createform">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>新增教室</h4>
      			</div>
      			<div class="modal-body">
					<div id="newfirst">
						<label><font class="fiveword">教学楼名</font>称</label>
						<font color="red">*</font>
						<input type="text" name="buildingname" id="newbuildingname">
						<label><font class="fourword">教室编</font>号</label>
						<font color="red">*</font>
						<input type="text" name="clsSerialNumber" id="newserialnum">
						<label><font class="fourword">教室楼</font>层</label>
						<font color="red">*</font>
						<input type="text" name="clsFloor" id="newfloor">
						<label><font class="fourword">上课人</font>数</label>
						<font color="red">*</font>
						<input type="text" name="clsClassNum" id="newclsnum">
						<label><font class="fourword">总座位</font>数</label>
						<font color="red">*</font>
						<input type="text" name="clsSeatNum" id="newclsseatnum">
						<label><font class="fiveword">有效座位</font>数</label>
						<font color="red">*</font>
						<input type="text" name="clsAvailableSeatNum" id="newclsavailableseatnum">
						<label><font class="twoword">单</font>位</label>
						<font color="red">*</font>
						<select name="buildingDepartment" id="newdepartment">
							<option>教务处</option>
							<option>教务处</option>
							<option>教务处</option>
						</select>
						<label><font class="fourword">教室类</font>型</label>
						<font color="red">*</font>
						<select name="clsType" id="newtype">
							<option>语音室</option>
							<option>多媒体教室</option>
						</select>
						<label><font class="fourword">启用状</font>态</label>
						<font color="red">*</font>
						<select name="clsIsUsed" id="newisused">
							<option>启用</option>
							<option>停用</option>
						</select>
					</div>
					<div id="newsecond" class="hide">
						<label><font class="fourword">考试人</font>数</label>
						<input type="text" name="clsExamNum" id="newexamnum">
						<label><font class="sixword">最长行座位</font>数</label>
						<input type="text" name="clsMaxRow" id="newmaxrow">
						<label><font class="sixword">最宽列座位</font>数</label>
						<input type="text" name="clsMaxCol" id="newmaxcol">
						<label><font class="fiveword">横走廊位</font>置</label>
						<input type="text" name="clsHCorridorLocate" id="newhlocation">
						<label><font class="fiveword">竖走廊位</font>置</label>
						<input type="text" name="clsVCorridorLocate" id="newvlocation">
						<label><font class="twoword">面</font>积</label>
						<input type="text" name="clsArea" id="newarea">
						<label><font class="twoword">校</font>区</label>
						<select name="compus">
							<option></option>
							<option>东校区</option>
							<option>南校区</option>
							<option>北校区</option>
						</select>
						<label><font class="twoword">方</font>位</label>
						<select name="clsLocation">
							<option></option>
							<option>东南</option>
							<option>西北</option>
						</select>
						<label><font class="fourword">阶梯教</font>室</label>
						<select name="clsIsAmphi" id="newisamphi">
							<option></option>
							<option>是</option>
							<option>否</option>
						</select>
						<label><font class="twoword">形</font>状</label>
						<select name="clsShape">
							<option></option>
							<option>扇形</option>
							<option>矩形</option>
						</select>
						<label><font class="twoword">话</font>筒</label>
						<select name="clsHasMicrophone" id="newhasmicrophone">
							<option></option>
							<option>有话筒</option>
							<option>无话筒</option>
						</select>
						<label><font class="twoword">用</font>途</label>
						<select name="clsUsage">
							<option></option>
							<option>上课</option>
							<option>语音</option>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button id="newpass" type="button" class="btn btn-primary" onclick="newnext()">下一步</button>
        			<button id="new" type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
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
					<div id="updatefirst">
						<label><font class="fourword">教室编</font>号</label>
						<font color="red">*</font>
						<input type="text" name="clsSerialNumber" id="updateserialnumber">
						<label><font class="fourword">教室楼</font>层</label>
						<font color="red">*</font>
						<input type="text" name="clsFloor" id="updatefloor">
						<label><font class="fourword">上课人</font>数</label>
						<font color="red">*</font>
						<input type="text" name="clsClassNum" id="updateclassnum">
						<label><font class="fourword">总座位</font>数</label>
						<font color="red">*</font>
						<input type="text" name="clsSeatNum" id="updateseatnum">
						<label><font class="fiveword">有效座位</font>数</label>
						<font color="red">*</font>
						<input type="text" name="clsAvailableSeatNum" id="updateavailableseatnum">
						<input type="hidden" name="clsId" id="updateclsid" onclick="focus()">
						<label><font class="fourword">教室类</font>型</label>
						<font color="red">*</font>
						<select name="clsType" id="updateclstype">
							<option></option>
							<option>语音室</option>
							<option>多媒体教室</option>
						</select>
						<label><font class="fourword">启用状</font>态</label>
						<font color="red">*</font>
						<select name="clsIsUsed" id="updateclsisused">
							<option></option>
							<option>启用</option>
							<option>停用</option>
						</select>
					</div>
					<div id="updatesecond" class="hide">
						<label><font class="fourword">考试人</font>数</label>
						<input type="text" name="clsExamNum" id="updateexamnum">
						<label><font class="sixword">最长行座位</font>数</label>
						<input type="text" name="clsMaxRow" id="updatemaxrow">
						<label><font class="sixword">最宽列座位</font>数</label>
						<input type="text" name="clsMaxCol" id="updatemaxcol">
						<label><font class="fiveword">横走廊位</font>置</label>
						<input type="text" name="clsHCorridorLocate" id="updatehcorridorlocate">
						<label><font class="fiveword">竖走廊位</font>置</label>
						<input type="text" name="clsVCorridorLocate" id="updatevcorridorlocate">
						<label><font class="twoword">面</font>积</label>
						<input type="text" name="clsArea" id="updatearea">
						<label><font class="twoword">方</font>位</label>
						<select name="clsLocation" id="updateclslocation">
							<option></option>
							<option>东南</option>
							<option>西北</option>
						</select>
						<label><font class="fourword">阶梯教</font>室</label>
						<select name="clsIsAmphi" id="updateclsisamphi">
							<option></option>
							<option>是</option>
							<option>否</option>
						</select>
						<label><font class="twoword">形</font>状</label>
						<select name="clsShape" id="updateclsshape">
							<option></option>
							<option>扇形</option>
							<option>矩形</option>
						</select>
						<label><font class="twoword">话</font>筒</label>
						<select name="clsHasMicrophone" id="updateclshasmicrophone">
							<option></option>
							<option>有话筒</option>
							<option>无话筒</option>
						</select>
						<label><font class="twoword">用</font>途</label>
						<select name="clsUsage" id="updateclsusage">
							<option></option>
							<option>上课</option>
							<option>语音</option>
						</select>
					</div>
      			</div>
      			<div class="modal-footer">
					<button id="updatepass" type="button" class="btn btn-primary" onclick="updatenext()">下一步</button>
        			<button id="update" type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
      			</div>
				</form>
    		</div> 	
    		<div class="modal hide" id="clsdetail">
      			<div class="modal-header">
        			<a href="#" class="close" data-dismiss="modal">×</a>
        			<h4>教室详细信息</h4>
      			</div>
      			<div class="modal-body" style="text-align: left;">
					<table>
						<tr>
							<th>属性</th>
							<th>信息</th>
							<th width="10%"></th>
							<th>属性</th>
							<th>信息</th>
						</tr>
						<tr>
							<td>教学楼名称：</td>
							<td id="detailbuildingname"></td>
							<td></td>
							<td>教室编号：</td>
							<td id="detailserialnumber"></td>
						</tr>
						<tr>
							<td>教室类型：</td>
							<td id="detailclstype"></td>
							<td></td>
							<td>所属单位：</td>
							<td id="detailbuildingdepartment"></td>

						</tr>
						<tr>
							<td>教室形状：</td>
							<td id="detailclsshape"></td>
							<td></td>
							<td>上课人数：</td>
							<td id="detailclassnum"></td>
						</tr>
						<tr>
							<td>考试人数：</td>
							<td id="detailexamnum"></td>
							<td></td>
							<td>总座位数：</td>
							<td id="detailseatnum"></td>
						</tr>
						<tr>
							<td>有效座位数：</td>
							<td id="detailavailableseatnum"></td>
							<td></td>
							<td>最长行座位数：</td>
							<td id="detailmaxrow"></td>
						</tr>
						<tr>
							<td>最宽列座位数：</td>
							<td id="detailmaxcol"></td>
							<td></td>
							<td>竖走廊位置：</td>
							<td id="detailvcorridorlocate"></td>
						</tr>
						<tr>
							<td>横走廊位置：</td>
							<td id="detailhcorridorlocate"></td>
							<td></td>
							<td>楼层：</td>
							<td id="detailfloor"></td>
						</tr>
						<tr>
							<td>是否阶梯教室：</td>
							<td id="detailclsisamphi"></td>
							<td></td>
							<td>教室用途：</td>
							<td id="detailclsusage"></td>
						</tr>
						<tr>
							<td>启用状态：</td>
							<td id="detailclsisused"></td>
						</tr>
					</table>
      			</div>
      			<div class="modal-footer">
        			<button id="detail" type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
      			</div>
    		</div> 	
    </div>
    <script type="text/javascript">
	    function detailclassroom(buildingname,serialnum,type,shape,classnum,examnum,seatnum,availableseatnum,maxrow,maxcol,vcorridorlocate,hcorridorlocate,floor,isamphi,usage,buildingdepartment,isused) {
			document.getElementById("detailbuildingname").innerHTML=buildingname;
			document.getElementById("detailserialnumber").innerHTML=serialnum;
			document.getElementById("detailclstype").innerHTML=type;
			document.getElementById("detailclsshape").innerHTML=shape;
			document.getElementById("detailfloor").innerHTML=floor;
			document.getElementById("detailclassnum").innerHTML=classnum;
			document.getElementById("detailexamnum").innerHTML=examnum;
			document.getElementById("detailmaxrow").innerHTML=maxrow;
			document.getElementById("detailmaxcol").innerHTML=maxcol;
			document.getElementById("detailhcorridorlocate").innerHTML=hcorridorlocate;
			document.getElementById("detailvcorridorlocate").innerHTML=vcorridorlocate;
			document.getElementById("detailbuildingdepartment").innerHTML=buildingdepartment;
			document.getElementById("detailseatnum").innerHTML=seatnum;
			document.getElementById("detailavailableseatnum").innerHTML=availableseatnum;
			document.getElementById("detailclsisamphi").innerHTML=isamphi;
			document.getElementById("detailclsusage").innerHTML=usage;
			document.getElementById("detailclsisused").innerHTML=isused;
		}

	    function setletter(){
			$("font").filter('.twoword').css("letter-spacing",document.body.scrollWidth/25); 
			$("font").filter('.threeword').css("letter-spacing",document.body.scrollWidth/40); 
			$("font").filter('.fourword').css("letter-spacing",document.body.scrollWidth/80); 
			$("font").filter('.fiveword').css("letter-spacing",document.body.scrollWidth/130); 
			$("font").filter('.sixword').css("letter-spacing",document.body.scrollWidth/300); 
		}
	    function newnext(){
			if(document.getElementById("newpass").innerHTML=='下一步'){
				document.getElementById("newpass").innerHTML='上一步';
				document.getElementById("newfirst").style.display='none';
				document.getElementById("newsecond").style.display='block';
			}
			else{
				document.getElementById("newpass").innerHTML='下一步';
				document.getElementById("newfirst").style.display='block';
				document.getElementById("newsecond").style.display='none';
			}
		}
		function updatenext(){
			if(document.getElementById("updatepass").innerHTML=='下一步'){
				document.getElementById("updatepass").innerHTML='上一步';
				document.getElementById("updatefirst").style.display='none';
				document.getElementById("updatesecond").style.display='block';
			}
			else{
				document.getElementById("updatepass").innerHTML='下一步';
				document.getElementById("updatefirst").style.display='block';
				document.getElementById("updatesecond").style.display='none';
			}
		}
    	function spreadorshrink(){
    		if(document.getElementById("spsh").innerHTML=='展开'){
    			document.getElementById("spsh").innerHTML='收起';
    			document.getElementById("displaylist").style.display='block';
    		}
    		else{
    			document.getElementById("spsh").innerHTML='展开';
    			document.getElementById("displaylist").style.display='none';
    		}
    	}
    	function displayli(){
    		document.getElementById("displaylist").style.display="none";
    		document.getElementById("spsh").style.display='block';
    		document.getElementById("spsh").innerHTML='展开';
    	}
    	function updateclassroom(i,serialnum,type,shape,classnum,examnum,seatnum,availableseatnum,maxrow,maxcol,vcorridorlocate,hcorridorlocate,floor,isamphi,usage,area,location,hasmicrophone,isused) {
    		$("#updateclsid").val(i);
    		$("#updateserialnumber").val(serialnum);
			$("#updateclstype").val(type);
			$("#updateclsshape").val(shape);
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
			$("#updateclslocation").val(location);
			$("#updateclsisamphi").val(isamphi);
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
				if ($("#searchisamphi option:selected").val() == "是")
					$("#searchisamphi option:selected").val(1);
				if ($("#searchisamphi option:selected").val() == "否")
					$("#searchisamphi option:selected").val(2);
				if ($("#searchhasmicrophone option:selected").val() == "有话筒")
					$("#searchhasmicrophone option:selected").val(1);
				if ($("#searchhasmicrophone option:selected").val() == "无话筒")
					$("#searchhasmicrophone option:selected").val(2);
				if ($("#searchisused option:selected").val() == "启用")
					$("#searchisused option:selected").val(1);
				if ($("#searchisused option:selected").val() == "停用")
					$("#searchisused option:selected").val(2);
				var str="<form id=\"deleteform\"><table class=\"table\"><thead><tr><th>&nbsp;</th><th>教学楼名称</th><th>教室编号</th><th>教室类型</th><th>所属单位</th><th>上课人数</th><th>总座位数</th><th>有效座位数</th><th>楼层</th><th>启用状态</th></thead><tbody>";
				$.ajax({
					url:"/cims107/ClassroomSearch",
					async:false,
					data: $("#searchform").serialize(),
					dataType:"json",
						}).done(
					function(data){
						if (data.length!=0)
						{
							var classroom = jQuery.parseJSON(data)
							
							$.each(classroom,function(i,classroom){
								if (classroom.clsIsAmphi==1)
									var isAmphi = "是";
								if (classroom.clsIsAmphi==2)
									var isAmphi = "否";
								if (classroom.clsHasMicrophone==1)
									var hasMicrophone = "有话筒";
								if (classroom.clsHasMicrophone==2)
									var hasMicrophone = "无话筒";
								if (classroom.clsIsUsed==1)
									var isUsed = "启用";
								if (classroom.clsIsUsed==2)
									var isUsed = "停用";
								str+=("<tr><td><input id=\"check\" type=\"checkbox\" name=\"clsid\" value="
										+classroom.clsId+"></td><td>"+classroom.building.buildingName+"</td><td>"+classroom.clsSerialNumber+"</td><td>"+classroom.clsType+"</td><td>"+classroom.building.buildingDepartment+"</td><td>"+classroom.clsClassNum+"</td><td>"+classroom.clsSeatNum+"</td><td>"+classroom.clsAvailableSeatNum+"</td><td>"+classroom.clsFloor+"</td><td>"+isUsed+"</td><td><button href=\"#clsupdate\" id=\"updateid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"updateclassroom("+classroom.clsId+",'"+classroom.clsSerialNumber+"','"+classroom.clsType+"','"+classroom.clsShape+"',"+classroom.clsClassNum+","+classroom.clsExamNum+","+classroom.clsSeatNum+","+classroom.clsAvailableSeatNum+","+classroom.clsMaxRow+","+classroom.clsMaxCol+",'"+classroom.clsVCorridorLocate+"','"+classroom.clsHCorridorLocate+"',"+classroom.clsFloor+",'"+isAmphi+"','"+classroom.clsUsage+"',"+classroom.clsArea+",'"+classroom.clsLocation+"','"+hasMicrophone+"','"+isUsed+"')\">修改</button></td><td><button href=\"#clsdetail\" id=\"detailid\" style=\"height:30px\" data-toggle=\"modal\" class=\"btn btn-primary\" onclick=\"detailclassroom('"+classroom.building.buildingName+"','"+classroom.clsSerialNumber+"','"+classroom.clsType+"','"+classroom.clsShape+"',"+classroom.clsClassNum+","+classroom.clsExamNum+","+classroom.clsSeatNum+","+classroom.clsAvailableSeatNum+","+classroom.clsMaxRow+","+classroom.clsMaxCol+",'"+classroom.clsVCorridorLocate+"','"+classroom.clsHCorridorLocate+"',"+classroom.clsFloor+",'"+isAmphi+"','"+classroom.clsUsage+"','"+classroom.building.buildingDepartment+"','"+isUsed+"')\">详细信息</button></td></tr>");
					        });
							str+=("</table></form>");
							document.getElementById('result').innerHTML=str;
							displayli();
							//document.getElementById('result').innerHTML=<button href="#del" data-toggle="modal" class="btn btn-primary">删除</button>;
						}
						else
							document.getElementById('result').innerHTML=null;
					}	
				);
				
			});
		
		$("#new").click(
				function() {
					if($("#newbuildingname").val() == ""){  
				    	alert("请填写教学楼名称!");  
				    	return false;  
				    } 
				    if($("#newserialnum").val() == ""){ 
				    	alert("请填写教室编号!");  
				        return false;  
				    } 
				    if($("#newfloor").val() == ""){  
				    	alert("请填写楼层数!");  
				    	return false;  
				    }  
				    if($("#newclsnum").val() == ""){ 
				    	alert("请填写上课人数!");  
				        return false;  
				    }
				    if($("#newclsseatnum").val() == ""){  
				    	alert("请填写总座位数!");  
				    	return false;  
				    }  
				    if($("#newclsavailableseatnum").val() == ""){ 
				    	alert("请填写有效座位数!");  
				        return false;  
				    }
	//			    var z = /^[1-9]d*$/;
	
 				    var reg = new RegExp("^[0-9]*$");
 				    var regt = new RegExp("^[1-9]d*.d*|0.d*[1-9]d*|0?.0+$");
// 				    if (!reg.test($("#newexamnum").val()) && $("#newexamnum").val() != ""){
// 				    	alert("数字输入错误！");
// 				    	if($("#newmaxrow").val().match(z) == null && $("#newmaxrow").val() != ""){
// 				    		if($("#newmaxcol").val().match(z) == null && $("#newmaxcol").val() != ""){
// 				    			if($("#newarea").val().match(/^[1-9]d*.d*|0.d*[1-9]d*|0?.0+$/) == null && $("#newarea").val() != ""){
// 				    				if($("#newfloor").val().match(z) == null || $("#newclsnum").val().match(z) == null || $("#newclsseatnum").val().match(z) == null || $("#newclsavailableseatnum").val().match(z) == null){
// 								    	alert("数字输入错误！");
// 								    	return false;
// 								    }
// 				    			}
				    			
// 				    		}
				    		
// 				    	}
				    	
// 				    }
 				   if(!reg.test($("#newfloor").val()) || !reg.test($("#newclsnum").val()) || !reg.test($("#newclsseatnum").val()) || !reg.test($("#newclsavailableseatnum").val()) || !reg.test($("#newexamnum").val()) && $("#newexamnum").val() != "" || !reg.test($("#newmaxrow").val()) && $("#newmaxrow").val() != "" || !reg.test($("#newmaxcol").val()) && $("#newmaxcol").val() != "" || !regt.test($("#newarea").val()) && $("#newarea").val() != ""){
				    	alert("数字输入错误！");
				    	return false;
				    }
// 				    if($("#newfloor").val().match(z) == null || $("#newclsnum").val().match(z) == null || $("#newclsseatnum").val().match(z) == null || $("#newclsavailableseatnum").val().match(z) == null || $("#newexamnum").val().match(z) == null && $("#newexamnum").val() != "" || $("#newmaxrow").val().match(z) == null && $("#newmaxrow").val() != "" || $("#newmaxcol").val().match(z) == null && $("#newmaxcol").val() != "" || $("#newarea").val().match(/^[1-9]d*.d*|0.d*[1-9]d*|0?.0+$/) == null && $("#newarea").val() != ""){
// 				    	alert("数字输入错误！");
// 				    	return false;
// 				    }
// 					if($("#newfloor").val().match(/^[1-9]d*$/) == null || $("#newclsnum").val().match(/^[1-9]d*$/) == null || $("#newclsseatnum").val().match(/^[1-9]d*$/) == null || $("#newclsavailableseatnum").val().match(/^[1-9]d*$/) == null || $("#newexamnum").val().match(/^[1-9]d*|0$/) == null || $("#newmaxrow").val().match(/^[1-9]d*|0$/) == null || $("#newmaxcol").val().match(/^[1-9]d*|0$/) == null || $("#newarea").val().match(/^[1-9]d*.d*|0.d*[1-9]d*|0?.0+$/) == null){
//  				    	alert("数字输入错误！");
//  				    	return false;
//  				    }
				    if(parseInt($("#newclsseatnum").val()) < parseInt($("#newclsavailableseatnum").val())){
				    	alert("有效座位数应小于总座位数！");
				    	return false;
				    }
				    if(parseInt($("#newclsnum").val()) > parseInt($("#newclsavailableseatnum").val())){
				    	alert("上课人数应小于有效座位数！");
				    	return false;
				    }
				    if(parseInt($("#newexamnum").val()) > parseInt($("#newclsavailableseatnum").val())){
				    	alert("考试人数应小于有效座位数！");
				    	return false;
				    }
				    console.log($("#newhlocation").val());
				    var hlocation = $("#newhlocation").val().split(";");
				    for (var i=0,h; h=hlocation[i++];){
				    	if(!reg.test(h.split(",")[0])){
				    		alert("不存在的横走廊位置！");
				    		return false;
				    	}
				    	if($("#newmaxrow").val() != ""){
				    		if(parseInt(h.split(",")[1]) > parseInt($("#newmaxrow").val())){
				    			alert("不存在的横走廊位置！");
				    			return false;
				    		}
				    	}
				    }
				    var vlocation = $("#newvlocation").val().split(";");
				    for (var i=0,v; v=vlocation[i++];){
				    	if(!reg.test(v.split(",")[0])){
				    		alert(v.split(","));
				    		return false;
				    	}
				    	if($("#newmaxcol").val() != ""){
				    		if(parseInt(v.split(",")[1]) > parseInt($("#newmaxcol").val())){
				    			alert("不存在的竖走廊位置！");
				    			return false;
				    		}
				    	}
				    }
					if ($("#newisamphi option:selected").val() == "是")
						$("#newisamphi option:selected").val(1);
					if ($("#newisamphi option:selected").val() == "否")
						$("#newisamphi option:selected").val(2);
					if ($("#newhasmicrophone option:selected").val() == "有话筒")
						$("#newhasmicrophone option:selected").val(1);
					if ($("#newhasmicrophone option:selected").val() == "无话筒")
						$("#newhasmicrophone option:selected").val(2);
					if ($("#newisused option:selected").val() == "启用")
						$("#newisused option:selected").val(1);
					if ($("#newisused option:selected").val() == "停用")
						$("#newisused option:selected").val(2);
					$.ajax({
						url:"/cims107/ClassroomCreate",
						async:false,
						data: $("#createform").serialize(),
						dataType:"json",
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
							dataType:"json",
							success: function(result) 
            				{
								alert("删除成功！");
            				}}
						);
					}
				});
		$("#update").click(
			function() {
			    if($("#updateserialnumber").val() == ""){ 
			    	alert("请填写教室编号!");  
			        return false;  
			    } 
			    if($("#updatefloor").val() == ""){  
			    	alert("请填写楼层数!");  
			    	return false;  
			    }  
			    if($("#updateclassnum").val() == ""){ 
			    	alert("请填写上课人数!");  
			        return false;  
			    }
			    if($("#updateseatnum").val() == ""){  
			    	alert("请填写总座位数!");  
			    	return false;  
			    }  
			    if($("#updateavailableseatnum").val() == ""){ 
			    	alert("请填写有效座位数!");  
			        return false;  
			    }
			    var reg = new RegExp("^[0-9]*$");
				var regt = new RegExp("^[1-9]d*.d*|0.d*[1-9]d*|0?.0+$");
				if(!reg.test($("#updatefloor").val()) || !reg.test($("#updateclassnum").val()) || !reg.test($("#updateseatnum").val()) || !reg.test($("#updateavailableseatnum").val()) || !reg.test($("#updateexamnum").val()) && $("#updateexamnum").val() != "" || !reg.test($("#updatemaxrow").val()) && $("#updatemaxrow").val() != "" || !reg.test($("#updatemaxcol").val()) && $("#updatemaxcol").val() != "" || !regt.test($("#updatearea").val()) && $("#updatearea").val() != ""){
 			    	alert("数字输入错误！");
 			    	return false;
 			    }
			    if(parseInt($("#updateseatnum").val()) < parseInt($("#updateavailableseatnum").val())){
			    	alert("有效座位数应小于总座位数！");
			    	return false;
			    }
			    if(parseInt($("#updateclassnum").val()) > parseInt($("#updateavailableseatnum").val())){
			    	alert("上课人数应小于有效座位数！");
			    	return false;
			    }
			    if(parseInt($("#updateexamnum").val()) > parseInt($("#updateavailableseatnum").val())){
			    	alert("考试人数应小于有效座位数！");
			    	return false;
			    }
			    var hlocation = $("#updatehcorridorlocate").val().split(";");
			    for (var i=0,h; h=hlocation[i++];){
			    	if(!reg.test(h.split(",")[0])){
			    		alert("不存在的横走廊位置！");
			    		return false;
			    	}
			    	if($("#updatemaxrow").val() != ""){
			    		if(parseInt(h.split(",")[1]) > parseInt($("#updatemaxrow").val())){
			    			alert("不存在的横走廊位置！");
			    			return false;
			    		}
			    	}
			    }
			    var vlocation = $("#updatevcorridorlocate").val().split(";");
			    for (var i=0,v; v=vlocation[i++];){
			    	if(!reg.test(v.split(",")[0])){
			    		alert(v.split(","));
			    		return false;
			    	}
			    	if($("#updatemaxcol").val() != ""){
			    		if(parseInt(v.split(",")[1]) > parseInt($("#updatemaxcol").val())){
			    			alert("不存在的竖走廊位置！");
			    			return false;
			    		}
			    	}
			    }
					if ($("#updateclsisamphi option:selected").val() == "是")
						$("#updateclsisamphi option:selected").val(1);
					if ($("#updateclsisamphi option:selected").val() == "否")
						$("#updateclsisamphi option:selected").val(2);
					if ($("#updateclshasmicrophone option:selected").val() == "有话筒")
						$("#updateclshasmicrophone option:selected").val(1);
					if ($("#updateclshasmicrophone option:selected").val() == "无话筒")
						$("#updateclshasmicrophone option:selected").val(2);
					if ($("#updateclsisused option:selected").val() == "启用")
						$("#updateclsisused option:selected").val(1);
					if ($("#updateclsisused option:selected").val() == "停用")
						$("#updateclsisused option:selected").val(2);
					$.ajax({
						url:"/cims107/ClassroomUpdate",
						async:false,
						data: $("#updateform").serialize(),
						dataType:"json",
						success: function(result) 
            			{
							alert("修改成功！");
            			}}
					);
					
				});
	</script>
</body>
</html>