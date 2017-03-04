package com.sky.blue.business.cpmanager.service;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.CpProduct;

public interface ICpProductService {
	public List<CpProduct> qryCpProductList(CpProduct cpProduct) throws Exception;
	public int addCpProduct(CpProduct cpProduct) throws Exception;
	public int deleteCpProduct(CpProduct cpProduct) throws Exception;
}
