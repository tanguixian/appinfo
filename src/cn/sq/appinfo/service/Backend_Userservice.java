package cn.sq.appinfo.service;


import cn.sq.appinfo.entity.Backend_User;

public interface Backend_Userservice {
	public Backend_User getByuserCodeAnduserPassword(String userCode,String userPassword);
}
