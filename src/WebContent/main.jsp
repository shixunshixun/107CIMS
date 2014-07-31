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
<!--   	<link href="css/bootstrap-responsive.css" rel="stylesheet"/> -->
  	<script src="js/jquery-1.11.1.min.js"></script>
  	<script src="js/bootstrap.js"></script>
  	
  	<script>
  		function iFrameHeight() { 
  			var ifm= document.getElementById("ifm"); 
  			var subWeb = document.frames ? document.frames["ifm"].document : ifm.contentDocument; 
  			if(ifm != null && subWeb != null) { 
  				ifm.height = subWeb.body.scrollHeight; 
  			}
  		}
  		setInterval(iFrameHeight,100);
  		function building(){
  			document.getElementById('ifm').src='buildingSearch.jsp';
  			document.getElementById('title').innerHTML="教学楼管理<form action=\"logout\" method=\"post\" style=\"float:right\"><button type=\"submit\" class=\"btn btn-mini\" style=\"margin-top:10px;\">退出</button></form>";
  		}
  		function classroom(){
  			document.getElementById('ifm').src='classroomSearch.jsp';
  			document.getElementById('title').innerHTML="教室管理<form action=\"logout\" method=\"post\" style=\"float:right\"><button type=\"submit\" class=\"btn btn-mini\" style=\"margin-top:10px;\">退出</button></form>";
  		}
  		function partition(){
  			document.getElementById('ifm').src='partitionSearch.jsp';
  			document.getElementById('title').innerHTML="教室划分<form action=\"logout\" method=\"post\" style=\"float:right\"><button type=\"submit\" class=\"btn btn-mini\" style=\"margin-top:10px;\">退出</button></form>";
  		}
  	</script>
</head>

<body>
	<div class="container">
  		<div style="background: -webkit-gradient(linear, left top, left bottom, from(#0A284B), to(#135887));">
    		<h1 align="center" id="title" style="margin:0;color:white">欢迎进入教室管理系统
    		<form action="logout" method="post" style="float:right">
    			<button type="submit" class="btn btn-mini" style="margin-top:10px;">退出</button>
    		</form>
    		</h1>
  		</div>
  		<div class="row">
    		<div class="span2 well pricehover" style="height:700px;">
      			<ul class="nav nav-tabs nav-stacked">
        			<li><a onclick="building();">教学楼管理</a></li>
        			<li><a onclick="classroom();">教室管理</a></li>
        			<li><a onclick="partition();">教室划分</a></li>
     	 		</ul>
    		</div>
    		<div class="span12" id=manage" style="margin-top:30px">
    			<IFRAME id="ifm" frameborder="no" scrolling="no" width="100%" height="100%" name="ifmbuilding"></IFRAME>
    		</div>
    	</div>
	</div>
</body>
</html>