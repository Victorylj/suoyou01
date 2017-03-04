package com.sky.blue.business.cpmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpmanager.dao.ICpProductDao;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.business.cpmanager.service.ICpProductService;
@Service("cpProductServiceImpl")
public class CpProductServiceImpl  implements ICpProductService {
	@Autowired
	private ICpProductDao cpProductDao;
	@Override
	public List<CpProduct> qryCpProductList(CpProduct cpProduct)
			throws Exception {
		// TODO Auto-generated method stub
		return cpProductDao.qryCpProductList(cpProduct);
	}

	@Override
	public int addCpProduct(CpProduct cpProduct) throws Exception {
		// TODO Auto-generated method stub
		if(cpProduct.getProduct_id()!=null){
			return cpProductDao.updateCpProduct(cpProduct);
		}
		return cpProductDao.addCpProduct(cpProduct);
	}

	@Override
	public int deleteCpProduct(CpProduct cpProduct) throws Exception {
		// TODO Auto-generated method stub
		return cpProductDao.deleteCpProduct(cpProduct);
	}

}
