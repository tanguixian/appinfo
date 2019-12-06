package cn.sq.appinfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.entity.App_Info;

public interface App_Infodao {
	//根据参数查询信息列表
	public List<App_Info> appinfolist(Map map);
	
	public Integer Count(Map map);
	//查询数据
	public App_Info validateAPKName(String APKName);
	//增加数据
	public Integer AddAppInfo(App_Info app_info);
	//根据参数查询数据
	public App_Info findAppInfoById(Integer id);
	//根据参数修改
	public Integer modifyAppInfo(App_Info app_info);
	//删除数据
	public Integer deleteAppInfoById(Integer id);
	//根据参数修改单个值
	public Integer updatestatusById(@Param("id")Integer id,@Param("status")Integer status);
	//根据参数修改单个值
	public Integer updateAppInfo_versionId(@Param("versionId")Integer versionId, @Param("id") Integer id);
	
	public Integer updatestatus(@Param("status")Integer status,@Param("id") Integer id);
}
