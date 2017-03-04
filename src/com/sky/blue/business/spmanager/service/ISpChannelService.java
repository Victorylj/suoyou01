package com.sky.blue.business.spmanager.service;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SpChannel;

public interface ISpChannelService {
	public List<SpChannel> qryCpChannelList(SpChannel spChannel) throws Exception;
	public int addSpChannel(SpChannel spChannel) throws Exception;
	public int deleteSpChannel(SpChannel spChannel) throws Exception;
}
