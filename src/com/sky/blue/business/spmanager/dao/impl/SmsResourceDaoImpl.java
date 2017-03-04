package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ISmsResourceDao;
import com.sky.blue.business.spmanager.entity.SmsResource;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("smsResourceDao")
public class SmsResourceDaoImpl extends BasicSqlSupport  implements ISmsResourceDao {

	@Override
	public List<SmsResource> qryCpCommandList(SmsResource smsResource)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSmsResource", smsResource);
	}

	@Override
	public int addSmsResource(SmsResource smsResource) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(smsResource);
		
		return session.insert("mybatis.mapper.Bussiness.addSmsResource", smsResource);
	}

	@Override
	public int deleteSmsResource(SmsResource smsResource) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = smsResource.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteSmsResource", ids);
	}

	@Override
	public int updateSmsResource(SmsResource smsResource) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateSmsResource", smsResource);
	}

}
