package cn.sq.appinfo.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sq.appinfo.entity.App_Version;
import cn.sq.appinfo.entity.Dev_User;
import cn.sq.appinfo.service.App_Infoservice;
import cn.sq.appinfo.service.App_Versionservice;

@Controller
@RequestMapping("/app_version")
public class App_versioncontroller {
	@Resource
	private App_Versionservice app_versionservice;
	@Resource
	private App_Infoservice app_infoservice;

	@RequestMapping("/addApp_version")
	@ResponseBody
	public String addApp_version(App_Version app_version, HttpSession session, MultipartFile uploadFile,
			HttpServletRequest req) throws IllegalStateException, IOException {
		Dev_User devUser = (Dev_User) session.getAttribute("devUserSession");
		String fileName = uploadFile.getOriginalFilename();
		if (fileName != null && fileName != "") {
			// 获取上传文件的后缀
			String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
			if(extension.equals("apk")) {
			// 获取文件的运行目录
			String rootPath = req.getContextPath();
			String apkLocPath = "D:\\Y2\\SSM\\appinfo\\AppInfoSystem\\WebContent\\statics\\uploadfiles\\" + fileName;
			String downloadLink = rootPath + "/statics/uploadfiles/" + fileName;
			File file = new File(apkLocPath);
			uploadFile.transferTo(file);
			app_version.setApkLocPath(apkLocPath);
			app_version.setDownloadLink(downloadLink);
			}else {
				return "<script>alert('请选择后缀名为apk文件' );history.back();</script>";
			}
			
		}
		app_version.setApkFileName(fileName);
		app_version.setVersionInfo(app_version.getVersionNo() + "简介");
		app_version.setCreatedBy(devUser.getCreatedBy());
		app_version.setModifyBy(devUser.getModifyBy());
		app_version.setCreationDate(new Date());
		/*	用于遍历某个对象的值  修改成XXX对象 .getClass();
		 * Class cls = app_version.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			try {
				System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(app_version));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}*/
		Integer row = app_versionservice.AddApp_Version(app_version);
		app_infoservice.updateAppInfo_versionId(app_version.getId(), app_version.getAppId());

		if (row > 0) {
			return "<script>alert('新增APP版本信息成功！');location='/AppInfoSystem/appinfo/refresh.do';</script>";
		}
		return "<script>alert('新增APP版本信息失败！');history.back()</script>";
	}

	@RequestMapping("/goAppversion")
	public String goAppversion(Integer vid, Integer aid , Model model) {
		List<App_Version> list = app_versionservice.showVersionByAppId(aid);
		App_Version app_version = app_versionservice.showVersionById(vid);
		model.addAttribute("appVersionList", list);
		model.addAttribute("appVersion", app_version);
		return "developer/appversionmodify";
	}
	
	@RequestMapping("/updateAppversion")
	@ResponseBody
	public String updateAppversion(App_Version app_version, HttpSession session, MultipartFile uploadFile,
			HttpServletRequest req) throws IllegalStateException, IOException {
		Dev_User devUser = (Dev_User) session.getAttribute("devUserSession");
		String fileName = uploadFile.getOriginalFilename();
		if (fileName != null && fileName != "") {
			// 获取上传文件的后缀
			String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
			if(extension.equals("apk")) {
			// 获取文件的运行目录
			String rootPath = req.getContextPath();
			String apkLocPath = "D:\\Y2\\SSM\\appinfo\\AppInfoSystem\\WebContent\\statics\\uploadfiles\\" + fileName;
			String downloadLink = rootPath + "/statics/uploadfiles/" + fileName;
			File file = new File(apkLocPath);
			uploadFile.transferTo(file);
			app_version.setApkLocPath(apkLocPath);
			app_version.setDownloadLink(downloadLink);
			}else {
				return "<script>alert('请选择后缀名为apk文件' );history.back();</script>";
			}
			app_version.setApkFileName(fileName);
		}
		app_version.setModifyBy(devUser.getModifyBy());
		
		Integer row=	app_versionservice.updateApp_Version(app_version);
		if(row>0) {
			return "<script>alert('修改APP版本信息成功！');location='/AppInfoSystem/appinfo/refresh.do';</script>";
		}
		return "<script>alert('修改APP版本信息失败！');history.back()</script>";
	}
}
