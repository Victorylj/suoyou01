package com.sky.blue.business.cpmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.dao.ICpAppfeeDao;
import com.sky.blue.business.cpmanager.entity.CpAppfee;
import com.sky.blue.business.cpmanager.entity.FeepointLink;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cpAppfeeDao")
public class CpAppfeeDaoImpl extends BasicSqlSupport  implements ICpAppfeeDao {

	@Override
	public List<CpAppfee> qryCpAppfeeList(CpAppfee cpAppfee)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpAppfee", cpAppfee);
	}

	@Override
	public int addCpAppfee(CpAppfee cpAppfee) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cpAppfee);
		
		return session.insert("mybatis.mapper.Bussiness.addCpAppfee", cpAppfee);
	}

	@Override
	public int deleteCpAppfee(CpAppfee cpAppfee) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = cpAppfee.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteCpAppfee", ids);
	}

	@Override
	public int updateCpAppfee(CpAppfee cpAppfee) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateCpAppfee", cpAppfee);
	}

	@Override
	public int addFeepointLink(FeepointLink feepointLink) throws Exception {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addFeepointLink", feepointLink);
	}

	@Override
	public List<FeepointLink> qryFeepointLinkList(FeepointLink feepointLink)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listFeepointLink", feepointLink);
	}
	public int deleteFeepointLink(FeepointLink feepointLink) throws Exception{
		return session.delete("mybatis.mapper.Bussiness.deleteFeepointLink",  feepointLink);
	}
}
