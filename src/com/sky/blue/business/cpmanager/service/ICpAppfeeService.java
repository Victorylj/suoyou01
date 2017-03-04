package com.sky.blue.business.cpmanager.service;

import java.util.List;

import com.sky.blue.business.cpmanager.entity.CpAppfee;
import com.sky.blue.business.cpmanager.entity.FeepointLink;

public interface ICpAppfeeService {
	public List<CpAppfee> qryCpAppfeeList(CpAppfee cpAppfee) throws Exception;
	public int addCpAppfee(CpAppfee cpAppfee) throws Exception;
	public int deleteCpAppfee(CpAppfee cpAppfee) throws Exception;
	
	public int addFeepointLink(FeepointLink feepointLink) throws Exception;
	public List<FeepointLink> qryFeepointLinkList(FeepointLink feepointLink ) throws Exception;
	
}
