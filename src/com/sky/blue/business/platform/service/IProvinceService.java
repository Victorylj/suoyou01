package com.sky.blue.business.platform.service;

import java.util.List;

import com.sky.blue.business.platform.entity.Province;

public interface IProvinceService {
	public List<Province> getProvinceList(Province province) throws Exception;
}
