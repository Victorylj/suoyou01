package com.sky.blue.business.cpmanager.service;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.Channel;
import com.sky.blue.business.cpmanager.entity.ChannelProduct;
import com.sky.blue.business.cpmanager.entity.SearchBean;

public interface IChannelService {
	public List<SearchBean> searchChannelList(Channel channel) throws Exception;
	public List<Channel> qryChannelList(Channel channel) throws Exception;
	public int addChannel(Channel channel) throws Exception;
	public int deleteChannel(Channel channel) throws Exception;
	public List<ChannelProduct> qryChannelProductList(ChannelProduct channelProduct) throws Exception;
	public int addChannelProduct(ChannelProduct channelProduct) throws Exception;
	public int deleteChannelProduct(ChannelProduct channelProduct) throws Exception;
	public int updateChannelTag(Channel channel) throws Exception;
	public int updateChStatus(Channel channel) throws Exception;
}
