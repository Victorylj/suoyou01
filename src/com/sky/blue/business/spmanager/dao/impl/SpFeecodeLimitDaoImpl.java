package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ISpFeecodeLimitDao;
import com.sky.blue.business.spmanager.entity.SpFeecodeLimit;
import com.sky.blue.business.spmanager.entity.SpFeecodeProvinceLimit;
import com.sky.blue.business.spmanager.entity.SpProvinceControl;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("spFeecodeLimitDao")
public class SpFeecodeLimitDaoImpl extends BasicSqlSupport  implements ISpFeecodeLimitDao {

	@Override
	public List<SpFeecodeLimit> qryCpFeecodeLimitList(SpFeecodeLimit spFeecodeLimit)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpFeecodeLimit", spFeecodeLimit);
	}

	@Override
	public int addSpFeecodeLimit(SpFeecodeLimit spFeecodeLimit) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(spFeecodeLimit);
		
		return session.insert("mybatis.mapper.Bussiness.addSpFeecodeLimit", spFeecodeLimit);
	}

	@Override
	public int deleteSpFeecodeLimit(SpFeecodeLimit spFeecodeLimit) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = spFeecodeLimit.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteSpFeecodeLimit", ids);
	}

	@Override
	public int updateSpFeecodeLimit(SpFeecodeLimit spFeecodeLimit) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateSpFeecodeLimit", spFeecodeLimit);
	}

	@Override
	public int updateSpFeecodeProvinceLimit(
			SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateSpFeecodeProvinceLimit", spFeecodeProvinceLimit);

	}

	@Override
	public int addSpFeecodeProvinceLimit(
			SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addSpFeecodeProvinceLimit", spFeecodeProvinceLimit);
	}

	@Override
	public List<SpFeecodeProvinceLimit> getCpFeecodeProvinceLimitList(
			SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpFeecodeProvinceLimit", spFeecodeProvinceLimit);

	}

	@Override
	public int deleteSpFeecodeProvinceLimit(SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = spFeecodeProvinceLimit.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteSpFeecodeProvinceLimit", ids);
	}

	@Override
	public int updateSpProvinceControl(SpProvinceControl spProvinceControl)
			throws Exception {
		// TODO Auto-generated method stub
		 	return session.update("mybatis.mapper.Bussiness.updateSpProvinceControl", spProvinceControl);
	}

	@Override
	public List<SpProvinceControl> qrySpProvinceControlList(
			SpProvinceControl spProvinceControl) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listSpProvinceControlList", spProvinceControl);

	}



}
