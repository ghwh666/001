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
		<form action="#" method="post" id="myform"> 
					<table border="1" cellspacing="3" align="center">
					<tr style="display:none">
					<td>ID：</td>
					<td class="bg-primary"><input name="id" type="text" value="${id}" class="form-control"></td>
					</tr>
					<tr>
					<td>选手状态：</td>
					<td class="bg-primary">
						<select name="playerStatus" class="bg-primary">
						    <option value="">请选择</option>
						    <option value="0">0</option>
						        <option value="1">1</option>
						        <option value="-1">-1</option>
						</select>
					</td>
					</tr>
					<tr>
					<td>原因：</td>
					<td class="bg-primary"><input type="text" name="PS" class="form-control" placeholder="备注"></td>
					</tr>
					<tr><td colspan="2" align="center">
					<input type="submit" value="提交" id="submit" class="reg_btn" >
					<botton class="btn btn-success" onClick='window.close()'>关闭</botton>
					 </td>
					</tr></div>
					</table>
				</from>
</body>
<script type="text/javascript">
$("#submit").click(function(){
	$.ajax({
        type:"post",
        url:"upPlayer",
        data:$("#myform").serialize(),
        success:function (data) {
        	alert(data.IsSuccess)
            if (data.IsSuccess) {
                window.close();
            }
        }
	});
})
</script>
</html>