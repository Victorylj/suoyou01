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

import com.sky.blue.business.stat.dao.ICaitsatDao;
import com.sky.blue.business.stat.dao.ICallStatDao;
import com.sky.blue.business.stat.entity.Caitsat;
import com.sky.blue.business.stat.entity.CallStat;
import com.sky.blue.business.stat.service.ICaitsatService;
import com.sky.blue.business.stat.service.ICallStatService;
@Service("caitsatServiceImpl")
public class CaitsatServiceImpl implements ICaitsatService {
	@Autowired
	private ICaitsatDao caitsatDao;
/*	@Override
	public List<CallStat> qryCallStatList(CallStat callStat)
			throws Exception {
		// TODO Auto-generated method stub
		return callStatDao.qryCallStatList(callStat);
	}*/
	@Override
	public List<Caitsat> qryCaitsatList(Caitsat obj) throws Exception {
		return caitsatDao.qryCaitsatList(obj);
	}
	
}
