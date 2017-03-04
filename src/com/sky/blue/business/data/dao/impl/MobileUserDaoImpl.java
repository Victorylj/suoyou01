package com.sky.blue.business.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.data.dao.IMobileUserDao;
import com.sky.blue.business.data.entity.MobileUser;
import com.sky.blue.business.data.entity.RequstInfo;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("mobileUserDao")
public class MobileUserDaoImpl extends BasicSqlSupport implements IMobileUserDao{

	@Override
	public List<MobileUser> qryMobileUser(MobileUser mb) throws Exception {
		return session.selectList("getMobileUser",mb);
	}

	@Override
	public int addMobileUser(MobileUser mb) throws Exception {
		return session.insert("addMobileUser", mb);
	}

	@Override
	public int updMobileUser(MobileUser mb) throws Exception {
		return 0;
	}

	@Override
	public int delMobileUser(MobileUser mb) throws Exception {
		return session.delete("delMobileUser", mb);
	}

	@Override
	public List<RequstInfo> qryRequstInfoList(RequstInfo mb) throws Exception {
		return session.selectList("getRequstInfoList",mb);
	}
	@Override
	public List<RequstInfo> getImsiMobileList(RequstInfo mb) throws Exception {
		return session.selectList("getImsiMobileList",mb);
	}
	

	@Override
	public int addMobileUserinfo(MobileUser mb) throws Exception {
		return session.insert("addMobileUserinfo", mb);
	}

	

}
