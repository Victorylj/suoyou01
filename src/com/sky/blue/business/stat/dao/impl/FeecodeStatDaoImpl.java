package com.sky.blue.business.stat.dao.impl;

import java.util.List;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Repository;

import com.sky.blue.business.stat.dao.IFeecodeStatDao;
import com.sky.blue.business.stat.entity.FeecodeStat;
import com.sky.blue.business.stat.entity.SmsFilterStat;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("feecodeStatDao")
public class FeecodeStatDaoImpl extends BasicSqlSupport implements IFeecodeStatDao {

	@Override
	public List<FeecodeStat> qryFeecodeStatList(FeecodeStat feecodeStat)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getFeecodeStatList", feecodeStat);
	}

	@Override
	public List<SmsFilterStat> qrySmsFilterStatList(SmsFilterStat smsFilterStat)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getSmsFilterStat", smsFilterStat);
	}

	@Override
	public List<SmsFilterStat> qrySmsFilterCpStatList(
			SmsFilterStat smsFilterStat) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getSmsFilterCpStat", smsFilterStat);
	}

	@Override
	public List<SmsFilterStat> qrySmsReportStatList(SmsFilterStat smsFilterStat)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getSmsReportStat", smsFilterStat);
	}

	@Override
	public List<SmsFilterStat> qrySmsFilterCpStatListhis(
			SmsFilterStat smsFilterStat) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getSmsFilterCpStathis", smsFilterStat);
	}

	@Override
	public List<SmsFilterStat> qrySmsReportStatListhis(
			SmsFilterStat smsFilterStat) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getSmsReportStathis", smsFilterStat);
	}

	@Override
	public List<FeecodeStat> getCommandInfo(FeecodeStat feecodeStat)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getCommandInfo", feecodeStat);
	}

	@Override
	public List<FeecodeStat> getRateInfo(FeecodeStat feecodeStat)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getRateInfo", feecodeStat);
	}


}
