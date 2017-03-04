package com.sky.blue.business.data.service;

import java.util.List;

import com.sky.blue.business.data.entity.CpApkFeedback;
import com.sky.blue.business.data.entity.CpApkVersion;

public interface ICpApkVersionService {
	/**
	 * 查询apk列表信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public List<CpApkVersion> qryCpApk(CpApkVersion apk) throws Exception;
	/**
	 * 新增apk信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public int addCpApk(CpApkVersion apk) throws Exception;
	/**
	 * 修改apk信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public int updCpApk(CpApkVersion apk) throws Exception;
	public int updCpApkVersionByCP(CpApkVersion apk) throws Exception;
	/**
	 * 删除apk信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public int delCpApk(CpApkVersion apk) throws Exception;
	
	/**
	 * 查询apk反馈信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public List<CpApkFeedback> qryCpApkFeedback(CpApkFeedback apkfb) throws Exception;
	
	/**
	 * 删除apk反馈信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	public int delCpApkFeedback(CpApkFeedback apk) throws Exception;
}
