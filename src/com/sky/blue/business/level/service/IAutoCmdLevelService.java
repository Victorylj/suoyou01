package com.sky.blue.business.level.service;

import java.util.List;

import com.sky.blue.business.level.entity.AutoCmdLevel;

public interface IAutoCmdLevelService {
	/**
	 * 查询新代码优先级分配代码列表信息
	 * @param autoCmdLevel 新代码优先级分配代码对象
	 * @author wangjie
	 * @create 2014-12-13 am
	 * @return List<AutoCmdLevel>
	 * @throws Exception
	 */
	public List<AutoCmdLevel> qryAutoCmdLevelList(AutoCmdLevel autoCmdLevel) throws Exception;
	/**
	 * 新增新代码优先级分配代码列表信息
	 * @param autoCmdLevel 新代码优先级分配代码对象
	 * @author wangjie
	 * @create 2014-12-13 am
	 * @return int
	 * @throws Exception
	 */
	public int addAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception;
	/**
	 * 修改新代码优先级分配代码
	 * @param autoCmdLevel 新代码优先级分配代码对象
	 * @author wangjie
	 * @create 2014-12-13 am
	 * @return int
	 * @throws Exception
	 */
	public int updateAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception;
	/**
	 * 修改新代码优先级分配代码的状态
	 * @param autoCmdLevel 新代码优先级分配代码对象
	 * @return int
	 * @author wangjie
	 * @create 2014-12-13 am
	 * @throws Exception
	 */
	public int closeOrOpenAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception;
	/**
	 * 删除信息
	 * @param autoCmdLevel
	 * @return
	 * @throws Exception
	 * @author wangjie
	 * @create 2014-12-13 am
	 */
	public int deleteAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception;
} 
