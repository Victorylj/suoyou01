package com.sky.blue.business.cpmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.dao.IChannelDataDao;
import com.sky.blue.business.cpmanager.entity.ChannelData;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("channelDataDao")
public class ChannelDataDaoImpl extends BasicSqlSupport  implements IChannelDataDao {

	@Override
	public List<ChannelData> qryChannelDataList(ChannelData channelData)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listChannelData", channelData);
	}

	@Override
	public int addChannelData(ChannelData channelData) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(channelData);
		
		return session.insert("mybatis.mapper.Bussiness.addChannelData", channelData);
	}

	@Override
	public int deleteChannelData(ChannelData channelData) throws Exception {
		// TODO Auto-generated method stub
		/*String arrIds = channelData.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}*/
		channelData.setCh_data_id(Integer.parseInt(channelData.getArrayIds()));
		return session.delete("mybatis.mapper.Bussiness.deleteChannelData", channelData);
	}

	@Override
	public int updateChannelData(ChannelData channelData) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateChannelData", channelData);
	}

}
