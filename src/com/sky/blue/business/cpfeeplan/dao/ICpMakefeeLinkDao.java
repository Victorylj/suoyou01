package com.sky.blue.business.cpfeeplan.dao;

import java.util.List;

import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;


public interface ICpMakefeeLinkDao {
	public List<CpMakefeeLink> qryCpMakefeeLinkList(CpMakefeeLink cpMakefeeLink) throws Exception;
	public int addCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception;
	public int deleteCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception;
	public int updateCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception;
	
	public List<CpMakefeeLink> getCpMakefeeLinks(CpMakefeeLink cpMakefeeLink) throws Exception;
	
}
