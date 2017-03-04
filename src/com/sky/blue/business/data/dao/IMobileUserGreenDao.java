package com.sky.blue.business.data.dao;

import java.util.List;

import com.sky.blue.business.data.entity.MobileUserGreen;
/**
 *  类名 IMobileUserGreenDao
 * @author 作者： 方圆盛fys
 *	实现的主要功能 ：手机号绿名单的的增删查改
 *	创建日期：2016.10.12
 *	修改者
 *  修改日期
 *  修改内容
*/


public interface IMobileUserGreenDao {
	/**
	 * 查询列表信息
	 * @param MobileUserGreen
	 * @return
	 * @author fys
	 */
	public List<MobileUserGreen> qryMobileUserGreen(MobileUserGreen mbg) throws Exception;
	public MobileUserGreen upMobileUserGreen(MobileUserGreen mbg) throws Exception;
	/**
	 * 新增信息
	 * @param MobileUserGreen
	 * @return
	 * @author fys
	 */
	public int addMobileUserGreen(MobileUserGreen mbg) throws Exception;
	public int addMobileUserGreeninfo(MobileUserGreen mbg) throws Exception;
	/**
	 * 修改信息
	 * @param MobileUserGreen
	 * @return
	 * @author fys
	 */
	public int updMobileUserGreen(MobileUserGreen mbg) throws Exception;
	/**
	 * 删除信息
	 * @param MobileUserGreen
	 * @return
	 * @author fys
	 */
	public int delMobileUserGreen(MobileUserGreen mbg) throws Exception;
}
