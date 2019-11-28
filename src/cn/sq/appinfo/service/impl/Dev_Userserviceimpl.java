package cn.sq.appinfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.Dev_Userdao;
import cn.sq.appinfo.entity.Dev_User;
import cn.sq.appinfo.service.Dev_Userservice;
@Service
public class Dev_Userserviceimpl implements Dev_Userservice {
	@Resource
	private Dev_Userdao devuserdao;

	@Override
	public Dev_User getBydevCodeAnddevPassword(String devCode, String devPassword) {
		return devuserdao.getBydevCodeAnddevPassword(devCode, devPassword);
	}
	
	
	

}
