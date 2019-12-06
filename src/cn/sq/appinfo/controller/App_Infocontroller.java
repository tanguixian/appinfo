package cn.sq.appinfo.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sq.appinfo.entity.App_Category;
import cn.sq.appinfo.entity.App_Info;
import cn.sq.appinfo.entity.App_Version;
import cn.sq.appinfo.entity.Backend_User;
import cn.sq.appinfo.entity.Data_Dictionary;
import cn.sq.appinfo.entity.Dev_User;
import cn.sq.appinfo.entity.Page;
import cn.sq.appinfo.service.App_Categoryservice;
import cn.sq.appinfo.service.App_Infoservice;
import cn.sq.appinfo.service.App_Versionservice;
import cn.sq.appinfo.service.Data_Dictionaryservice;

@Controller
@RequestMapping("/appinfo")
public class App_Infocontroller {
	@Resource
	private App_Infoservice app_infoservice;
	@Resource
	private App_Versionservice app_versionservice;
	@Resource
	private Data_Dictionaryservice data_ditionservice;
	@Resource
	private App_Categoryservice app_categoryservice;

	// 跳转去redirect:appInfoList.do 方法
	@RequestMapping("/befoerlist")
	public String befoerlist() {
		return "redirect:appInfoList.do";
	}

	// 获取所有app_info的所有信息
	@RequestMapping("/appInfoList")
	public String appInfoList(HttpSession session, String softwareName, Integer flatformId, Integer status,
			Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, Integer devId) {
		Page page = new Page();
		Dev_User devUser = (Dev_User) session.getAttribute("devUserSession");
		Map map = new HashMap();
		map.put("devId", devUser.getId());
		map.put("page", page);
		map.put("softwareName", softwareName);
		map.put("flatformId", flatformId);
		map.put("status", status);
		map.put("categoryLevel1", categoryLevel1);
		map.put("categoryLevel2", categoryLevel2);
		map.put("categoryLevel3", categoryLevel3);
		map.put("devId", devId);
		page.setRows(app_infoservice.Count(map));
		List<App_Info> list = app_infoservice.appinfolist(map);
		session.setAttribute("appInfoList", list);
		session.setAttribute("page", page);
		session.setAttribute("appSelectInfoMap", map);
		return "developer/appinfolist";
	}

	// 上一页和下一页的方法
	@RequestMapping("/changePage")
	public String changePage(HttpSession session, Integer pageNo) {
		Map map = (Map) session.getAttribute("appSelectInfoMap");
		Page page = (Page) map.get("page");
		page.setPageNo(pageNo);
		List<App_Info> list = app_infoservice.appinfolist(map);
		session.setAttribute("appInfoList", list);
		return "developer/appinfolist";
	}

	// 跳转去appinfoadd页面
	@RequestMapping("goaddappinfo")
	public String goadd() {
		return "developer/appinfoadd";
	}

	// 验证apkname是否重复
	@RequestMapping("/validateAPKName")
	@ResponseBody
	public Object validateAPKName(String APKName) {
		App_Info app_info = app_infoservice.validateAPKName(APKName);
		if (app_info == null) {
			return "noexist";
		}
		return "exist";
	}

	@RequestMapping("/AddAppinfo")
	@ResponseBody
	public String AddAppinfo(HttpSession session, MultipartFile uploadFile, HttpServletRequest req, App_Info app_info) {
		// 获取上传文件的后缀
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		// 获取文件的运行目录
		String rootPath = req.getContextPath();
		String newFileName = app_info.getAPKName() + "." + extension;
		String logoLocPath = "D:\\Y2\\SSM\\appinfo\\AppInfoSystem\\WebContent\\statics\\uploadfiles\\" + newFileName;
		String logoPicPath = rootPath + "/statics/uploadfiles/" + newFileName;
		File file = new File(logoLocPath);
		try {
			uploadFile.transferTo(file);
			app_info.setLogoLocPath(logoLocPath);
			app_info.setLogoPicPath(logoPicPath);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		Dev_User devUser = (Dev_User) session.getAttribute("devUserSession");
		app_info.setDevId(devUser.getId());
		Integer row = app_infoservice.AddAppInfo(app_info);
		if (row > 0) {
			return "<script>alert('新增成功！');location='/AppInfoSystem/appinfo/appInfoList.do';</script>";
		}

		return "<script>alert('新增失败！');history.back()</script>";
	}

	// 修改页面跳转
	@RequestMapping("/goappinfomodify")
	public String goappinfomodify(Model model, Integer id) {
		App_Info app_info = app_infoservice.findAppInfoById(id);
		model.addAttribute("appInfo", app_info);
		return "developer/appinfomodify";
	}

	// 修改方法
	@RequestMapping("/modifyAppInfo")
	@ResponseBody
	public String modifyAppInfo(Integer id, App_Info app_info, HttpSession session, MultipartFile uploadFile,
			HttpServletRequest req) {
		String fileName = uploadFile.getOriginalFilename();
		if (fileName != null && fileName != "") {
			// 获取上传文件的后缀
			String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
			// 获取文件的运行目录
			String rootPath = req.getContextPath();
			String newFileName = app_info.getAPKName() + "." + extension;
			String logoLocPath = "D:\\Y2\\SSM\\appinfo\\AppInfoSystem\\WebContent\\statics\\uploadfiles\\"
					+ newFileName;
			String logoPicPath = rootPath + "/statics/uploadfiles/" + newFileName;
			File file = new File(logoLocPath);
			try {
				uploadFile.transferTo(file);
				app_info.setLogoLocPath(logoLocPath);
				app_info.setLogoPicPath(logoPicPath);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		Integer row = app_infoservice.modifyAppInfo(app_info);

		if (row > 0) {
			return "<script>alert('app信息修改成功！');location='/AppInfoSystem/appinfo/refresh.do';</script>";
		}
		return "<script>alert('app信息修改失败！');history.back();</script>";
	}

	@RequestMapping("/goappinfoview")
	public String goappinfoview(Model model, Integer id) {
		App_Info app_info = app_infoservice.findAppInfoById(id);
		List<App_Version> app_Version = app_versionservice.showVersionByAppId(id);
		model.addAttribute("appVersionList", app_Version);
		model.addAttribute("appInfo", app_info);
		return "developer/appinfoview";
	}

	@RequestMapping("/deleteAppInfoById")
	@ResponseBody
	public String deleteAppInfoById(Integer id, HttpSession session) {
		Integer row = app_infoservice.deleteAppInfoById(id);
		app_versionservice.DeleteApp_versionById(id);
		Map map = (Map) session.getAttribute("appSelectInfoMap");
		Page page = (Page) map.get("page");
		page.setRows(app_infoservice.Count(map));
		if (row > 0) {
			return "true";
		}
		return "false";
	}

	@RequestMapping("/upperOrLowerShelf")
	@ResponseBody
	public String upperOrLowerShelf(Integer status, Integer appinfoid) {
		Integer row = app_infoservice.updatestatusById(status, appinfoid);
		if (row > 0) {
			return "1";
		}
		return "0";
	}

	@RequestMapping("/goappversionadd")
	public String goappversionadd(Integer id, Model model) {
		List<App_Version> appVersionList = app_versionservice.showVersionByAppId(id);
		model.addAttribute("appVersionList", appVersionList);
		model.addAttribute("appId", id);
		return "developer/appversionadd";
	}

	@RequestMapping("refresh")
	public String refresh(HttpSession session) {
		Map map = (Map) session.getAttribute("appSelectInfoMap");
		List<App_Info> list = app_infoservice.appinfolist(map);
		session.setAttribute("appInfoList", list);
		return "developer/appinfolist";
	}
	

	// 页面跳转
	@RequestMapping("goapplist")
	public String goapplist(HttpSession session) {
		List<Data_Dictionary> Statuslsit = data_ditionservice.Statuslsit("APP_FLATFORM");
		session.setAttribute("flatFormList", Statuslsit);
		List<App_Category> app_categorylist = app_categoryservice.getAppCategoryList(null);
		session.setAttribute("categoryLevel1List", app_categorylist);
		return "redirect:applist.do";
	}

	@RequestMapping("/applist")
	public String applist(HttpSession session, String softwareName, Integer flatformId, Integer status,
			Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, Integer devId, Model model) {
		Page page = new Page();
		Backend_User backenduser = (Backend_User) session.getAttribute("userSession");
		Map map = new HashMap();
		map.put("devId", backenduser.getId());
		map.put("page", page);
		map.put("softwareName", softwareName);
		map.put("flatformId", flatformId);
		map.put("status", status);
		map.put("categoryLevel1", categoryLevel1);
		map.put("categoryLevel2", categoryLevel2);
		map.put("categoryLevel3", categoryLevel3);
		map.put("devId", devId);
		map.put("status", 1);
		page.setRows(app_infoservice.Count(map));
		List<App_Info> list = app_infoservice.appinfolist(map);
		session.setAttribute("appInfoList", list);
		session.setAttribute("page", page);
		session.setAttribute("appSelectInfoMap1", map);
		return "backend/applist";
	}

	@RequestMapping("/changePage1")
	public String changePage1(HttpSession session, Integer pageNo) {
		Map map = (Map) session.getAttribute("appSelectInfoMap1");
		Page page = (Page) map.get("page");
		page.setPageNo(pageNo);
		List<App_Info> list = app_infoservice.appinfolist(map);
		session.setAttribute("appInfoList", list);
		return "backend/applist";

	}

	@RequestMapping("/goappcheck")
	public String goappcheck(Integer vid, Integer aid, Model model) {
		App_Info app_info = app_infoservice.findAppInfoById(aid);
		App_Version app_version = app_versionservice.showVersionById(vid);
		model.addAttribute("appInfo", app_info);
		model.addAttribute("appVersion", app_version);
		return "backend/appcheck";
	}
	@RequestMapping("refresh1")
	public String refresh1(HttpSession session) {
		Map map = (Map) session.getAttribute("appSelectInfoMap1");
		List<App_Info> list = app_infoservice.appinfolist(map);
		session.setAttribute("appInfoList", list);
		return "backend/applist";
	}
	@RequestMapping("/updateStatus")
	@ResponseBody
	public String updateStatus(Integer status, Integer id,HttpSession session) {
		Integer row = app_infoservice.updatestatus(status, id);
		
		Map map = (Map) session.getAttribute("appSelectInfoMap1");
		Page page = (Page) map.get("page");
		page.setRows(app_infoservice.Count(map));
		if(row>0) {
			return "<script>alert('app状态提交成功！');location='/AppInfoSystem/appinfo/refresh1.do';</script>";
		}
		return  "<script>alert('app状态提交失败！');history.back();</script>";
	}

}
