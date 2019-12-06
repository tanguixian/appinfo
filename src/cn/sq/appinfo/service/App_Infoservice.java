package cn.sq.appinfo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.entity.App_Info;
import cn.sq.appinfo.entity.Page;

public interface App_Infoservice {
	//查询条件符合map的数据
	public List<App_Info> appinfolist(Map map);
	//查询数据库总记录数
	public Integer Count(Map map);
	//查询apkname是否重复
	public App_Info validateAPKName(String APKName);
	//添加新的数据
	public Integer AddAppInfo(App_Info app_info);
	//根据id查询数据
	public App_Info findAppInfoById(Integer id);
	//根据id修改数据
	public Integer modifyAppInfo(App_Info app_info);
	
	//根据id删除指定的app信息
	public Integer deleteAppInfoById(Integer id);
	//根据id修改status字段的值
	public Integer updatestatusById(Integer status,Integer id);
	//根据id修改versionId字段的值
	public Integer updateAppInfo_versionId(Integer versionId,Integer id);
	//根据id修改status字段的值
	public Integer updatestatus(Integer status, Integer id);
}
