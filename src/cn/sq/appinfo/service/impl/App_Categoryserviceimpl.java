package cn.sq.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.App_Categorydao;
import cn.sq.appinfo.entity.App_Category;
import cn.sq.appinfo.service.App_Categoryservice;
@Service
public class App_Categoryserviceimpl implements App_Categoryservice {
	@Resource
	private App_Categorydao ad;

	@Override
	public List<App_Category> getAppCategoryList(Integer parentId) {
		return ad.getAppCategoryList(parentId);
	}

}
