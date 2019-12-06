package cn.sq.appinfo.dao;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.entity.Dev_User;

public interface Dev_Userdao {
	//根据参数查询
	public Dev_User getBydevCodeAnddevPassword(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
	
}
