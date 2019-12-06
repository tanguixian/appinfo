package cn.sq.appinfo.dao;

import java.util.List;


import cn.sq.appinfo.entity.App_Version;

public interface App_Versiondao {
	public List<App_Version> showVersionByAppId(Integer appId);
	
	public Integer DeleteApp_versionById(Integer id);
	
	public Integer AddApp_Version(App_Version app_version);
	
	public Integer updateApp_Version(App_Version app_Version);
	
	public App_Version showVersionById(Integer vid);
	
}
