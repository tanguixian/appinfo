package cn.sq.appinfo.service;

import java.util.List;

import cn.sq.appinfo.entity.App_Version;

public interface App_Versionservice {
	//根据appId查询对应的的数据
	public List<App_Version> showVersionByAppId(Integer appId);
	//根据id删除对应的数据
	public Integer DeleteApp_versionById(Integer id);
	//添加新的数据
	public Integer AddApp_Version(App_Version app_version);
	//根据vid查询对应的的数据
	public App_Version showVersionById(Integer vid);
	//根据参数修改数据
	public Integer updateApp_Version(App_Version app_Version);
	
}
