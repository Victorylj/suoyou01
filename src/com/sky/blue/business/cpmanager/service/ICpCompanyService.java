package com.sky.blue.business.cpmanager.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpMember;
import com.sky.blue.business.cpmanager.entity.ProductPackage;

public interface ICpCompanyService {
	public List<CpCompany> qryCpCompanyList(CpCompany cpCompany) throws Exception;
	public int addCpCompany(CpCompany cpCompany) throws Exception;
	public int deleteCpCompany(CpCompany cpCompany) throws Exception;
	public List<CpMember> qryCpMemberList(CpMember cpMember) throws Exception;
	public List<ProductPackage> getPackage(ProductPackage pp);
	public int delPackage(ProductPackage pp);
	public int addPackage(ProductPackage pp);
}
