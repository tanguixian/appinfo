package cn.sq.appinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sq.appinfo.entity.Data_Dictionary;
import cn.sq.appinfo.service.Data_Dictionaryservice;

@Controller
@RequestMapping("/data_diciontary")
public class Data_Dictionarycontroller {
	@Resource
	private Data_Dictionaryservice data_ditionservice;
		
	@RequestMapping("/Statuslsit")
	@ResponseBody
	public Object Statuslsit(String tcode) {
		
		List<Data_Dictionary> Statuslsit =data_ditionservice.Statuslsit(tcode);
		
		return Statuslsit ;
	}

}
