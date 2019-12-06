package cn.sq.appinfo.service;

import java.util.List;

import cn.sq.appinfo.entity.App_Category;

public interface App_Categoryservice {
	//查询标题的信息
	public List<App_Category> getAppCategoryList(Integer parentId);

}
