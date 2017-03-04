package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.spmanager.dao.ISpCompanyDao;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
@Service("spCompanyServiceImpl")
public class SpCompanyServiceImpl  implements ISpCompanyService {
	@Autowired
	private ISpCompanyDao spCompanyDao;
	@Override
	public List<SpCompany> qryCpCompanyList(SpCompany spCompany)
			throws Exception {
		// TODO Auto-generated method stub
		return spCompanyDao.qryCpCompanyList(spCompany);
	}
	

	@Override
	public int addSpCompany(SpCompany spCompany) throws Exception {
		// TODO Auto-generated method stub
		if(spCompany.getSp_id()!=null){
			return spCompanyDao.updateSpCompany(spCompany);
		}
		return spCompanyDao.addSpCompany(spCompany);
	}

	@Override
	public int deleteSpCompany(SpCompany spCompany) throws Exception {
		// TODO Auto-generated method stub
		return spCompanyDao.deleteSpCompany(spCompany);
	}


	@Override
	public List<SearchBean> seachCpCompanyList(SpCompany sc) throws Exception {
		return spCompanyDao.seachCpCompanyList(sc);
	}
	@Override
	public List<SearchBean> seachCompanyList(CpCompany sc) throws Exception {
		return spCompanyDao.seachCompanyList(sc);
	}


	@Override
	public List<SearchBean> seachSpFeecodeList(SpFeecode spFeecode)
			throws Exception {
		return spCompanyDao.seachSpFeecodeList(spFeecode);
	}
	@Override
	public List<SearchBean> seachCpProductList(CpProduct spFeecode)
			throws Exception {
		return spCompanyDao.seachCpProductList(spFeecode);
	}


	@Override
	public List<SearchBean> searchSpFeecodeTow(SpFeecode spFeecode)
			throws Exception {
		return spCompanyDao.searchSpFeecodeTow(spFeecode);
	}

}
