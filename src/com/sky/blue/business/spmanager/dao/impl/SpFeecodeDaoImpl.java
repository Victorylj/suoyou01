package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ISpFeecodeDao;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("spFeecodeDao")
public class SpFeecodeDaoImpl extends BasicSqlSupport  implements ISpFeecodeDao {

	@Override
	public List<SpFeecode> qryCpFeecodeList(SpFeecode spFeecode)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpFeecode", spFeecode);
	}

	@Override
	public int addSpFeecode(SpFeecode spFeecode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(spFeecode);
		
		return session.insert("mybatis.mapper.Bussiness.addSpFeecode", spFeecode);
	}

	@Override
	public int deleteSpFeecode(SpFeecode spFeecode) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = spFeecode.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteSpFeecode", ids);
	}

	@Override
	public int updateSpFeecode(SpFeecode spFeecode) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateSpFeecode", spFeecode);
	}

	@Override
	public int getFeecodeNumberBySpId(SpFeecode spFeecode) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("mybatis.mapper.Bussiness.getFeecodeNumberBySpId", spFeecode);
	}
	

}
