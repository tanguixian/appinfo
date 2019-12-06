package cn.sq.appinfo.dao;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.entity.Backend_User;

public interface Backend_Userdao {
	//根据参数查询
	public Backend_User getByuserCodeAnduserPassword(@Param("userCode")String userCode,@Param("userPassword")String userPassword);

}
