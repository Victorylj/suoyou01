package com.sky.blue.business.stat.dao;

import java.util.List;

import com.sky.blue.business.stat.entity.RecData;
import com.sky.blue.business.stat.entity.RecDataStat;

public interface IRecDataStatDao {
	public List<RecDataStat> qryRecDataStatList(RecDataStat recDataStat) throws Exception;
	public List<RecData> qryRecDataList(RecData recData) throws Exception;
	public List<RecDataStat> getRecDataStatList(RecDataStat recDataStat) throws Exception;
	public List<RecDataStat> getRecDataStatList_his(RecDataStat recDataStat) throws Exception;
	public int updRecDataStatHis(RecDataStat recDataStat) throws Exception;
	public int saveRecDataStat(RecDataStat recDataStat) throws Exception;
	public int delRecDataStat(RecDataStat recDataStat) throws Exception;
	public List<RecDataStat> getRecDelayMinute(RecDataStat recDataStat) throws Exception;
}
