package com.sky.blue.business.stat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.stat.dao.IStatAllDao;
import com.sky.blue.business.stat.entity.Calldetail;
import com.sky.blue.business.stat.entity.Incomededail;
import com.sky.blue.business.stat.service.IStatAllServer;


@Repository("statAllServer")
public class StatAllServerImpl implements IStatAllServer{
	
	@Autowired
	private IStatAllDao statAllDao;
	

	@Override
	public List<Calldetail> listALLProductStat(Calldetail o) throws Exception {
		return statAllDao.listALLProductStat(o);
	}

	@Override
	public List<Calldetail> listALLChannelStat(Calldetail o) throws Exception {
		return statAllDao.listALLChannelStat(o);
	}

	@Override
	public List<Incomededail> listAllCompanyStat(Incomededail incomededail) throws Exception {
		return statAllDao.listAllCompanyStat(incomededail);
	
	}
	
	
	@Override
	public List<SearchBean> getAllcompany(SearchBean o) throws Exception {
		return statAllDao.getAllcompany(o);
	}

	@Override
	public List<SearchBean> getAllfeecode(SearchBean o) throws Exception {
		return statAllDao.getAllfeecode(o);
	}
	
	@Override
	public List<SearchBean> getAllproduct(SearchBean o) throws Exception {
		return statAllDao.getAllproduct(o);
	}

	@Override
	public List<SearchBean> getAllcp(SearchBean o) throws Exception {
		return statAllDao.getAllcp(o);
	}

	@Override
	public int updCalldetailFee(Calldetail o) throws Exception {
		return statAllDao.updCalldetailFee(o);
	}

	@Override
	public int updCompanyStatFee(Incomededail o) throws Exception {
		return statAllDao.updCompanyStatFee(o);
	}
	
}
