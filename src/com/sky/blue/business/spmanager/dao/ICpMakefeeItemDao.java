package com.sky.blue.business.spmanager.dao;

import java.util.List;

import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.entity.SpCommand;

public interface ICpMakefeeItemDao {
	public List<CpMakefeeItem> qryCpMakefeeItemList(CpMakefeeItem cpMakefeeItem) throws Exception;
	public int addCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception;
	public int closeOrOpenCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception;
	public int updateCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception;
	public int closeOrOpenCpMakefeeItemByCommandId(SpCommand spCommand) throws Exception;
	public List<CpMakefeeItem> getOpenCommandCount(CpMakefeeItem cpMakefeeItem) throws Exception;
	public int qryCpMakefeeItemCount(CpMakefeeItem cpMakefeeItem);

}
