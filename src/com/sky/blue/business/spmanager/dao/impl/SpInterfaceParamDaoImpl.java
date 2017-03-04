package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ISpInterfaceParamDao;
import com.sky.blue.business.spmanager.entity.SpInterfaceParam;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("spInterfaceParamDao")
public class SpInterfaceParamDaoImpl extends BasicSqlSupport  implements ISpInterfaceParamDao {

	@Override
	public List<SpInterfaceParam> qryCpInterfaceParamList(SpInterfaceParam spInterfaceParam)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpInterfaceParam", spInterfaceParam);
	}

	@Override
	public int addSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(spInterfaceParam);
		
		return session.insert("mybatis.mapper.Bussiness.addSpInterfaceParam", spInterfaceParam);
	}

	@Override
	public int deleteSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = spInterfaceParam.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteSpInterfaceParam", ids);
	}

	@Override
	public int updateSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateSpInterfaceParam", spInterfaceParam);
	}

}
