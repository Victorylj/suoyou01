package com.sky.blue.business.platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.platform.dao.IProvinceDao;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("provinceDao")
public class ProvinceDaoImpl extends BasicSqlSupport implements IProvinceDao {

	@Override
	public List<Province> getProvinceList(Province province) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listProvince", province);
	}
	
}
