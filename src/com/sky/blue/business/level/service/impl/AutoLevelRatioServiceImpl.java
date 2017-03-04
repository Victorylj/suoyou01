package com.sky.blue.business.level.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.level.dao.IAutoLevelRatioDao;
import com.sky.blue.business.level.entity.AutoLevelRatio;
import com.sky.blue.business.level.service.IAutoLevelRatioService;
@Service("autoLevelRatioServiceImpl")
public class AutoLevelRatioServiceImpl implements IAutoLevelRatioService {
	@Autowired
	private IAutoLevelRatioDao autoLevelRatioDao;
	
	@Override
	public List<AutoLevelRatio> qryAutoLevelRatioList(
			AutoLevelRatio autoLevelRatio) throws Exception {
		return autoLevelRatioDao.qryAutoLevelRatioList(autoLevelRatio);
	}

	@Override
	public int addAutoLevelRatio(AutoLevelRatio autoLevelRatio)
			throws Exception {
		//如果id不为空执行更新操作
		if(autoLevelRatio.getId()!=null){
			return autoLevelRatioDao.updateAutoLevelRatio(autoLevelRatio);
		}
		return autoLevelRatioDao.addAutoLevelRatio(autoLevelRatio);
	}

	@Override
	public int updateAutoLevelRatio(AutoLevelRatio autoLevelRatio)
			throws Exception {
		return autoLevelRatioDao.updateAutoLevelRatio(autoLevelRatio);
	}

	@Override
	public int deleteAutoLevelRatio(AutoLevelRatio autoLevelRatio)
			throws Exception {
		// TODO Auto-generated method stub
		return autoLevelRatioDao.deleteAutoLevelRatio(autoLevelRatio);
	}

}
