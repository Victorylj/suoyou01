package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.spmanager.dao.ISpChannelDao;
import com.sky.blue.business.spmanager.entity.SpChannel;
import com.sky.blue.business.spmanager.service.ISpChannelService;
@Service("spChannelServiceImpl")
public class SpChannelServiceImpl  implements ISpChannelService {
	@Autowired
	private ISpChannelDao spChannelDao;
	@Override
	public List<SpChannel> qryCpChannelList(SpChannel spChannel)
			throws Exception {
		// TODO Auto-generated method stub
		return spChannelDao.qryCpChannelList(spChannel);
	}

	@Override
	public int addSpChannel(SpChannel spChannel) throws Exception {
		// TODO Auto-generated method stub
		if(spChannel.getSp_channel_id()!=null){
			return spChannelDao.updateSpChannel(spChannel);
		}
		return spChannelDao.addSpChannel(spChannel);
	}

	@Override
	public int deleteSpChannel(SpChannel spChannel) throws Exception {
		// TODO Auto-generated method stub
		return spChannelDao.deleteSpChannel(spChannel);
	}

}
