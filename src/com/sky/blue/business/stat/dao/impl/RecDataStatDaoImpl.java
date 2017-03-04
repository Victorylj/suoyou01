package com.sky.blue.business.stat.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.stat.dao.IRecDataStatDao;
import com.sky.blue.business.stat.entity.RecData;
import com.sky.blue.business.stat.entity.RecDataStat;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("recDataStatDao")
public class RecDataStatDaoImpl extends BasicSqlSupport implements IRecDataStatDao {

	@Override
	public List<RecDataStat> qryRecDataStatList(RecDataStat recDataStat)
			throws Exception {
		// TODO Auto-generated method stub
		if("1".equals(recDataStat.getIs_province())){
			return session.selectList("mybatis.mapper.Bussiness.qryRecDataStatListPro", recDataStat);
		}
		if("1".equals(recDataStat.getIs_detail())){
			return session.selectList("mybatis.mapper.Bussiness.qryRecDataStatListDetail", recDataStat);
		}
		if("1".equals(recDataStat.getIs_ch())){
			return session.selectList("mybatis.mapper.Bussiness.qryRecDataStatListCh", recDataStat);
		}
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		Date date = null,date2 = null;
		try {
			date = sdf.parse(recDataStat.getStart_time());
			date2 = sdf.parse(format.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(date.getTime()==date2.getTime()){
			return session.selectList("mybatis.mapper.Bussiness.qryRecDataStatList", recDataStat);
		}
		return session.selectList("mybatis.mapper.Bussiness.qryRecDataStatListHis", recDataStat);
	}

	@Override
	public List<RecData> qryRecDataList(RecData recData) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getRecDataList", recData);

	}

	@Override
	public List<RecDataStat> getRecDataStatList(RecDataStat recDataStat)
			throws Exception {
		if("1".equals(recDataStat.getIs_province())){
			//recDataStat.setDtype("1");
			return session.selectList("mybatis.mapper.Bussiness.getRecDataProvinceStatList", recDataStat);
		}
		// TODO Auto-generated method stub
		
		return session.selectList("mybatis.mapper.Bussiness.getRecDataStatListNew", recDataStat);

	}

	@Override
	public List<RecDataStat> getRecDataStatList_his(RecDataStat recDataStat)
			throws Exception {
		if("1".equals(recDataStat.getIs_province())){
			recDataStat.setDtype("1");
			//return session.selectList("mybatis.mapper.Bussiness.getRecDataProvinceStatList", recDataStat);
		}else{
			recDataStat.setDtype("2");
		}
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getRecDataStatListHis", recDataStat);

	}

	@Override
	public int updRecDataStatHis(RecDataStat recDataStat) throws Exception {
		return session.update("mybatis.mapper.Bussiness.updRecDataStatHis", recDataStat);
	}

	@Override
	public int saveRecDataStat(RecDataStat recDataStat) throws Exception {
		return session.insert("mybatis.mapper.Bussiness.saveRecDataStat", recDataStat);
	}

	@Override
	public int delRecDataStat(RecDataStat recDataStat) throws Exception {
		return session.insert("mybatis.mapper.Bussiness.delRecDataStat", recDataStat);
	}

	@Override
	public List<RecDataStat> getRecDelayMinute(RecDataStat recDataStat)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getRecDelayMinute", recDataStat);
	}
}
