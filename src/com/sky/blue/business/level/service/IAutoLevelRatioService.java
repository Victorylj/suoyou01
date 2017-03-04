package com.sky.blue.business.level.service;

import java.util.List;

import com.sky.blue.business.level.entity.AutoLevelRatio;

public interface IAutoLevelRatioService {
	/**
	 * 查询优先级分配列表信息
	 * @param autoLevelRatio
	 * @return
	 * @create 2014-12-13 am
	 * @author wangjie
	 * @throws Exception
	 */
	public List<AutoLevelRatio> qryAutoLevelRatioList(AutoLevelRatio autoLevelRatio) throws Exception;
	/**
	 * 新增优先级分配信息
	 * @param autoLevelRatio
	 * @return
	 * @throws Exception
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	public int addAutoLevelRatio(AutoLevelRatio autoLevelRatio) throws Exception;
	/**
	 * 修改新代码优先级信息
	 * @param autoLevelRatio
	 * @return
	 * @throws Exception
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	public int updateAutoLevelRatio(AutoLevelRatio autoLevelRatio) throws Exception;
	/**
	 * 删除信息
	 * @param autoCmdLevel
	 * @return
	 * @throws Exception
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	public int deleteAutoLevelRatio(AutoLevelRatio autoLevelRatio) throws Exception;
}
