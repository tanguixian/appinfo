package cn.sq.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sq.appinfo.entity.Backend_User;
import cn.sq.appinfo.service.Backend_Userservice;

@Controller
@RequestMapping("/backend_user")
public class Backend_Usercontroller {

	@Resource
	private Backend_Userservice backenduserservice;

	// ��תȥ�û�����ҳ��
	@RequestMapping("/befoerlogin")
	public String befoerlogin() {
		return "backendlogin";
	}

	// �û����빦��
	@RequestMapping("/login")
	public String login(String userCode, String userPassword, Model model, HttpSession session) {
		Backend_User backend_User = this.backenduserservice.getByuserCodeAnduserPassword(userCode, userPassword);
		if (backend_User != null) {
			session.setAttribute("userSession", backend_User);
			return "backend/main";
		} else {
			model.addAttribute("error", "�û���������������������룡");
			return "backendlogin";
		}

	}
	//ע������
	@RequestMapping("/Cancellation")
	public String Cancellation(HttpSession session) {
		session.invalidate();
		return "backendlogin";
	}

}
