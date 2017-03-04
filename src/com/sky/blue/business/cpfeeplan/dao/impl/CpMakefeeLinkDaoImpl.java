package com.sky.blue.business.cpfeeplan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpfeeplan.dao.ICpMakefeeLinkDao;
import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cpMakefeeLinkDao")
public class CpMakefeeLinkDaoImpl extends BasicSqlSupport  implements ICpMakefeeLinkDao {

	@Override
	public List<CpMakefeeLink> qryCpMakefeeLinkList(CpMakefeeLink cpMakefeeLink)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpMakefeeLink", cpMakefeeLink);
	}

	@Override
	public int addCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cpMakefeeLink);
		
		return session.insert("mybatis.mapper.Bussiness.addCpMakefeeLink", cpMakefeeLink);
	}

	@Override
	public int deleteCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = cpMakefeeLink.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteCpMakefeeLink", ids);
	}

	@Override
	public int updateCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception {
		// TODO Auto-generated method stub
		return session.delete("mybatis.mapper.Bussiness.deleteCpMakefeeLinkByMeasureIdOrlinkId", cpMakefeeLink);
	}

	@Override
	public List<CpMakefeeLink> getCpMakefeeLinks(CpMakefeeLink cpMakefeeLink)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getCpMakefeeLinks", cpMakefeeLink);
	}

}
