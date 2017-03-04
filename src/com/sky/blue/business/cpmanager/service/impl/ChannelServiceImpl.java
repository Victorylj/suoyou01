package com.sky.blue.business.cpmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpmanager.dao.IChannelDao;
import com.sky.blue.business.cpmanager.entity.Channel;
import com.sky.blue.business.cpmanager.entity.ChannelProduct;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.cpmanager.service.IChannelService;
@Service("channelServiceImpl")
public class ChannelServiceImpl  implements IChannelService {
	@Autowired
	private IChannelDao channelDao;
	@Override
	public List<Channel> qryChannelList(Channel channel)
			throws Exception {
		// TODO Auto-generated method stub
		return channelDao.qryChannelList(channel);
	}
	
	@Override
	public List<SearchBean>  searchChannelList(Channel channel)
			throws Exception {
		// TODO Auto-generated method stub
		return channelDao.searchChannelList(channel);
	}
	

	@Override
	public int addChannel(Channel channel) throws Exception {
		// TODO Auto-generated method stub
		if(channel.getCh_id()!=null){
			return channelDao.updateChannel(channel);
		}
		return channelDao.addChannel(channel);
	}

	@Override
	public int deleteChannel(Channel channel) throws Exception {
		// TODO Auto-generated method stub
		return channelDao.deleteChannel(channel);
	}

	@Override
	public List<ChannelProduct> qryChannelProductList(
			ChannelProduct channelProduct) throws Exception {
		// TODO Auto-generated method stub
		return channelDao.qryChannelProductList(channelProduct);
	}

	@Override
	public int addChannelProduct(ChannelProduct channelProduct)
			throws Exception {
		// TODO Auto-generated method stub
		return channelDao.addChannelProduct(channelProduct);
	}

	@Override
	public int deleteChannelProduct(ChannelProduct channelProduct)
			throws Exception {
		// TODO Auto-generated method stub
		return channelDao.deleteChannelProduct(channelProduct);
	}

	@Override
	public int updateChannelTag(Channel channel) throws Exception {
		// TODO Auto-generated method stub
		return channelDao.updateChannelTag(channel);
	}
	
	@Override
	public int updateChStatus(Channel channel) throws Exception {
		return channelDao.updateChStatus(channel);
	}

}
