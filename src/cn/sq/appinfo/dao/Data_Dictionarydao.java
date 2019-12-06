package cn.sq.appinfo.dao;

import java.util.List;

import cn.sq.appinfo.entity.Data_Dictionary;

public interface Data_Dictionarydao {
	//根据参数查询
	public List<Data_Dictionary> Statuslsit(String typeCode);

}
