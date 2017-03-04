package com.sky.blue.business.cpmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.dao.ICpProductDao;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cpProductDao")
public class CpProductDaoImpl extends BasicSqlSupport  implements ICpProductDao {

	@Override
	public List<CpProduct> qryCpProductList(CpProduct cpProduct)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpProduct", cpProduct);
	}

	@Override
	public int addCpProduct(CpProduct cpProduct) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cpProduct);
		
		return session.insert("mybatis.mapper.Bussiness.addCpProduct", cpProduct);
	}

	@Override
	public int deleteCpProduct(CpProduct cpProduct) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = cpProduct.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteCpProduct", ids);
	}

	@Override
	public int updateCpProduct(CpProduct cpProduct) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateCpProduct", cpProduct);
	}

}
