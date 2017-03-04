package com.sky.blue.business.cpmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.dao.ICpCompanyDao;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpMember;
import com.sky.blue.business.cpmanager.entity.ProductPackage;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cpCompanyDao")
public class CpCompanyDaoImpl extends BasicSqlSupport  implements ICpCompanyDao {

	@Override
	public List<CpCompany> qryCpCompanyList(CpCompany cpCompany)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpCompany", cpCompany);
	}

	@Override
	public int addCpCompany(CpCompany cpCompany) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cpCompany);
		
		return session.insert("mybatis.mapper.Bussiness.addCpCompany", cpCompany);
	}

	@Override
	public int deleteCpCompany(CpCompany cpCompany) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = cpCompany.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteCpCompany", ids);
	}

	@Override
	public int updateCpCompany(CpCompany cpCompany) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateCpCompany", cpCompany);
	}

	@Override
	public List<CpMember> qryCpMemberList(CpMember cpMember) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpMember", cpMember);

	}

	@Override
	public List<ProductPackage> getPackage(ProductPackage pp) {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listPackage", pp);
	}

	@Override
	public int delPackage(ProductPackage pp) {
		// TODO Auto-generated method stub
		return session.delete("mybatis.mapper.Bussiness.delPackage", pp);
	}

	@Override
	public int addPackage(ProductPackage pp) {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addPackage", pp);
	}

}
