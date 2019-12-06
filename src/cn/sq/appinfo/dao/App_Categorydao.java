package cn.sq.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sq.appinfo.entity.App_Category;

public interface App_Categorydao {
	//根据参数查询
	public List<App_Category> getAppCategoryList(@Param("parentId")Integer parentId);
	
	


}
