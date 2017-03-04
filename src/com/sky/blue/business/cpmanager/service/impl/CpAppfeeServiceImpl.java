package com.sky.blue.business.cpmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpmanager.dao.ICpAppfeeDao;
import com.sky.blue.business.cpmanager.entity.CpAppfee;
import com.sky.blue.business.cpmanager.entity.FeepointLink;
import com.sky.blue.business.cpmanager.service.ICpAppfeeService;
@Service("cpAppfeeServiceImpl")
public class CpAppfeeServiceImpl  implements ICpAppfeeService {
	@Autowired
	private ICpAppfeeDao cpAppfeeDao;
	@Override
	public List<CpAppfee> qryCpAppfeeList(CpAppfee cpAppfee)
			throws Exception {
		// TODO Auto-generated method stub
		return cpAppfeeDao.qryCpAppfeeList(cpAppfee);
	}

	@Override
	public int addCpAppfee(CpAppfee cpAppfee) throws Exception {
		// TODO Auto-generated method stub
		if(cpAppfee.getAppfee_id()!=null){
			return cpAppfeeDao.updateCpAppfee(cpAppfee);
		}
		return cpAppfeeDao.addCpAppfee(cpAppfee);
	}

	@Override
	public int deleteCpAppfee(CpAppfee cpAppfee) throws Exception {
		// TODO Auto-generated method stub
		return cpAppfeeDao.deleteCpAppfee(cpAppfee);
	}

	@Override
	public int addFeepointLink(FeepointLink feepointLink) throws Exception {
		// TODO Auto-generated method stub
		cpAppfeeDao.deleteFeepointLink(feepointLink);
		return cpAppfeeDao.addFeepointLink(feepointLink);
	}

	@Override
	public List<FeepointLink> qryFeepointLinkList(FeepointLink feepointLink)
			throws Exception {
		// TODO Auto-generated method stub
		return cpAppfeeDao.qryFeepointLinkList(feepointLink);
	}

}
