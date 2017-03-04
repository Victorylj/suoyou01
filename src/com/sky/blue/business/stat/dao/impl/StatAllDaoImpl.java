package com.sky.blue.business.stat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.stat.dao.IStatAllDao;
import com.sky.blue.business.stat.entity.Calldetail;
import com.sky.blue.business.stat.entity.Incomededail;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("statAllDao")
public class StatAllDaoImpl extends BasicSqlSupport implements IStatAllDao {

	@Override
	public List<Calldetail> listALLChannelStat(Calldetail o) throws Exception {
		return session.selectList("listAllCalldetail", o);
	}

	@Override
	public List<Calldetail> listALLProductStat(Calldetail o) throws Exception {
		return session.selectList("listAllCalldetail", o);
	}
	
	@Override
	public List<Incomededail> listAllCompanyStat(Incomededail o) throws Exception {
		return session.selectList("listAllCompanyStat", o);
	}

	@Override
	public List<SearchBean> getAllcompany(SearchBean o) throws Exception {
		return session.selectList("getAllcompany", o);
	}

	@Override
	public List<SearchBean> getAllfeecode(SearchBean o) throws Exception {
		return session.selectList("getAllfeecode", o);
	}
	
	@Override
	public List<SearchBean> getAllproduct(SearchBean o) throws Exception {
		return session.selectList("getAllproduct", o);
	}

	@Override
	public List<SearchBean> getAllcp(SearchBean o) throws Exception {
		return session.selectList("getAllcp", o);
	}

	@Override
	public int updCalldetailFee(Calldetail o) throws Exception {
		return session.update("updCalldetailFee", o);
	}

	@Override
	public int updCompanyStatFee(Incomededail o)
			throws Exception {
		return session.update("updCompanyStatFee", o);
	}
}
