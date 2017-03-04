package com.sky.blue.business.platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.platform.dao.ICityDao;
import com.sky.blue.business.platform.entity.City;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cityDao")
public class CityDaoImpl extends BasicSqlSupport implements ICityDao {

	@Override
	public List<City> getCityList(City city) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCity", city);
	}
	
}
