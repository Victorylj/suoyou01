package com.sky.blue.business.data.dao;

import java.util.List;

import com.sky.blue.business.data.entity.DataDictionary;
import com.sky.blue.business.level.entity.AutoCmdLevel;

public interface IDataDictionaryDao {
	/**
	 * 查询列表信息
	 * @param dataDictionary
	 * @return
	 * @throws Exception
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	public List<DataDictionary> qryDataDictionaryList(DataDictionary dataDictionary) throws Exception;
	public List<DataDictionary> qryDataDictionaryLists(DataDictionary dataDictionary) throws Exception;

	/**
	 * 新增信息
	 * @param dataDictionary
	 * @return
	 * @throws Exception
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	public int addDataDictionary(DataDictionary dataDictionary) throws Exception;
	/**
	 * 修改信息
	 * @param dataDictionary
	 * @return
	 * @throws Exception
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	public int updateDataDictionary(DataDictionary dataDictionary) throws Exception;
	/**
	 * 删除信息
	 * @param autoCmdLevel
	 * @return
	 * @throws Exception
	 */
	public int deleteDataDictionary(DataDictionary dataDictionary) throws Exception;
	
}
