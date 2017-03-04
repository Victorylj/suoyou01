package com.sky.blue.business.cpmanager.service;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.ChannelData;

public interface IChannelDataService {
	public List<ChannelData> qryChannelDataList(ChannelData channelData) throws Exception;
	public int addChannelData(ChannelData channelData) throws Exception;
	public int deleteChannelData(ChannelData channelData) throws Exception;
}
