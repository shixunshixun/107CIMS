<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登陆系统</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet"/>
  	<link href="css/bootstrap-responsive.css" rel="stylesheet"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script>
    	function check(){
    		if(document.getElementById("username").val() == ''){
    			alert("请输入用户名！");
    			return false;
    		}
    		if(document.getElementById("username").val() == ''){
    			alert("请输入用户名！");
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  
<body>
	<div class="container" style="margin-top:100px">
		<form action="login" method="post" class="well" style="width:280px;height:300px;margin:0px auto;">
			<h3>用户登录</h3>
			<label style="width:17%;">用户名:</label>
			<input type="text" id="username" name="userName" style="height:30px"class="span3"/>
			<label style="width:17%;">密码：</label>
			<input type="password" id="password" name="userPassword" style="height:30px" class="span3">
			<button onsubmit="check();" class="btn btn-primary">登陆系统</button>
		</form>
	</div>
</body>
</html>