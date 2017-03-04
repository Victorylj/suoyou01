package com.sky.blue.business.stat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.stat.dao.IRecCallAllDateDao;
import com.sky.blue.business.stat.entity.RecCallAllDate;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("recCallAllDateDaoImpl")
public class RecCallAllDateDaoImpl extends BasicSqlSupport  implements IRecCallAllDateDao {
	
	 @Override
	 public List<RecCallAllDate> listCallAllDate(RecCallAllDate r) throws Exception {
		 return session.selectList("mybatis.mapper.Bussiness.listCallAllDate", r);
	 }

	 @Override
	 public List<RecCallAllDate> listSumAllDate(RecCallAllDate r) throws Exception {
		 return session.selectList("mybatis.mapper.Bussiness.listSumAllDate", r);
	 }
	 
	 @Override
	 public List<RecCallAllDate> listRecDate(RecCallAllDate r) throws Exception {
		 return session.selectList("mybatis.mapper.Bussiness.listRecDate", r);
	 }

	@Override
	public List<RecCallAllDate> listInitDate(RecCallAllDate r) throws Exception {
		if(r!=null&&r.getOp()!=null||"4".equals(r.getIsop())){
			
			 return session.selectList("mybatis.mapper.Bussiness.listInitDateOp", r);
		}
		 return session.selectList("mybatis.mapper.Bussiness.listInitDate", r);
	}

	@Override
	public List<RecCallAllDate> listRecCallAllDate(RecCallAllDate r) throws Exception {
		 return session.selectList("mybatis.mapper.Bussiness.listRecCallAllDate", r);
	}
	
	@Override
	public List<RecCallAllDate> listRecCallAllDatehis(RecCallAllDate r) throws Exception {
		 return session.selectList("mybatis.mapper.Bussiness.listRecCallAllDateHis", r);
	}

	@Override
	public List<RecCallAllDate> exportListRecCallAllDate(RecCallAllDate r) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.exportListRecCallAllDate", r);
	}

	@Override
	public List<RecCallAllDate> exportListRecCallAllDatehis(RecCallAllDate r) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.exportListRecCallAllDateHis", r);
	}
	
	@Override
	public List<RecCallAllDate> listrecalldate(RecCallAllDate r) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.listrecalldate", r);
	}

	@Override
	public List<RecCallAllDate> listCallAllData13(RecCallAllDate r)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listrecalldata13", r);
	}

	@Override
	public List<RecCallAllDate> listCallAllDataNo13(RecCallAllDate r)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listrecalldataNo13", r);
	}
	
	
}
