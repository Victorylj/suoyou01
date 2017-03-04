package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.spmanager.dao.ISpInterfaceParamDao;
import com.sky.blue.business.spmanager.entity.SpInterfaceParam;
import com.sky.blue.business.spmanager.service.ISpInterfaceParamService;
@Service("spInterfaceParamServiceImpl")
public class SpInterfaceParamServiceImpl  implements ISpInterfaceParamService {
	@Autowired
	private ISpInterfaceParamDao spInterfaceParamDao;
	@Override
	public List<SpInterfaceParam> qryCpInterfaceParamList(SpInterfaceParam spInterfaceParam)
			throws Exception {
		// TODO Auto-generated method stub
		return spInterfaceParamDao.qryCpInterfaceParamList(spInterfaceParam);
	}

	@Override
	public int addSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception {
		// TODO Auto-generated method stub
		if(spInterfaceParam.getId()!=null){
			return spInterfaceParamDao.updateSpInterfaceParam(spInterfaceParam);
		}
		return spInterfaceParamDao.addSpInterfaceParam(spInterfaceParam);
	}

	@Override
	public int deleteSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception {
		// TODO Auto-generated method stub
		return spInterfaceParamDao.deleteSpInterfaceParam(spInterfaceParam);
	}

}
