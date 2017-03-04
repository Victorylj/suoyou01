package com.sky.blue.business.stat.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.stat.dao.IRecDataStatDao;
import com.sky.blue.business.stat.entity.RecData;
import com.sky.blue.business.stat.entity.RecDataStat;
import com.sky.blue.business.stat.service.IRecDataStatService;
@Service("recDataStatServiceImpl")
public class RecDataStatServiceImpl implements IRecDataStatService {
	@Autowired
	private IRecDataStatDao recDataStatDao;
	@Override
	public List<RecDataStat> qryRecDataStatList(RecDataStat recDataStat)
			throws Exception {
		// TODO Auto-generated method stub
		
		return recDataStatDao.qryRecDataStatList(recDataStat);
	}
	@Override
	public List<RecData> qryRecDataList(RecData recData) throws Exception {
		// TODO Auto-generated method stub
		return recDataStatDao.qryRecDataList(recData);
	}
	@Override
	public List<RecDataStat> getRecDataStatList(RecDataStat recDataStat)
			throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dater=sf.format(new Date());
        if(!dater.equals(recDataStat.getDater())){
        	recDataStat.setDater(null);
        	return recDataStatDao.getRecDataStatList_his(recDataStat);
        }else{
        	Date date = sf.parse(recDataStat.getStart_time());
        	date.setDate(date.getDate()+1);
        	recDataStat.setEnd_time(sf.format(date));
        	List<RecDataStat> li =  recDataStatDao.getRecDataStatList(recDataStat);
        	recDataStat.setEnd_time(recDataStat.getStart_time());
        	return li;
        }
		
	}
	@Override
	public int updRecDataStatHis(RecDataStat recDataStat) throws Exception {
		if(recDataStat.getIncome_calls()>0){
			recDataStatDao.delRecDataStat(recDataStat);
			recDataStatDao.saveRecDataStat(recDataStat);
		}else{
			recDataStatDao.delRecDataStat(recDataStat);
		}
		return recDataStatDao.updRecDataStatHis(recDataStat);
	}
	@Override
	public List<RecDataStat> getRecDelayMinute(RecDataStat recDataStat)
			throws Exception {
		// TODO Auto-generated method stub
		return recDataStatDao.getRecDelayMinute(recDataStat);
	}

}
