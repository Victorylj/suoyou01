package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ISpChannelDao;
import com.sky.blue.business.spmanager.entity.SpChannel;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("spChannelDao")
public class SpChannelDaoImpl extends BasicSqlSupport  implements ISpChannelDao {

	@Override
	public List<SpChannel> qryCpChannelList(SpChannel spChannel)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpChannel", spChannel);
	}

	@Override
	public int addSpChannel(SpChannel spChannel) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(spChannel);
		
		return session.insert("mybatis.mapper.Bussiness.addSpChannel", spChannel);
	}

	@Override
	public int deleteSpChannel(SpChannel spChannel) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = spChannel.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteSpChannel", ids);
	}

	@Override
	public int updateSpChannel(SpChannel spChannel) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateSpChannel", spChannel);
	}

}
