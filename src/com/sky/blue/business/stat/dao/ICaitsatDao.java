package com.sky.blue.business.stat.dao;

import java.util.List;

import com.sky.blue.business.stat.entity.Caitsat;
import com.sky.blue.business.stat.entity.CallStat;

public interface ICaitsatDao {
	public List<Caitsat> qryCaitsatList(Caitsat obj) throws Exception;
	
}
