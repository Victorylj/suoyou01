package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.spmanager.dao.ISmsResourceDao;
import com.sky.blue.business.spmanager.entity.SmsResource;
import com.sky.blue.business.spmanager.service.ISmsResourceService;
@Service("smsResourceServiceImpl")
public class SmsResourceServiceImpl  implements ISmsResourceService {
	@Autowired
	private ISmsResourceDao smsResourceDao;
	@Override
	public List<SmsResource> qryCpCommandList(SmsResource smsResource)
			throws Exception {
		// TODO Auto-generated method stub
		return smsResourceDao.qryCpCommandList(smsResource);
	}

	@Override
	public int addSmsResource(SmsResource smsResource) throws Exception {
		// TODO Auto-generated method stub
		if(smsResource.getId()!=null){
			return smsResourceDao.updateSmsResource(smsResource);
		}
		return smsResourceDao.addSmsResource(smsResource);
	}

	@Override
	public int deleteSmsResource(SmsResource smsResource) throws Exception {
		// TODO Auto-generated method stub
		return smsResourceDao.deleteSmsResource(smsResource);
	}

}
