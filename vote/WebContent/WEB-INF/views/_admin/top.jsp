<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  <style>
  *{
	margin: 0;
	padding: 0;
	}
body{
	height:57px;
	overflow:hidden;
	}
  </style>
  <script type="text/javascript">
  window.onload = function ()

  {

  var aLi = document.getElementsByTagName("li");
  var i = 0;
	  for (i = 0; i < aLi.length; i++){
		aLi[i].onclick = function (){
	 	for (i = 0; i < aLi.length; i++) aLi[i].className = aLi[i].className.replace(/\s?active/,"");
	  	this.className += "active";
	  	};
  	}
  };  
  $(function () {
      $(".form-control").bind('input propertychange',function () {
          var url = "<%=request.getContextPath() %>/caxun";
          var data1 = {caxun:$("[name='caxun']").val()} //json格式
          url = url+"?&rand="+Math.random();
          $.ajax({
              url:url,
              data:data,
              type:"post",
              async:true,//true为异步false为同步 默认true
              success:function (data) {
                  $("span").text(data);
              },
              error:function(){},
              complete:function(){}
          })
      })
  })
  </script>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">首页</a>
	    </div>
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="admin" target="xia">选手列表</a></li>
	        <li><a href="schedule" target="xia">选手对战安排</a></li>
	        <li><a href="Evedet" target="xia">选手对战列表</a></li>
	        <li><a href="insertuser" target="xia">新加选手</a></li>
	        <li><a href="login" target = "_top" onclick="if(confirm('确认关闭吗？')==false)return false;">注销</a></li>
	        </ul>
	  </div>
</nav> 
   </div>
</body>
</html>