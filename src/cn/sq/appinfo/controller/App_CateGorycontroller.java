package cn.sq.appinfo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sq.appinfo.entity.App_Category;
import cn.sq.appinfo.entity.Data_Dictionary;
import cn.sq.appinfo.service.App_Categoryservice;
import cn.sq.appinfo.service.Data_Dictionaryservice;
@Controller
@RequestMapping("/app_category")
public class App_CateGorycontroller {
	@Resource
	private App_Categoryservice app_categoryservice;
	@Resource
	private Data_Dictionaryservice data_ditionservice;
	
	//查询一级标题和所属平台及APP状态
	@RequestMapping("/befoerlist")
	public String befoerlist(HttpSession session , String pid ) {
		List<Data_Dictionary> Statuslsit =data_ditionservice.Statuslsit("APP_STATUS");
		List<Data_Dictionary> Statuslsit2 =data_ditionservice.Statuslsit("APP_FLATFORM");
		List<App_Category> list= app_categoryservice.getAppCategoryList(null);
		session.setAttribute("categoryLevel1List", list);
		session.setAttribute("statusList", Statuslsit);
		session.setAttribute("flatFormList", Statuslsit2);
		return "redirect:/appinfo/befoerlist.do";
	}
	
	
	//实现二级标题和三级标题的数据查询
	@RequestMapping("/Catelinkage")
	@ResponseBody
	public Object Catelinkage(Integer  pid) {
		return app_categoryservice.getAppCategoryList(pid);
	}
	
	
}
