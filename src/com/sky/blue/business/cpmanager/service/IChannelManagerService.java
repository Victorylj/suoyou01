package com.sky.blue.business.cpmanager.service;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.ChannelManager;

public interface IChannelManagerService {
	public List<ChannelManager> qryChannelManagerList(ChannelManager channelManager) throws Exception;
	public int addChannelManager(ChannelManager channelManager) throws Exception;
	public int deleteChannelManager(ChannelManager channelManager) throws Exception;
}