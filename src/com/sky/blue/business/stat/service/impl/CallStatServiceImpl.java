package com.sky.blue.business.stat.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.stat.dao.ICallStatDao;
import com.sky.blue.business.stat.entity.CallStat;
import com.sky.blue.business.stat.service.ICallStatService;

@Service("callStatServiceImpl")
public class CallStatServiceImpl implements ICallStatService {
	@Autowired
	private ICallStatDao callStatDao;

	@Override
	public List<CallStat> qryCallStatList(CallStat callStat) throws Exception {

		return callStatDao.qryCallStatList(callStat);
	}

	@Override
	public List<CallStat> qryAllCallStatList(CallStat callStat) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String dater = sf.format(new Date());
		if (!dater.equals(callStat.getDater())) {
			return callStatDao.qryAllCallStatList_his(callStat);
		}
		/*
		 * List<CallStat> reqList= callStatDao.qryReqCallStatList(callStat);
		 * List<CallStat> initList=callStatDao.qryInitCallStatList(callStat);
		 * if(reqList==null){ reqList=new ArrayList<CallStat>(); }
		 * if(initList==null){ initList=new ArrayList<CallStat>(); }
		 * HashMap<String,CallStat> temp = new HashMap<String,CallStat>();
		 * 
		 * for(CallStat req:reqList){ String reqk =
		 * req.getDater()+req.getPackager()+req.getCp_id(); req.setInitnum(0);
		 * temp.put(reqk, req);
		 * 
		 * }
		 * 
		 * for(CallStat init:initList){ String initk =
		 * init.getDater()+init.getPackager()+init.getCp_id(); CallStat stat =
		 * temp.get(initk); if(stat!=null){ stat.setInitnum(init.getInitnum());
		 * temp.put(initk, stat); }else{ init.setSucc_calls(0);
		 * init.setSucc_users(0); init.setAll_calls(0); init.setAll_users(0);
		 * temp.put(initk, init); } } List<CallStat> list=new
		 * ArrayList<CallStat>(); Set<String> keys = temp.keySet();
		 * Iterator<String> it = keys.iterator(); while(it.hasNext()){ String
		 * key =it.next(); list.add(temp.get(key)); }
		 */

		return callStatDao.qryAllCallStatList(callStat);
	}

	@Override
	public List<CallStat> qryRecStatList(CallStat callStat) throws Exception {

		return callStatDao.qryRecStatList(callStat);
	}

	@Override
	public List<CallStat> qryInitStatList(CallStat callStat) throws Exception {

		return callStatDao.qryInitStatList(callStat);
	}

	@Override
	public List<CallStat> qryProvinceCallStatList(CallStat callStat) throws Exception {

		return callStatDao.qryProvinceCallStatList(callStat);
	}

	@Override
	public List<CallStat> getSdkRLByd(CallStat callStat) throws Exception {
		return callStatDao.getSdkRLByd(callStat);
	}

	@Override
	public List<CallStat> getSdkILByd(CallStat callStat) throws Exception {
		return callStatDao.getSdkILByd(callStat);
	}

	@Override
	public List<CallStat> getCpchsta(CallStat callStat) throws Exception {
		return callStatDao.getCpchsta(callStat);
	}

	@Override
	public List<CallStat> getAllCompany(CallStat callStat) throws Exception {
		return callStatDao.getAllCompany(callStat);
	}

	@Override
	public List<CallStat> getAllProduct(CallStat callStat) throws Exception {
		return callStatDao.getAllProduct(callStat);
	}

	@Override
	public List<CallStat> qryInitNoFeeStatList(CallStat callStat) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String dater = sf.format(new Date());
		if (!dater.equals(callStat.getDater())) {
			return new ArrayList<CallStat>();
		}

		return callStatDao.qryInitNoFeeStatList(callStat);
	}

}
