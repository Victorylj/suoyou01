package com.sky.blue.business.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.platform.dao.ICityDao;
import com.sky.blue.business.platform.entity.City;
import com.sky.blue.business.platform.service.ICityService;
@Service("cityServiceImpl")
public class CityServiceImpl implements ICityService {
	@Autowired
	private ICityDao cityDao;
	@Override
	public List<City> getCityList(City city) throws Exception {
		// TODO Auto-generated method stub
		return cityDao.getCityList(city);
	}

}
