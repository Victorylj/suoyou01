package com.sky.blue.business.data.dao;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.data.entity.MobileUser;
import com.sky.blue.business.data.entity.RequstInfo;

public interface IMobileUserDao {
	/**
	 * 查询列表信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public List<MobileUser> qryMobileUser(MobileUser mb) throws Exception;
	
	public List<RequstInfo> qryRequstInfoList(RequstInfo mb) throws Exception;
	public List<RequstInfo> getImsiMobileList(RequstInfo mb) throws Exception;
	/**
	 * 新增信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public int addMobileUser(MobileUser mb) throws Exception;
	public int addMobileUserinfo(MobileUser mb) throws Exception;
	/**
	 * 修改信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public int updMobileUser(MobileUser mb) throws Exception;
	/**
	 * 删除信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public int delMobileUser(MobileUser mb) throws Exception;
	
}
