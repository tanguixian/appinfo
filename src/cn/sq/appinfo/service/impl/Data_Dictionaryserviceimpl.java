package cn.sq.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sq.appinfo.dao.Data_Dictionarydao;
import cn.sq.appinfo.entity.Data_Dictionary;
import cn.sq.appinfo.service.Data_Dictionaryservice;
@Service
public class Data_Dictionaryserviceimpl implements Data_Dictionaryservice {
	@Resource
	private Data_Dictionarydao data_dtctdao;
	
	@Override
	public List<Data_Dictionary> Statuslsit(String typeCode) {
		return data_dtctdao.Statuslsit(typeCode);
	}

}
