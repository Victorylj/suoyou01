package com.sky.blue.business.spmanager.service;

import java.util.List;

import com.sky.blue.business.spmanager.entity.CpMakefeeItem;

public interface ICpMakefeeItemService {
	public List<CpMakefeeItem> qryCpMakefeeItemList(CpMakefeeItem cpMakefeeItem) throws Exception;
	public int addCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception;
	public int closeOrOpenCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception;
	
	public List<CpMakefeeItem> getOpenCommandCount(CpMakefeeItem cpMakefeeItem) throws Exception;
	public int qryCpMakefeeItemCount(CpMakefeeItem cpMakefeeItem)
			throws Exception;

}
