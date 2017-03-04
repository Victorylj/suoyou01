package com.sky.blue.business.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.data.dao.IMobileUserGreenDao;
import com.sky.blue.business.data.entity.MobileUserGreen;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("mobileUserGreen")
public class MobileUserGreenImpl extends BasicSqlSupport implements IMobileUserGreenDao{

	@Override
	public List<MobileUserGreen> qryMobileUserGreen(MobileUserGreen mbg)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("MobileUserGreen",mbg);
	}

	@Override
	public int addMobileUserGreen(MobileUserGreen mbg) throws Exception {
		// TODO Auto-generated method stubaddMobileUserGreen
		return session.insert("addMobileUserGreen",mbg);
	}

	@Override
	public int addMobileUserGreeninfo(MobileUserGreen mbg) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updMobileUserGreen(MobileUserGreen mbg) throws Exception {
		// TODO Auto-generated method stub updMobileUserGreen
		return session.update("updMobileUserGreen", mbg);
	}

	@Override
	public int delMobileUserGreen(MobileUserGreen mbg) throws Exception {
		// TODO Auto-generated method stub
		return session.delete("delMobileUserGreen", mbg);
	}

	@Override
	public MobileUserGreen upMobileUserGreen(MobileUserGreen mbg)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("MobileUserGreen",mbg);
	}

}
