package com.sky.blue.business.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.data.dao.IMobileUserDao;
import com.sky.blue.business.data.entity.MobileUser;
import com.sky.blue.business.data.entity.RequstInfo;
import com.sky.blue.business.data.service.IMobileUserService;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("mobileUserService")
public class MobileUserServiceImpl extends BasicSqlSupport implements IMobileUserService{

	@Autowired
	private IMobileUserDao mobileUserDao;
	
	@Override
	public List<MobileUser> qryMobileUser(MobileUser mb) throws Exception {
		return mobileUserDao.qryMobileUser(mb);
	}

	
	
	@Override
	public int addMobileUser(MobileUser mb) throws Exception {
		return mobileUserDao.addMobileUser(mb);
	}

	@Override
	public int updMobileUser(MobileUser mb) throws Exception {
		return mobileUserDao.updMobileUser(mb);
	}

	@Override
	public int delMobileUser(MobileUser mb) throws Exception {
		return mobileUserDao.delMobileUser(mb);
	}



	@Override
	public List<RequstInfo> qryRequstInfoList(RequstInfo mb) throws Exception {
		return mobileUserDao.qryRequstInfoList(mb);
	}
	@Override
	public List<RequstInfo> getImsiMobileList(RequstInfo mb) throws Exception {
		return mobileUserDao.getImsiMobileList(mb);
	}



	@Override
	public int addMobileUserinfo(MobileUser mb) throws Exception {
		return mobileUserDao.addMobileUserinfo(mb);
	}

	

}
