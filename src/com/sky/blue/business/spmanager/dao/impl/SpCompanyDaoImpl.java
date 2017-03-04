package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.spmanager.dao.ISpCompanyDao;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("spCompanyDao")
public class SpCompanyDaoImpl extends BasicSqlSupport  implements ISpCompanyDao {

	@Override
	public List<SpCompany> qryCpCompanyList(SpCompany spCompany)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpCompany", spCompany);
	}

	@Override
	public int addSpCompany(SpCompany spCompany) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(spCompany);
		
		return session.insert("mybatis.mapper.Bussiness.addSpCompany", spCompany);
	}

	@Override
	public int deleteSpCompany(SpCompany spCompany) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = spCompany.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteSpCompany", ids);
	}

	@Override
	public int updateSpCompany(SpCompany spCompany) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateSpCompany", spCompany);
	}

	@Override
	public List<SearchBean> seachCpCompanyList(SpCompany sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.searchSpCompany", sc);
	}
	@Override
	public List<SearchBean> seachCompanyList(CpCompany sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.seachCpCompany", sc);
	}

	@Override
	public List<SearchBean> seachSpFeecodeList(SpFeecode spFeecode)
			throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.searchSpFeecode", spFeecode);
	}
	@Override
	public List<SearchBean> seachCpProductList(CpProduct spFeecode)
			throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.searchCpProduct", spFeecode);
	}
	
	@Override
	public List<SearchBean> searchSpFeecodeTow(SpFeecode spFeecode) throws Exception{
		return session.selectList("mybatis.mapper.Bussiness.searchSpFeecodeTow", spFeecode);
	}

}
