package com.sky.blue.business.spmanager.service;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;

public interface ISpCompanyService {
	public List<SpCompany> qryCpCompanyList(SpCompany spCompany) throws Exception;
	public List<SearchBean> seachCpCompanyList(SpCompany sc) throws Exception;
	public List<SearchBean> seachCompanyList(CpCompany sc) throws Exception;
	public List<SearchBean> seachSpFeecodeList(SpFeecode spFeecode) throws Exception;
	public List<SearchBean> seachCpProductList(CpProduct CpProduct) throws Exception;
	public List<SearchBean> searchSpFeecodeTow(SpFeecode spFeecode) throws Exception;
	public int addSpCompany(SpCompany spCompany) throws Exception;
	public int deleteSpCompany(SpCompany spCompany) throws Exception;
}
