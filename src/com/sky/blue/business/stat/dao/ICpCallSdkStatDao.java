package com.sky.blue.business.stat.dao;

import java.util.List;

import com.sky.blue.business.stat.entity.CallStat;

public interface ICpCallSdkStatDao {
	public List<CallStat> qryCallStatList(CallStat callStat) throws Exception;

}
