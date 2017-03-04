package com.sky.blue.business.stat.dao.impl;

import java.util.List;

import com.sky.blue.business.stat.entity.CallStat;

public interface ICallStatDao {
	public List<CallStat> qryCallStatList(CallStat callStat) throws Exception;

}
