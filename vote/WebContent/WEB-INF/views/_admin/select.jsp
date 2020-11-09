<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
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
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>player_id</th>
						<th>选手姓名</th>
						<th>选手图片</th>
						<th>选手状态</th>
						<th colspan="2" class="col-md-3">操作</th>
					</tr>
					<c:forEach var="tl" items="${page.list}">
						<tr>
							<th>${tl.getId()}</th>
							<th>${tl.getPlayerName() }</th>
							<th><img src="${APP_PATH }/static/img/${tl.getPlayerImg() }" alt="头像" draggable="false" height="50" width="50"></th>
							<th>${tl.getPlayer_status() }</th>
							<th>
<button class="btn btn-success" onclick="openwin(${tl.getId()})" >
	更改
</button>
			</th>
               				<th><c:choose>
							   <c:when test="${tl.getId()}==1">
               					 
							   </c:when>
							   <c:otherwise> 
               					
							   </c:otherwise>
							</c:choose>
               				</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6">当前 ${page.pageNum }页,总${page.pages }
				页,总 ${page.total } 条记录</div>
			<!-- 分页条信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${APP_PATH }/admin/admin?pn=1">首页</a></li>
					<c:if test="${page.hasPreviousPage }">
						<li><a href="${APP_PATH }/admin/admin?pn=${page.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach items="${page.navigatepageNums }" var="page_Num">
						<c:if test="${page_Num == page.pageNum }">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num != page.pageNum }">
							<li><a href="${APP_PATH }/admin/admin?pn=${page_Num }">${page_Num }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${page.hasNextPage }">
						<li><a href="${APP_PATH }/admin/admin?pn=${page.pageNum+1 }"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="${APP_PATH }/admin/admin?pn=${page.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
<!--
function openwin(id) {
window.open ("zewai1?id="+id, "newwindow", "height=400, width=600, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") //写成一行

}
-->
</script>
</html>