package com.sky.blue.business.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.data.dao.IDataDictionaryDao;
import com.sky.blue.business.data.entity.DataDictionary;
import com.sky.blue.business.data.service.IDataDictionaryService;
@Service("dataDictionaryServiceImpl")
public class DataDictionaryServiceImpl implements IDataDictionaryService {
	@Autowired
	private IDataDictionaryDao dataDictionaryDao;
	
	@Override
	public List<DataDictionary> qryDataDictionaryList(
			DataDictionary dataDictionary) throws Exception {
		// TODO Auto-generated method stub
		return dataDictionaryDao.qryDataDictionaryList(dataDictionary);
	}

	@Override
	public List<DataDictionary> qryDataDictionaryLists(
			DataDictionary dataDictionary) throws Exception {
		// TODO Auto-generated method stub
		return dataDictionaryDao.qryDataDictionaryLists(dataDictionary);
	}
	
	@Override
	public int addDataDictionary(DataDictionary dataDictionary)
			throws Exception {
		//如果id不为空执行更新操作
		if(dataDictionary.getId()!=null){
			return dataDictionaryDao.updateDataDictionary(dataDictionary);
		}
		return dataDictionaryDao.addDataDictionary(dataDictionary);
	}

	@Override
	public int updateDataDictionary(DataDictionary dataDictionary)
			throws Exception {
		// TODO Auto-generated method stub
		return dataDictionaryDao.updateDataDictionary(dataDictionary);
	}

	@Override
	public int deleteDataDictionary(DataDictionary dataDictionary)
			throws Exception {
		// TODO Auto-generated method stub
		return dataDictionaryDao.deleteDataDictionary(dataDictionary);
	}

}
