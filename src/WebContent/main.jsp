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
  		function iFrameHeightcls() { 
  			var ifm= document.getElementById("ifmclassroom"); 
  			var subWeb = document.frames ? document.frames["ifmclassroom"].document : ifm.contentDocument; 
  			if(ifm != null && subWeb != null) { 
  				ifm.height = subWeb.body.scrollHeight; 
  			} 
  		}
  		function iFrameHeightbld() { 
  			var ifm= document.getElementById("ifmbuilding"); 
  			var subWeb = document.frames ? document.frames["ifmbuilding"].document : ifm.contentDocument; 
  			if(ifm != null && subWeb != null) { 
  				ifm.height = subWeb.body.scrollHeight; 
  			} 
  		}
  		function iFrameHeightptt() { 
  			var ifm= document.getElementById("ifmpartition"); 
  			var subWeb = document.frames ? document.frames["ifmpartition"].document : ifm.contentDocument; 
  			if(ifm != null && subWeb != null) { 
  				ifm.height = subWeb.body.scrollHeight; 
  			} 
  		}
  		function building(){
  			//document.getElementById('ifmbuilding').src='buildingSearch.jsp';
  			document.getElementById('buildingmanage').style.display = 'block';
  			if (document.getElementById('classroommanage').style.display == 'block')
  				document.getElementById('classroommanage').style.display = 'none';
  			if (document.getElementById('partitionmanage').style.display == 'block')
  				document.getElementById('partitionmanage').style.display = 'none';
  			document.getElementById("title").innerHTML="教学楼管理";
  		}
  		function classroom(){
  			//document.getElementById('ifmclassroom').src='classroomSearch.jsp';
  			document.getElementById('classroommanage').style.display = 'block';
  			if (document.getElementById('buildingmanage').style.display == 'block')
  				document.getElementById('buildingmanage').style.display = 'none';
  			if (document.getElementById('partitionmanage').style.display == 'block')
  				document.getElementById('partitionmanage').style.display = 'none';	
  			document.getElementById("title").innerHTML="教室管理";
  		}
  		function partition(){
  			//document.getElementById('ifmbuilding').src='buildingSearch.jsp';
  			document.getElementById('partitionmanage').style.display = 'block';
  			if (document.getElementById('classroommanage').style.display == 'block')
  				document.getElementById('classroommanage').style.display = 'none';
  			if (document.getElementById('buildingmanage').style.display == 'block')
  				document.getElementById('buildingmanage').style.display = 'none';
  			document.getElementById("title").innerHTML="教室资源划分";
  		}
  	</script>
</head>

<body>
	<div class="container">
  		<div>
    		<h1 align="center" id="title">欢迎进入教室管理系统</h1>
  		</div>
  		<div class="row">
    		<div class="span2">
      			<ul>
        			<li><a onclick="building();">教学楼管理</a> </li>
        			<li><a onclick="classroom();">教室管理</a></li>
        			<li><a onclick="partition();">教室划分</a></li>
     	 		</ul>
    		</div>
    		<div class="span8 hide" id="buildingmanage">
    			<IFRAME id="ifmbuilding" frameborder="no" scrolling="no" onLoad="iFrameHeightbld()" width="100%" height="100%" name="ifmbuilding" src="buildingSearch.jsp"></IFRAME>
    		</div>
    		<div class="span8 hide" id="classroommanage">
    			<IFRAME id="ifmclassroom" frameborder="no" scrolling="no" onLoad="iFrameHeightcls()" width="100%" height="100%" name="ifmclassroom" src="classroomSearch.jsp"></IFRAME>
			</div>
			<div class="span8 hide" id="partitionmanage">
    			<IFRAME id="ifmpartition" frameborder="no" scrolling="no" onLoad="iFrameHeightptt()" width="100%" height="100%" name="ifmpartition" src="partitionSearch.jsp"></IFRAME>
    		</div>
  		</div>
	</div>
</body>
</html>