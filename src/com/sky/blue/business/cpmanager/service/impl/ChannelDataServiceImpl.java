package com.sky.blue.business.cpmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpmanager.dao.IChannelDataDao;
import com.sky.blue.business.cpmanager.entity.ChannelData;
import com.sky.blue.business.cpmanager.service.IChannelDataService;
@Service("channelDataServiceImpl")
public class ChannelDataServiceImpl  implements IChannelDataService {
	@Autowired
	private IChannelDataDao channelDataDao;
	@Override
	public List<ChannelData> qryChannelDataList(ChannelData channelData)
			throws Exception {
		// TODO Auto-generated method stub
		return channelDataDao.qryChannelDataList(channelData);
	}

	@Override
	public int addChannelData(ChannelData channelData) throws Exception {
		// TODO Auto-generated method stub
		if(channelData.getCh_data_id()!=null){
			return channelDataDao.updateChannelData(channelData);
		}
		return channelDataDao.addChannelData(channelData);
	}

	@Override
	public int deleteChannelData(ChannelData channelData) throws Exception {
		// TODO Auto-generated method stub
		return channelDataDao.deleteChannelData(channelData);
	}

}
