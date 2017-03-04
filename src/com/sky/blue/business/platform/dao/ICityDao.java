package com.sky.blue.business.platform.dao;

import java.util.List;

import com.sky.blue.business.platform.entity.City;

public interface ICityDao {
	public List<City> getCityList(City city) throws Exception;
}
