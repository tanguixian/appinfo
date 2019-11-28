package cn.sq.appinfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.Backend_Userdao;
import cn.sq.appinfo.entity.Backend_User;
import cn.sq.appinfo.service.Backend_Userservice;

@Service
public class Backend_Userserviceimpl implements Backend_Userservice{
	@Resource
	private Backend_Userdao backenduserdao;

	@Override
	public Backend_User getByuserCodeAnduserPassword(String userCode, String userPassword) {
		return backenduserdao.getByuserCodeAnduserPassword(userCode, userPassword);
	}
	
	
}
