package cn.sq.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sq.appinfo.entity.Dev_User;
import cn.sq.appinfo.service.Dev_Userservice;

@Controller
@RequestMapping("/dev_user")
public class Dev_Usercontroller {

	@Resource
	private Dev_Userservice devuser;

	// ��תȥ�����ߵ���ҳ��
	@RequestMapping("/befoerlogin")
	public String befoerlogin() {
		return "devlogin";
	}

	// ʵ�ֿ����ߵ��빦��
	@RequestMapping("/login")
	public String login(String devCode, String devPassword, Model model, HttpSession session) {
		Dev_User dev_User = devuser.getBydevCodeAnddevPassword(devCode, devPassword);
		if (dev_User != null) {
			session.setAttribute("devUserSession", dev_User);
			return "developer/main";
		} else {
			model.addAttribute("error", "�û���������������������룡");
			return "devlogin";
		}

	}
	
	//ע������
	@RequestMapping("/Cancellation")
	public String Cancellation(HttpSession session) {
		session.invalidate();
		return "devlogin";
	}

}
