package com.sky.blue.business.stat.dao;

import java.util.List;

import com.sky.blue.business.stat.entity.CallStat;

public interface ICallStatDao {
	public List<CallStat> qryCallStatList(CallStat callStat) throws Exception;
	public List<CallStat> qryAllCallStatList_his(CallStat callStat) throws Exception;
	
	
	public List<CallStat> qryProvinceCallStatList(CallStat callStat) throws Exception;
	public List<CallStat> qryAllCallStatList(CallStat callStat) throws Exception;
	public List<CallStat> qryRecStatList(CallStat callStat) throws Exception;
	public List<CallStat> qryInitStatList(CallStat callStat) throws Exception;
	
	public List<CallStat> qryReqCallStatList(CallStat callStat) throws Exception;
	public List<CallStat> qryInitCallStatList(CallStat callStat) throws Exception;
	
	public List<CallStat> qryInitNoFeeStatList(CallStat callStat) throws Exception;
	public List<CallStat> qryInitNoFeeStatList_his(CallStat callStat) throws Exception;
	//new 访问量
	public List<CallStat> getSdkRLByd(CallStat callStat) throws Exception;
	public List<CallStat> getSdkILByd(CallStat callStat) throws Exception;
	public List<CallStat> getCpchsta(CallStat callStat) throws Exception;
	public List<CallStat> getAllCompany(CallStat callStat) throws Exception;
	public List<CallStat> getAllProduct(CallStat callStat) throws Exception;
}
