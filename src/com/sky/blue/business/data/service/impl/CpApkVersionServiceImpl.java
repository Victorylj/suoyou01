package com.sky.blue.business.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.data.dao.ICpApkVersionDao;
import com.sky.blue.business.data.entity.CpApkFeedback;
import com.sky.blue.business.data.entity.CpApkVersion;

import com.sky.blue.business.data.service.ICpApkVersionService;

@Service("cpApkVersionService")
public class CpApkVersionServiceImpl implements ICpApkVersionService {
	
	@Autowired
	private ICpApkVersionDao cpApkVersionDao;

	@Override
	public List<CpApkVersion> qryCpApk(CpApkVersion apk) throws Exception {
		return cpApkVersionDao.qryCpApk(apk);
	}

	@Override
	public int addCpApk(CpApkVersion apk) throws Exception {
		return cpApkVersionDao.addCpApk(apk);
	}

	@Override
	public int updCpApk(CpApkVersion apk) throws Exception {
		return cpApkVersionDao.updCpApk(apk);
	}

	@Override
	public int delCpApk(CpApkVersion apk) throws Exception {
		return cpApkVersionDao.delCpApk(apk);
	}

	@Override
	public List<CpApkFeedback> qryCpApkFeedback(CpApkFeedback apkfb)
			throws Exception {
		return cpApkVersionDao.qryCpApkFeedback(apkfb);
	}

	@Override
	public int delCpApkFeedback(CpApkFeedback apk) throws Exception {
		return cpApkVersionDao.delCpApkFeedback(apk);
	}

	@Override
	public int updCpApkVersionByCP(CpApkVersion apk) throws Exception {
		return cpApkVersionDao.updCpApkVersionByCP(apk);
	}
	
	

}
