<%@ page language="java" import="java.util.*,com.ygode.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>用户详情表</title>
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
	</head>
</script>
  <body>
    <!-- 搭建显示页面 -->
	<div class="container">
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-6">
				<table class="table table-hover">
					<tr>
						<th>列项</th>
						<th>选手1</th>
						<th>选手2</th>
					</tr>
					<tr>
						<th>比赛ID</th>
						<th colspan="2"  class="col-md-4">${tl.getId()}</th>
					</tr>
					<tr>
						<th>选手ID</th>
						<th>${tl.getPlayerOne()}</th>
						<th>${tl.getPlayerTwo()}</th>
					</tr>
					<tr>
						<th>选手姓名</th>
						<th>${tl.getPlayerOneID()}</th>
						<th>${tl.getPlayerTwoID()}</th>
					</tr>
					<tr>
						<th>比赛歌曲</th>
						<th>${tl.getSongOne()}</th>
						<th>${tl.getSongTwo()}</th>
					</tr>
					<tr>
						<th>评委分数</th>
						<th>${tl.getScoreOne()}</th>
						<th>${tl.getScoreTwo()}</th>
					</tr>
					<tr>
						<th>票数</th>
						<th>${tl.getTicketOne()}</th>
						<th>${tl.getTicketTwo()}</th>
					</tr>
					<tr>
						<th>背景</th>
						<th colspan="2" class="col-md-4">${tl.getUrl()}</th>
					</tr>
					<tr>
					<th colspan="3" class="col-md-6">
    	<a class="btn btn-default,btn btn-primary" href="${APP_PATH }/admin/Evedet">返回</a>
					</th>
					</tr>
				</table>
			</div>
		</div>
  </body>
</html>