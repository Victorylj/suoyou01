package com.sky.blue.business.data.service;

import java.util.List;

import com.sky.blue.business.data.entity.MobileUserGreen;
import com.sky.blue.business.data.entity.MobileUserWihte;
/**
 *  类名 IMobileUserWihteService
 * @author 作者： 方圆盛fys
 *	实现的主要功能 ：手机号白名单的的增删查改处理
 *	创建日期：2016.10.12
 *	修改者
 *  修改日期
 *  修改内容
*/
public interface IMobileUserWihteService {

		/**
		 * 查询列表信息
		 * @param MobileUserWihte
		 * @return
		 * @author fys
		 */
		public List<MobileUserWihte> qryMobileUserWihte(MobileUserWihte mgw) throws Exception;
		public MobileUserWihte upMobileUserWihte(MobileUserWihte mbg) throws Exception;
		/**
		 * 新增信息
		 * @param MobileUserWihte
		 * @return
		 * @author fys
		 */
		public int addMobileUserWihte(MobileUserWihte mgw) throws Exception;
		public int addMobileUserWihteinfo(MobileUserWihte mgw) throws Exception;
		/**
		 * 修改信息
		 * @param MobileUserWihte
		 * @return
		 * @author fys
		 */
		public int updMobileUserWihte(MobileUserWihte mgw) throws Exception;
		/**
		 * 删除信息
		 * @param MobileUserWihte
		 * @return
		 * @author fys
		 */
		public int delMobileUserWihte(MobileUserWihte mgw) throws Exception;
}
