package com.sky.blue.business.stat.service;

import java.util.List;

import com.sky.blue.business.stat.entity.RecData;
import com.sky.blue.business.stat.entity.RecDataStat;

public interface IRecDataStatService {
	public List<RecDataStat> qryRecDataStatList(RecDataStat recDataStat) throws Exception;
	public List<RecData> qryRecDataList(RecData recData) throws Exception;
	public int updRecDataStatHis(RecDataStat recDataStat) throws Exception;
	public List<RecDataStat> getRecDataStatList(RecDataStat recDataStat) throws Exception;
	public List<RecDataStat> getRecDelayMinute(RecDataStat recDataStat) throws Exception;

}
