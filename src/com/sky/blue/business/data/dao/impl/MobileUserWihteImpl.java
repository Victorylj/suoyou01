package com.sky.blue.business.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.data.dao.IMobileUserGreenDao;
import com.sky.blue.business.data.dao.IMobileUserWihteDao;
import com.sky.blue.business.data.entity.MobileUserGreen;
import com.sky.blue.business.data.entity.MobileUserWihte;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("mobileUserWihte")
public class MobileUserWihteImpl extends BasicSqlSupport implements IMobileUserWihteDao{

	@Override
	public List<MobileUserWihte> qryMobileUserWihte(MobileUserWihte mbw)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("MobileUserWihte",mbw);
	}

	@Override
	public int addMobileUserWihte(MobileUserWihte mbw) throws Exception {
		// TODO Auto-generated method stub
		return session.insert("addMobileUserWihte", mbw);
	}

	@Override
	public int addMobileUserWihteinfo(MobileUserWihte mbw) throws Exception {
		// TODO Auto-generated method stub
		return session.insert("", mbw);
	}

	@Override
	public int updMobileUserWihte(MobileUserWihte mbw) throws Exception {
		// TODO Auto-generated method stub
		return session.update("updMobileUserWihte", mbw);
	}

	@Override
	public int delMobileUserWihte(MobileUserWihte mbw) throws Exception {
		// TODO Auto-generated method stub
		return session.delete("delMobileUserWihte", mbw);
	}

	@Override
	public MobileUserWihte upMobileUserWihte(MobileUserWihte mbw)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("MobileUserWihte",mbw);
	}

	

}
