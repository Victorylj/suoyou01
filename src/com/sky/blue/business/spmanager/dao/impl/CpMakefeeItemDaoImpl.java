package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ICpMakefeeItemDao;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.entity.SpCommand;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cpMakefeeItemDao")
public class CpMakefeeItemDaoImpl extends BasicSqlSupport  implements ICpMakefeeItemDao {

	@Override
	public List<CpMakefeeItem> qryCpMakefeeItemList(CpMakefeeItem cpMakefeeItem)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpMakefeeItem", cpMakefeeItem);
	}

	@Override
	public int addCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cpMakefeeItem);
		
		return session.insert("mybatis.mapper.Bussiness.addCpMakefeeItem", cpMakefeeItem);
	}

	@Override
	public int closeOrOpenCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = cpMakefeeItem.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		cpMakefeeItem.setIds(ids);
		return session.delete("mybatis.mapper.Bussiness.closeOrOpenCpMakefeeItem", cpMakefeeItem);
	}

	@Override
	public int updateCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateCpMakefeeItem", cpMakefeeItem);
	}

	@Override
	public int closeOrOpenCpMakefeeItemByCommandId(SpCommand spCommand) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = spCommand.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		spCommand.setIds(ids);
		return session.update("mybatis.mapper.Bussiness.closeOrOpenCpMakefeeItemByCommandId", spCommand);
	}

	@Override
	public List<CpMakefeeItem> getOpenCommandCount(CpMakefeeItem cpMakefeeItem) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getOpenCommandCount", cpMakefeeItem);

	}

	@Override
	public int qryCpMakefeeItemCount(CpMakefeeItem cpMakefeeItem) {
		return session.selectOne("mybatis.mapper.Bussiness.listCpMakefeeItemCount", cpMakefeeItem);
	}

	
}
