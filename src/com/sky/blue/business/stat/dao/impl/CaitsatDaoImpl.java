package com.sky.blue.business.stat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.stat.dao.ICaitsatDao;
import com.sky.blue.business.stat.entity.Caitsat;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("caitsatDao")
public class CaitsatDaoImpl extends BasicSqlSupport implements ICaitsatDao {

	@Override
	public List<Caitsat> qryCaitsatList(Caitsat obj) throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.qryCaitsatList", obj);
	}
}
