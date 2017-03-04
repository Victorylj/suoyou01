package com.sky.blue.business.cpmanager.dao;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.ChannelManager;

public interface IChannelManagerDao {
	public List<ChannelManager> qryChannelManagerList(ChannelManager channelManager) throws Exception;
	public int addChannelManager(ChannelManager channelManager) throws Exception;
	public int deleteChannelManager(ChannelManager channelManager) throws Exception;
	public int updateChannelManager(ChannelManager channelManager) throws Exception;
}