package com.sky.blue.business.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.platform.dao.IProvinceDao;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.business.platform.service.IProvinceService;
@Service("provinceServiceImpl")
public class ProvinceServiceImpl implements IProvinceService {
	@Autowired
	private IProvinceDao provinceDao;
	@Override
	public List<Province> getProvinceList(Province province) throws Exception {
		// TODO Auto-generated method stub
		return provinceDao.getProvinceList(province);
	}

}
