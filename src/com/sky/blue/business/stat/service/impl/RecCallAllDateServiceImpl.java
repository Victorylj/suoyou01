package com.sky.blue.business.stat.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.blue.business.stat.dao.IRecCallAllDateDao;
import com.sky.blue.business.stat.entity.RecCallAllDate;
import com.sky.blue.business.stat.service.IRecCallAllDateService;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("recCallAllDateServiceImpl")
public class RecCallAllDateServiceImpl extends BasicSqlSupport  implements IRecCallAllDateService {

	@Autowired
	private IRecCallAllDateDao recCallAllDateDao;

	@Override
	public List<RecCallAllDate> listCallAllDate(RecCallAllDate r) throws Exception {
		return recCallAllDateDao.listCallAllDate(r);
	}
	
	@Override
	public List<RecCallAllDate> listRecDate(RecCallAllDate r) throws Exception {
		return recCallAllDateDao.listRecDate(r);
	}

	@Override
	public List<RecCallAllDate> listInitDate(RecCallAllDate r) throws Exception {
		return recCallAllDateDao.listInitDate(r);
	}
	
	@Override
	public List<RecCallAllDate> listSumAllDate(RecCallAllDate r) throws Exception {
		return recCallAllDateDao.listSumAllDate(r);
	}
	

	@Override
	public List<RecCallAllDate> listRecCallAllDate(RecCallAllDate r) throws Exception {
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		Date date = null,date2 = null;
		try {
			date = sdf.parse(r.getStart_time());
			date2 = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(date.getTime()==date2.getTime()){
			date.setDate(date.getDate()+1);
			r.setEnd_time(sdf.format(date));
			return recCallAllDateDao.listRecCallAllDate(r);
		}
		return recCallAllDateDao.listRecCallAllDatehis(r);
	}
	
	@Override
	public List<RecCallAllDate> exportlistRecCallAllDate(RecCallAllDate r) throws Exception {
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		Date date = null,date2 = null;
		try {
			date = sdf.parse(r.getStart_time());
			date2 = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(date.getTime()==date2.getTime()){
			date.setDate(date.getDate()+1);
			r.setEnd_time(sdf.format(date));
			return recCallAllDateDao.exportListRecCallAllDate(r);
		}
		return recCallAllDateDao.exportListRecCallAllDatehis(r);
	}
	
	@Override
	public List<RecCallAllDate> listrecalldate(RecCallAllDate r) throws Exception {	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		Date date = null,date2 = null;
		try {
			date = sdf.parse(r.getStart_time());
			date2 = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(date.getTime()==date2.getTime()){
			date.setDate(date.getDate()+1);
			r.setEnd_time(sdf.format(date));
			return recCallAllDateDao.listrecalldate(r);
		}
		return null;
	}

	@Override
	public List<RecCallAllDate> listCallAllData13(RecCallAllDate r)
			throws Exception {
		// TODO Auto-generated method stub
		return recCallAllDateDao.listCallAllData13(r);
	}

	@Override
	public List<RecCallAllDate> listCallAllDataNo13(RecCallAllDate r)
			throws Exception {
		// TODO Auto-generated method stub
		return recCallAllDateDao.listCallAllDataNo13(r);
	}
}
