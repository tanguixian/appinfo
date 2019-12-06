package cn.sq.appinfo.service;


import cn.sq.appinfo.entity.Backend_User;

public interface Backend_Userservice {
	//实现管理员的登入
	public Backend_User getByuserCodeAnduserPassword(String userCode,String userPassword);
}
