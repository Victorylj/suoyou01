package com.sky.blue.business.stat.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.stat.dao.ICallStatDao;
import com.sky.blue.business.stat.entity.CallStat;
import com.sky.blue.comm.BasicSqlSupport;

@Repository("callStatDao")
public class CallStatDaoImpl extends BasicSqlSupport implements ICallStatDao {

	@Override
	public List<CallStat> qryCallStatList(CallStat callStat) throws Exception {

		return session.selectList("mybatis.mapper.Bussiness.getCallStatList", callStat);
	}

	@Override
	public List<CallStat> qryAllCallStatList(CallStat callStat) throws Exception {

		return session.selectList("mybatis.mapper.Bussiness.getAllCallStatList", callStat);

	}

	@Override
	public List<CallStat> qryRecStatList(CallStat callStat) throws Exception {

		return session.selectList("mybatis.mapper.Bussiness.getRecStatList", callStat);

	}

	@Override
	public List<CallStat> qryInitStatList(CallStat callStat) throws Exception {

		return session.selectList("mybatis.mapper.Bussiness.getInitStatList", callStat);
	}

	@Override
	public List<CallStat> qryProvinceCallStatList(CallStat callStat) throws Exception {

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String dater = sf.format(new Date());
		if (!dater.equals(callStat.getDater())) {
			return session.selectList("mybatis.mapper.Bussiness.getProvinceCallStatListHis", callStat);
		} else {

		}
		return session.selectList("mybatis.mapper.Bussiness.getProvinceCallStatListHis", callStat);
	}

	@Override
	public List<CallStat> qryReqCallStatList(CallStat callStat) throws Exception {

		return session.selectList("mybatis.mapper.Bussiness.getReqCallStatList", callStat);

	}

	@Override
	public List<CallStat> qryInitCallStatList(CallStat callStat) throws Exception {

		return session.selectList("mybatis.mapper.Bussiness.getInitCallStatList", callStat);

	}

	@Override
	public List<CallStat> qryAllCallStatList_his(CallStat callStat) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getAllCallStatListHis", callStat);
	}

	@Override
	public List<CallStat> getSdkRLByd(CallStat callStat) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getSdkRLByd", callStat);
	}

	@Override
	public List<CallStat> getSdkILByd(CallStat callStat) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getSdkILByd", callStat);
	}

	@Override
	public List<CallStat> getCpchsta(CallStat callStat) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getCpchsta", callStat);
	}

	@Override
	public List<CallStat> getAllCompany(CallStat callStat) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getAllCompany", callStat);
	}

	@Override
	public List<CallStat> getAllProduct(CallStat callStat) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getAllProduct", callStat);
	}

	@Override
	public List<CallStat> qryInitNoFeeStatList(CallStat callStat) throws Exception {

		return session.selectList("mybatis.mapper.Bussiness.getInitNoFeeStatList", callStat);

	}

	@Override
	public List<CallStat> qryInitNoFeeStatList_his(CallStat callStat) throws Exception {

		return session.selectList("mybatis.mapper.Bussiness.getInitNoFeeStatListHis", callStat);

	}

}
