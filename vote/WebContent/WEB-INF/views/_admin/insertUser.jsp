<%@ page language="java" import="java.util.*,com.ygode.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>选手详情表</title>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
	<!-- web路径：
	不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
	以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
			http://localhost:3306/crud
	 -->
	<script type="text/javascript"
		src="${APP_PATH }/static/js/jquery-1.12.4.js"></script>
	<link
		href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
		rel="stylesheet">
	<script
		src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/My97DatePicker/WdatePicker.js"></script>
	</head>
</script>
  <body>
  <form action="${APP_PATH }/addPlayer" method="post" id="myform" enctype="multipart/form-data"> 
    <table border="1" width="30%" cellspacing="3" align="center">
    <tr>
    <td>姓名：</td>
    <td class="bg-primary"><input type="text" id="name" class="form-control" placeholder="姓名"></td>
    </tr>
    <tr>
    <td>图片：</td>
    <td class="bg-success"><input type="file" name="url" style="border: 0px; font-size: 20px;"/></td>
    </tr>
    <tr><td colspan="2" align="center">
    <input type="submit" value="提交添加" id="submit" class="reg_btn" onclick="if(confirm('确认添加吗？')==false)return false;"> </div>
    </table>
  </from>
  </body>
 <script type="text/javascript">
$(function () {
	$("#submit").click(function(){
		if(confirm('确认添加吗？')==true){
	        var newUrl = 'addPlayer?name='+$("#name").val();    //设置新提交地址
	        $("#myform").attr('action',newUrl);    //通过jquery为action属性赋值
	        $("#myform").submit();    //提交ID为myform的表单
		}
	})
})
</script>
</html>