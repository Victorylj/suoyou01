package com.sky.blue.business.cpfeeplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpfeeplan.dao.ICpFeeplanDao;
import com.sky.blue.business.cpfeeplan.entity.CpFeeplan;
import com.sky.blue.business.cpfeeplan.service.ICpFeeplanService;

@Service("cpFeeplanServiceImpl")
public class CpFeeplanServiceImpl  implements ICpFeeplanService {
	@Autowired
	private ICpFeeplanDao cpFeeplanDao;
	@Override
	public List<CpFeeplan> qryCpFeeplanList(CpFeeplan cpFeeplan)
			throws Exception {
		// TODO Auto-generated method stub
		return cpFeeplanDao.qryCpFeeplanList(cpFeeplan);
	}

	@Override
	public int addCpFeeplan(CpFeeplan cpFeeplan) throws Exception {
		// TODO Auto-generated method stub
		if(cpFeeplan.getFeeplan_id()!=null){
			return cpFeeplanDao.updateCpFeeplan(cpFeeplan);
		}
		return cpFeeplanDao.addCpFeeplan(cpFeeplan);
	}

	@Override
	public int deleteCpFeeplan(CpFeeplan cpFeeplan) throws Exception {
		// TODO Auto-generated method stub
		return cpFeeplanDao.deleteCpFeeplan(cpFeeplan);
	}

}
