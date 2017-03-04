package com.sky.blue.business.level.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.level.dao.IAutoLevelRatioDao;
import com.sky.blue.business.level.entity.AutoCmdLevel;
import com.sky.blue.business.level.entity.AutoLevelRatio;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("autoLevelRatioDao")
public class AutoLevelRatioDaoImpl extends BasicSqlSupport implements IAutoLevelRatioDao {

	@Override
	public List<AutoLevelRatio> qryAutoLevelRatioList(AutoLevelRatio autoLevelRatio)
			throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.listAutoLevelRatio",autoLevelRatio);
	}

	@Override
	public int addAutoLevelRatio(AutoLevelRatio autoLevelRatio)
			throws Exception {
		return session.insert("mybatis.mapper.Bussiness.addAutoLevelRatio",autoLevelRatio);
	}

	@Override
	public int updateAutoLevelRatio(AutoLevelRatio autoLevelRatio)
			throws Exception {
		return session.update("mybatis.mapper.Bussiness.updateAutoLevelRatio",autoLevelRatio);
	}

	@Override
	public int deleteAutoLevelRatio(AutoLevelRatio autoLevelRatio)
			throws Exception {
		String arrIds = autoLevelRatio.getArrayIds();
		String[] ids = null;
		if(arrIds!=null && !"".equals(arrIds)){
			ids=arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.update("mybatis.mapper.Bussiness.deleteAutoLevelRatio",ids);
	}

	
}
