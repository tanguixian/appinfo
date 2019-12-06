package cn.sq.appinfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.App_Infodao;
import cn.sq.appinfo.entity.App_Info;
import cn.sq.appinfo.entity.Page;
import cn.sq.appinfo.service.App_Infoservice;

@Service
public class App_Infoserviceimpl implements App_Infoservice {
	@Resource
	private App_Infodao app_infodao;

	@Override
	public List<App_Info> appinfolist(Map map) {

		return app_infodao.appinfolist(map);
	}

	@Override
	public Integer Count(Map map) {
		return app_infodao.Count(map);
	}

	@Override
	public App_Info validateAPKName(String APKName) {
		// TODO Auto-generated method stub
		return app_infodao.validateAPKName(APKName);
	}

	@Override
	public Integer AddAppInfo(App_Info app_info) {
		return app_infodao.AddAppInfo(app_info);
	}

	@Override
	public App_Info findAppInfoById(Integer id) {
		
		return app_infodao.findAppInfoById(id);
	}

	@Override
	public Integer modifyAppInfo(App_Info app_info ) {
		// TODO Auto-generated method stub
		return app_infodao.modifyAppInfo(app_info);
	}

	@Override
	public Integer deleteAppInfoById(Integer id) {
		// TODO Auto-generated method stub
		return app_infodao.deleteAppInfoById(id);
	}

	@Override
	public Integer updatestatusById(Integer status, Integer id) {
		// TODO Auto-generated method stub
		return app_infodao.updatestatusById(id, status);
	}

	@Override
	public Integer updateAppInfo_versionId(Integer versionId, Integer id) {
		// TODO Auto-generated method stub
		return app_infodao.updateAppInfo_versionId(versionId, id);
	}

	@Override
	public Integer updatestatus(Integer status, Integer id) {
		// TODO Auto-generated method stub
		return app_infodao.updatestatus(status, id);
	}



}
