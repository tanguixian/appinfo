package cn.sq.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.App_Versiondao;
import cn.sq.appinfo.entity.App_Version;
import cn.sq.appinfo.service.App_Versionservice;
@Service
public class App_Versionserviceimpl implements App_Versionservice {
@Resource
private App_Versiondao app_versiondao;
	@Override
	public List<App_Version> showVersionByAppId(Integer appId) {
		return app_versiondao.showVersionByAppId(appId);
	}
	@Override
	public Integer DeleteApp_versionById(Integer id) {
		// TODO Auto-generated method stub
		return app_versiondao.DeleteApp_versionById(id);
	}
	@Override
	public Integer AddApp_Version(App_Version app_version) {
		return app_versiondao.AddApp_Version(app_version);
	}
	@Override
	public App_Version showVersionById(Integer vid) {
		// TODO Auto-generated method stub
		return app_versiondao.showVersionById(vid);
	}
	@Override
	public Integer updateApp_Version(App_Version app_Version) {
		// TODO Auto-generated method stub
		return app_versiondao.updateApp_Version(app_Version);
	}

}
