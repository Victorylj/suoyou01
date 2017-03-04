package com.sky.blue.business.cpfeeplan.service;

import java.util.List;

import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;


public interface ICpMakefeeLinkService {
	public List<CpMakefeeLink> qryCpMakefeeLinkList(CpMakefeeLink cpMakefeeLink) throws Exception;
	public int addCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception;
	public int deleteCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception;
}
