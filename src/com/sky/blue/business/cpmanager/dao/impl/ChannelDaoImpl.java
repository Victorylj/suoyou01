package com.sky.blue.business.cpmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.dao.IChannelDao;
import com.sky.blue.business.cpmanager.entity.Channel;
import com.sky.blue.business.cpmanager.entity.ChannelProduct;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("channelDao")
public class ChannelDaoImpl extends BasicSqlSupport  implements IChannelDao {

	@Override
	public List<Channel> qryChannelList(Channel channel)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listChannel", channel);
	}
	
	@Override
	public List<SearchBean> searchChannelList(Channel channel)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.searchListChannel", channel);
	}

	@Override
	public int addChannel(Channel channel) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(channel);
		
		return session.insert("mybatis.mapper.Bussiness.addChannel", channel);
	}

	@Override
	public int deleteChannel(Channel channel) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = channel.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteChannel", ids);
	}

	@Override
	public int updateChannel(Channel channel) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateChannel", channel);
	}

	@Override
	public List<ChannelProduct> qryChannelProductList(
			ChannelProduct channelProduct) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getChannelProduct", channelProduct);
	}

	@Override
	public int addChannelProduct(ChannelProduct channelProduct)
			throws Exception {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addChannelProduct", channelProduct);
	}

	@Override
	public int deleteChannelProduct(ChannelProduct channelProduct)
			throws Exception {
		// TODO Auto-generated method stub
		String arrIds = channelProduct.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteChannel", ids);
	}

	@Override
	public int updateChannelTag(Channel channel) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = channel.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		channel.setIds(ids);
		return session.delete("mybatis.mapper.Bussiness.updateChannelTag", channel);
	}
	
	@Override
	public int updateChStatus(Channel channel) throws Exception {
		if(channel.getCh_cut()==null){
			return session.update("updCpStatus", channel);
		}else{
			return session.insert("addCpStatus", channel);
		}
	}

}
