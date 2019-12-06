package cn.sq.appinfo.service;

import java.util.List;

import cn.sq.appinfo.entity.Data_Dictionary;

public interface Data_Dictionaryservice {
	//根据typeCode查询对应的数据
	public List<Data_Dictionary> Statuslsit(String typeCode);

}
