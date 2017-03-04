package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.IFilterSpComDao;
import com.sky.blue.business.spmanager.entity.FilterSpCom;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("filterSpComDao")
public class FilterSpComDaoImpl extends BasicSqlSupport  implements IFilterSpComDao {

	@Override
	public List<FilterSpCom> getFilterSpCom(FilterSpCom f) {
		return session.selectList("getFilterSpCom", f);
	}

	@Override
	public int delFilterSpCom(FilterSpCom f) {
		return session.delete("delFilterSpCom", f);
	}

	@Override
	public int addFilterSpCom(FilterSpCom f) {
		return session.insert("addFilterSpCom", f);
	}

	@Override
	public int updFilterSpCom(FilterSpCom f) {	
		return session.update("updFilterSpCom", f);
	}

	@Override
	public int updFilterSpComById(FilterSpCom f) {
		return session.update("updFilterSpComById", f);
	}

	

}
