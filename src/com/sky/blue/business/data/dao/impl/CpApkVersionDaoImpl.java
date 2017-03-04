package com.sky.blue.business.data.dao.impl;



import java.util.List;

import org.springframework.stereotype.Repository;


import com.sky.blue.business.data.dao.ICpApkVersionDao;
import com.sky.blue.business.data.entity.CpApkFeedback;
import com.sky.blue.business.data.entity.CpApkVersion;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cpApkVersionDao")
public class CpApkVersionDaoImpl extends BasicSqlSupport implements ICpApkVersionDao{

	@Override
	public List<CpApkVersion> qryCpApk(CpApkVersion apk) throws Exception {
		return session.selectList("getCpApkVersion",apk);
	}

	@Override
	public int addCpApk(CpApkVersion apk) throws Exception {
		return session.insert("addCpApkVersion",apk);
	}

	@Override
	public int updCpApk(CpApkVersion apk) throws Exception {
		return session.update("updCpApkVersion",apk);
	}

	@Override
	public int delCpApk(CpApkVersion apk) throws Exception {
		return session.delete("delCpApkVersion",apk);
	}

	@Override
	public List<CpApkFeedback> qryCpApkFeedback(CpApkFeedback apkfb)
			throws Exception {
		return session.selectList("getCpApkFeedback",apkfb);
	}

	@Override
	public int delCpApkFeedback(CpApkFeedback apk) throws Exception {
		return session.delete("delCpApkFeedback",apk);
	}

	@Override
	public int updCpApkVersionByCP(CpApkVersion apk) throws Exception {
		return session.update("updCpApkVersionByCP",apk);
	}

}
