package com.sky.blue.business.level.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.level.dao.IAutoCmdLevelDao;
import com.sky.blue.business.level.entity.AutoCmdLevel;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("autoCmdLevelDao")
public class AutoCmdLevelDaoImpl extends BasicSqlSupport implements IAutoCmdLevelDao {

	@Override
	public List<AutoCmdLevel> qryAutoCmdLevelList(AutoCmdLevel autoCmdLevel)
			throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.listAutoCmdLevel",autoCmdLevel);
	}

	@Override
	public int addAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception {
		return session.insert("mybatis.mapper.Bussiness.addAutoCmdLevel",autoCmdLevel);
	}

	@Override
	public int updateAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception {
		return session.update("mybatis.mapper.Bussiness.updateAutoCmdLevel",autoCmdLevel);
	}


	@Override
	public int closeOrOpenAutoCmdLevel(AutoCmdLevel autoCmdLevel)
			throws Exception {
		// TODO Auto-generated method stub
		String arrIds = autoCmdLevel.getArrayIds();
		String[] ids = null;
		if(arrIds!=null && !"".equals(arrIds)){
			ids=arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		autoCmdLevel.setIds(ids);
		return session.update("mybatis.mapper.Bussiness.closeOrOpenAutoCmdLevel",autoCmdLevel);
	}

	@Override
	public int deleteAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = autoCmdLevel.getArrayIds();
		String[] ids = null;
		if(arrIds!=null && !"".equals(arrIds)){
			ids=arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.update("mybatis.mapper.Bussiness.deleteAutoCmdLevel",ids);
	}

}
