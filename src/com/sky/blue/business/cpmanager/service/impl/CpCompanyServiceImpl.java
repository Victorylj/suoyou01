package com.sky.blue.business.cpmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpmanager.dao.ICpCompanyDao;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpMember;
import com.sky.blue.business.cpmanager.entity.ProductPackage;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
@Service("cpCompanyServiceImpl")
public class CpCompanyServiceImpl  implements ICpCompanyService {
	@Autowired
	private ICpCompanyDao cpCompanyDao;
	@Override
	public List<CpCompany> qryCpCompanyList(CpCompany cpCompany)
			throws Exception {
		// TODO Auto-generated method stub
		return cpCompanyDao.qryCpCompanyList(cpCompany);
	}

	@Override
	public int addCpCompany(CpCompany cpCompany) throws Exception {
		// TODO Auto-generated method stub
		if(cpCompany.getCp_id()!=null){
			return cpCompanyDao.updateCpCompany(cpCompany);
		}
		return cpCompanyDao.addCpCompany(cpCompany);
	}

	@Override
	public int deleteCpCompany(CpCompany cpCompany) throws Exception {
		// TODO Auto-generated method stub
		return cpCompanyDao.deleteCpCompany(cpCompany);
	}

	@Override
	public List<CpMember> qryCpMemberList(CpMember cpMember) throws Exception {
		// TODO Auto-generated method stub
		return cpCompanyDao.qryCpMemberList(cpMember);
	}

	@Override
	public List<ProductPackage> getPackage(ProductPackage pp) {
		// TODO Auto-generated method stub
		return cpCompanyDao.getPackage(pp);
	}

	@Override
	public int delPackage(ProductPackage pp) {
		// TODO Auto-generated method stub
		return cpCompanyDao.delPackage(pp);
	}

	@Override
	public int addPackage(ProductPackage pp) {
		// TODO Auto-generated method stub
		return cpCompanyDao.addPackage(pp);
	}

}
