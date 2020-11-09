package com.ygode.bean;

public class users {
 private int id; //用户ID
 private String username; //用户账号
 private String user_pass; //用户密码
 private String user_nicename; //昵称
 private String user_email; //邮箱
 private String user_registered; //注册时间
 private int user_status; //用户状态
 private int user_right; //用户权限
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUser_pass() {
	return user_pass;
}
public void setUser_pass(String user_pass) {
	this.user_pass = user_pass;
}
public String getUser_nicename() {
	return user_nicename;
}
public void setUser_nicename(String user_nicename) {
	this.user_nicename = user_nicename;
}
public String getUser_email() {
	return user_email;
}
public void setUser_email(String user_email) {
	this.user_email = user_email;
}
public String getUser_registered() {
	return user_registered;
}
public void setUser_registered(String user_registered) {
	this.user_registered = user_registered;
}
public int getUser_status() {
	return user_status;
}
public void setUser_status(int user_status) {
	this.user_status = user_status;
}
public int getUser_right() {
	return user_right;
}
public void setUser_right(int user_right) {
	this.user_right = user_right;
}
@Override
public String toString() {
	return "users [id=" + id + ", username=" + username + ", user_pass=" + user_pass + ", user_nicename="
			+ user_nicename + ", user_email=" + user_email + ", user_registered=" + user_registered + ", user_status="
			+ user_status + ", user_right=" + user_right + "]";
}
 
}
