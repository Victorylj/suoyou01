package com.sky.blue.business.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.blue.business.data.dao.IMobileUserWihteDao;
import com.sky.blue.business.data.entity.MobileUserWihte;
import com.sky.blue.business.data.service.IMobileUserWihteService;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("mobileUserWihteService")
public class MobileUserWihteServiceImpl extends BasicSqlSupport implements IMobileUserWihteService{
	@Autowired
	private IMobileUserWihteDao iMobileUserWihteDao;
	@Override
	public List<MobileUserWihte> qryMobileUserWihte(MobileUserWihte mgw)
			throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserWihteDao.qryMobileUserWihte(mgw);
	}

	@Override
	public int addMobileUserWihte(MobileUserWihte mgw) throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserWihteDao.addMobileUserWihte(mgw);
	}

	@Override
	public int addMobileUserWihteinfo(MobileUserWihte mgw) throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserWihteDao.addMobileUserWihteinfo(mgw);
	}

	@Override
	public int updMobileUserWihte(MobileUserWihte mgw) throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserWihteDao.updMobileUserWihte(mgw);
	}

	@Override
	public int delMobileUserWihte(MobileUserWihte mgw) throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserWihteDao.delMobileUserWihte(mgw);
	}

	@Override
	public MobileUserWihte upMobileUserWihte(MobileUserWihte mbw)
			throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserWihteDao.upMobileUserWihte(mbw);
	}
 
}
