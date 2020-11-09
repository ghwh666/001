function isEmail(strEmail) {
if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
return true;
else
alert("oh");
}
<form action="${APP_PATH }/admin/insertuser" method="post" id="myform"> 
<table border="1" width="30%" cellspacing="3" align="center">
<tr sty>
<td>ID：</td>
<td class="bg-primary"><input type="text" name="user_pass" class="form-control" id="exampleInputEmail1" placeholder="姓名"></td>
</tr>
<tr>
<td>姓名：</td>
<td class="bg-primary"><input type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="姓名" onkeyup="value='/oblog/value.replace(/[^\u4E00-\u9FA5]/g,'')' "></td>
</tr>
<tr>
<td>昵称：</td>
<td class="bg-success"><input type="text" name="user_nicename" class="form-control" id="exampleInputEmail1" placeholder="昵称" onkeyup="value='/oblog/value.replace(/[\W]/g,'')' "onbeforepaste="clipboardData. setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"></td>
</tr>
<tr>
<td>邮箱：</td>
<td>
 <input name="user_email" type="text" class="form-control" placeholder="邮箱" onblur=isEmail(this.value)>/>
</td>
</tr>
<tr><td colspan="2" align="center">
<input type="submit" value="提交添加" id="submit" class="reg_btn" onclick="if(confirm('确认添加吗？')==false)return false;"> </div>
</table>
</from>