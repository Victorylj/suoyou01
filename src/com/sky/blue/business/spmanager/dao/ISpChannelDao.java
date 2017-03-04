package com.sky.blue.business.spmanager.dao;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SpChannel;

public interface ISpChannelDao {
	public List<SpChannel> qryCpChannelList(SpChannel spChannel) throws Exception;
	public int addSpChannel(SpChannel spChannel) throws Exception;
	public int deleteSpChannel(SpChannel spChannel) throws Exception;
	public int updateSpChannel(SpChannel spChannel) throws Exception;
}
