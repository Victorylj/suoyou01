package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ISpCommandDao;
import com.sky.blue.business.spmanager.entity.SpCommand;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("spCommandDao")
public class SpCommandDaoImpl extends BasicSqlSupport  implements ISpCommandDao {

	@Override
	public List<SpCommand> qryCpCommandList(SpCommand spCommand)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpCommand", spCommand);
	}
	
	@Override
	public List<SpCommand> listSpCommand(SpCommand spCommand)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpCommandNew", spCommand);
	}
	
	@Override
	public List<SpCommand> getSpCommandId(SpCommand spCommand)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getSpCommandId", spCommand);
	}

	@Override
	public int addSpCommand(SpCommand spCommand) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(spCommand);
		
		return session.insert("mybatis.mapper.Bussiness.addSpCommand", spCommand);
	}

	@Override
	public int closeOrOpenSpCommand(SpCommand spCommand) throws Exception {
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
		return session.delete("mybatis.mapper.Bussiness.closeOrOpenSpCommand", spCommand);
	}
	
	@Override
	public int updSpCommandPositiveStatu(SpCommand spCommand) throws Exception {
		String arrIds = spCommand.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		spCommand.setIds(ids);
		return session.delete("mybatis.mapper.Bussiness.updSpCommandPositiveStatu", spCommand);
	}

	@Override
	public int updateSpCommand(SpCommand spCommand) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateSpCommand", spCommand);
	}

	@Override
	public List<SpCommand> getSpCommandIdBySpid(SpCommand spCommand)
			throws Exception {
		return session.selectList("mybatis.mapper.Bussiness.getSpCommandIdBySpid", spCommand);
	}

}
