package com.sky.blue.business.stat.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.stat.dao.IFeecodeStatDao;
import com.sky.blue.business.stat.entity.FeecodeStat;
import com.sky.blue.business.stat.entity.SmsFilterStat;
import com.sky.blue.business.stat.service.IFeecodeStatService;
@Service("feecodeStatServiceImpl")
public class FeecodeStatServiceImpl implements IFeecodeStatService {
	@Autowired
	private IFeecodeStatDao feecodeStatDao;
	@Override
	public List<FeecodeStat> qryFeecodeStatList(FeecodeStat feecodeStat)
			throws Exception {
		// TODO Auto-generated method stub
		return feecodeStatDao.qryFeecodeStatList(feecodeStat);
	}
	@Override
	public List<SmsFilterStat> qrySmsFilterStatList(SmsFilterStat smsFilterStat)
			throws Exception {
		// TODO Auto-generated method stub
		return feecodeStatDao.qrySmsFilterStatList(smsFilterStat);
	}
	@Override
	public List<SmsFilterStat> qrySmsFilterCpStatList(SmsFilterStat smsFilterStat) throws Exception {
		 	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String dater=sf.format(new Date());
	        if(!dater.equals(smsFilterStat.getStart_time())){
	        	 return feecodeStatDao.qrySmsFilterCpStatListhis(smsFilterStat);
	        }
	        Date date = sf.parse(dater);
	        date.setDate(date.getDate()+1);
	        smsFilterStat.setEnd_time(sf.format(date));
	        List<SmsFilterStat> li = feecodeStatDao.qrySmsFilterCpStatList(smsFilterStat);
	        smsFilterStat.setEnd_time(smsFilterStat.getStart_time());
	        return li;
	}
	@Override
	public List<SmsFilterStat> qrySmsReportStatList(SmsFilterStat smsFilterStat) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dater=sf.format(new Date());
        if(!dater.equals(smsFilterStat.getStart_time())){
        	return feecodeStatDao.qrySmsReportStatListhis(smsFilterStat);
        }
        Date date = sf.parse(dater);
        date.setDate(date.getDate()+1);
        smsFilterStat.setEnd_time(sf.format(date));
        List<SmsFilterStat> li = feecodeStatDao.qrySmsReportStatList(smsFilterStat);
        smsFilterStat.setEnd_time(smsFilterStat.getStart_time());
        return li;
	}
	@Override
	public List<FeecodeStat> getCommandInfo(FeecodeStat feecodeStat)
			throws Exception {
		// TODO Auto-generated method stub
		return feecodeStatDao.getCommandInfo(feecodeStat);
	}
	@Override
	public List<FeecodeStat> getRateInfo(FeecodeStat feecodeStat)
			throws Exception {
		// TODO Auto-generated method stub
		return feecodeStatDao.getRateInfo(feecodeStat);
	}

}
