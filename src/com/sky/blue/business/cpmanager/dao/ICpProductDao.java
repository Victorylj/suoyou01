package com.sky.blue.business.cpmanager.dao;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.CpProduct;

public interface ICpProductDao {
	public List<CpProduct> qryCpProductList(CpProduct cpProduct) throws Exception;
	public int addCpProduct(CpProduct cpProduct) throws Exception;
	public int deleteCpProduct(CpProduct cpProduct) throws Exception;
	public int updateCpProduct(CpProduct cpProduct) throws Exception;
}
