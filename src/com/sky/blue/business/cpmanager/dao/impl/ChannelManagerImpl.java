package com.sky.blue.business.cpmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.dao.IChannelManagerDao;
import com.sky.blue.business.cpmanager.entity.ChannelManager;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("channelManagerDao")
public class ChannelManagerImpl extends BasicSqlSupport  implements IChannelManagerDao {

	@Override
	public List<ChannelManager> qryChannelManagerList(ChannelManager channelManager)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listChannelManager", channelManager);
	}

	@Override
	public int addChannelManager(ChannelManager channelManager) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(channelManager);
		
		return session.insert("mybatis.mapper.Bussiness.addChannelManager", channelManager);
	}

	@Override
	public int deleteChannelManager(ChannelManager channelManager) throws Exception {
		// TODO Auto-generated method stub
	/*	String arrIds = channelManager.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}*/
		channelManager.setM_id(Integer.parseInt(channelManager.getArrayIds()));
		return session.delete("mybatis.mapper.Bussiness.deleteChannelManager", channelManager);
	}

	@Override
	public int updateChannelManager(ChannelManager channelManager) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateChannelManager", channelManager);
	}

}
