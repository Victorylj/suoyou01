package com.sky.blue.business.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.blue.business.data.dao.IMobileUserGreenDao;
import com.sky.blue.business.data.entity.MobileUserGreen;
import com.sky.blue.business.data.service.IMobileUserGreenService;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("mobileUserGreenService")
public class MobileUserGreenServiceImpl extends BasicSqlSupport implements IMobileUserGreenService{
	@Autowired
	private IMobileUserGreenDao iMobileUserGreenDao;
	@Override
	public List<MobileUserGreen> qryMobileUserGreen(MobileUserGreen mbg)
			throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserGreenDao.qryMobileUserGreen(mbg);
	}

	@Override
	public int addMobileUserGreen(MobileUserGreen mbg) throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserGreenDao.addMobileUserGreen(mbg);
	}

	@Override
	public int addMobileUserGreeninfo(MobileUserGreen mbg) throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserGreenDao.addMobileUserGreeninfo(mbg);
	}

	@Override
	public int updMobileUserGreen(MobileUserGreen mbg) throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserGreenDao.updMobileUserGreen(mbg);
	}

	@Override
	public int delMobileUserGreen(MobileUserGreen mbg) throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserGreenDao.delMobileUserGreen(mbg);
	}

	@Override
	public MobileUserGreen upMobileUserGreen(MobileUserGreen mbg)
			throws Exception {
		// TODO Auto-generated method stub
		return iMobileUserGreenDao.upMobileUserGreen(mbg);
	}

}
