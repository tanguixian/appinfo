package cn.sq.appinfo.service;


import cn.sq.appinfo.entity.Dev_User;

public interface Dev_Userservice {
	//�����ߵ���
	public Dev_User getBydevCodeAnddevPassword(String devCode,String devPassword);
}
