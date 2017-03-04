package com.sky.blue.business.platform.dao;

import java.util.List;

import com.sky.blue.business.platform.entity.Province;

public interface IProvinceDao {
	public List<Province> getProvinceList(Province province) throws Exception;
}
