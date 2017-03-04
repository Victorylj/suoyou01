package com.sky.blue.business.cpfeeplan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpfeeplan.dao.ICpFeeplanDao;
import com.sky.blue.business.cpfeeplan.entity.CpFeeplan;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cpFeeplanDao")
public class CpFeeplanDaoImpl extends BasicSqlSupport  implements ICpFeeplanDao {

	@Override
	public List<CpFeeplan> qryCpFeeplanList(CpFeeplan cpFeeplan)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpFeeplan", cpFeeplan);
	}

	@Override
	public int addCpFeeplan(CpFeeplan cpFeeplan) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cpFeeplan);
		
		return session.insert("mybatis.mapper.Bussiness.addCpFeeplan", cpFeeplan);
	}

	@Override
	public int deleteCpFeeplan(CpFeeplan cpFeeplan) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = cpFeeplan.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteCpFeeplan", ids);
	}

	@Override
	public int updateCpFeeplan(CpFeeplan cpFeeplan) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateCpFeeplan", cpFeeplan);
	}

}
