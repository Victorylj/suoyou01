package com.sky.blue.business.stat.dao;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.stat.entity.Calldetail;
import com.sky.blue.business.stat.entity.Incomededail;

public interface IStatAllDao{

	List<Calldetail> listALLChannelStat(Calldetail o) throws Exception;

	List<Calldetail> listALLProductStat(Calldetail o) throws Exception;
	
	int updCalldetailFee(Calldetail o) throws Exception;

	List<Incomededail> listAllCompanyStat(Incomededail o) throws Exception;
	
	int updCompanyStatFee(Incomededail o) throws Exception;
	
	List<SearchBean> getAllcompany(SearchBean o) throws Exception;
	
	List<SearchBean> getAllfeecode(SearchBean o) throws Exception;

	List<SearchBean> getAllproduct(SearchBean o) throws Exception;

	List<SearchBean> getAllcp(SearchBean o) throws Exception;	
	
}
