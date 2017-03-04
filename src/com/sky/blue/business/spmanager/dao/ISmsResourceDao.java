package com.sky.blue.business.spmanager.dao;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SmsResource;

public interface ISmsResourceDao {
	public List<SmsResource> qryCpCommandList(SmsResource smsResource) throws Exception;
	public int addSmsResource(SmsResource smsResource) throws Exception;
	public int deleteSmsResource(SmsResource smsResource) throws Exception;
	public int updateSmsResource(SmsResource smsResource) throws Exception;
}
