package com.sky.blue.business.stat.dao;

import java.util.List;

import com.sky.blue.business.stat.entity.FeecodeStat;
import com.sky.blue.business.stat.entity.SmsFilterStat;

public interface IFeecodeStatDao {
	public List<FeecodeStat> qryFeecodeStatList(FeecodeStat feecodeStat) throws Exception;
	public List<SmsFilterStat> qrySmsFilterStatList(SmsFilterStat smsFilterStat) throws Exception;
	public List<SmsFilterStat> qrySmsFilterCpStatList(SmsFilterStat smsFilterStat) throws Exception;
	public List<SmsFilterStat> qrySmsReportStatList(SmsFilterStat smsFilterStat) throws Exception;
	public List<SmsFilterStat> qrySmsFilterCpStatListhis(SmsFilterStat smsFilterStat) throws Exception;
	public List<SmsFilterStat> qrySmsReportStatListhis(SmsFilterStat smsFilterStat) throws Exception;
	public List<FeecodeStat> getCommandInfo(FeecodeStat feecodeStat) throws Exception;
	public List<FeecodeStat> getRateInfo(FeecodeStat feecodeStat) throws Exception;
}
