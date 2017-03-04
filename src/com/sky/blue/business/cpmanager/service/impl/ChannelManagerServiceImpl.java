package com.sky.blue.business.cpmanager.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpmanager.dao.IChannelManagerDao;
import com.sky.blue.business.cpmanager.entity.ChannelManager;
import com.sky.blue.business.cpmanager.service.IChannelManagerService;
@Service("channelManagerServiceImpl")
public class ChannelManagerServiceImpl  implements IChannelManagerService {
	@Autowired
	private IChannelManagerDao channelManagerDao;
	@Override
	public List<ChannelManager> qryChannelManagerList(ChannelManager channelManager)
			throws Exception {
		// TODO Auto-generated method stub
		return channelManagerDao.qryChannelManagerList(channelManager);
	}

	@Override
	public int addChannelManager(ChannelManager channelManager) throws Exception {
		// TODO Auto-generated method stub
		if(channelManager.getM_id()!=null){
			return channelManagerDao.updateChannelManager(channelManager);
		}
		return channelManagerDao.addChannelManager(channelManager);
	}

	@Override
	public int deleteChannelManager(ChannelManager channelManager) throws Exception {
		// TODO Auto-generated method stub
		return channelManagerDao.deleteChannelManager(channelManager);
	}

}
