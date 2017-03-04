package com.sky.blue.business.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.data.dao.IDataDictionaryDao;
import com.sky.blue.business.data.entity.DataDictionary;
import com.sky.blue.business.level.entity.AutoCmdLevel;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("dataDictionaryDao")
public class DataDictionaryImpl extends BasicSqlSupport implements IDataDictionaryDao{

	@Override
	public List<DataDictionary> qryDataDictionaryList(
			DataDictionary dataDictionary) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listDataDictionary",dataDictionary);
	}
	@Override
	public List<DataDictionary> qryDataDictionaryLists(
			DataDictionary dataDictionary) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listDataDictionaryList",dataDictionary);
	}
	@Override
	public int addDataDictionary(DataDictionary dataDictionary)
			throws Exception {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addDataDictionary", dataDictionary);
	}

	@Override
	public int updateDataDictionary(DataDictionary dataDictionary)
			throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateDataDictionary", dataDictionary);
	}

	@Override
	public int deleteDataDictionary(DataDictionary dataDictionary) throws Exception {
		String arrIds = dataDictionary.getArrayIds();
		String[] ids = null;
		if(arrIds!=null && !"".equals(arrIds)){
			ids=arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.update("mybatis.mapper.Bussiness.deleteDataDictionary",ids);
	}

}
