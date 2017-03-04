package com.sky.blue.business.platform.service;

import java.util.List;

import com.sky.blue.business.platform.entity.City;

public interface ICityService {
	public List<City> getCityList(City city) throws Exception;
}
