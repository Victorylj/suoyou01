package com.sky.blue.business.spmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sky.blue.business.spmanager.dao.IFilterSpComDao;
import com.sky.blue.business.spmanager.entity.FilterSpCom;
import com.sky.blue.business.spmanager.service.IFilterSpComService;

@Service("filterSpComServiceImpl")
public class FilterSpComServiceImpl  implements IFilterSpComService {
	@Autowired
	private IFilterSpComDao filterSpComDao;

	@Override
	public List<FilterSpCom> getFilterSpCom(FilterSpCom f) {
		return filterSpComDao.getFilterSpCom(f);
	}

	@Override
	public int delFilterSpCom(FilterSpCom f) {
		return filterSpComDao.delFilterSpCom(f);
	}

	@Override
	public int addFilterSpCom(FilterSpCom f) {
		return filterSpComDao.addFilterSpCom(f);
	}

	@Override
	public int updFilterSpCom(FilterSpCom f) {
		return filterSpComDao.updFilterSpCom(f);
	}

	@Override
	public int updFilterSpComById(FilterSpCom f) {
		return filterSpComDao.updFilterSpComById(f);
	}
	
}
