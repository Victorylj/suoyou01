package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.spmanager.dao.ISpFeecodeLimitDao;
import com.sky.blue.business.spmanager.entity.SpFeecodeLimit;
import com.sky.blue.business.spmanager.entity.SpFeecodeProvinceLimit;
import com.sky.blue.business.spmanager.entity.SpProvinceControl;
import com.sky.blue.business.spmanager.service.ISpFeecodeLimitService;
@Service("spFeecodeLimitServiceImpl")
public class SpFeecodeLimitServiceImpl  implements ISpFeecodeLimitService {
	@Autowired
	private ISpFeecodeLimitDao spFeecodeLimitDao;
	@Override
	public List<SpFeecodeLimit> qryCpFeecodeLimitList(SpFeecodeLimit spFeecodeLimit)
			throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeLimitDao.qryCpFeecodeLimitList(spFeecodeLimit);
	}

	@Override
	public int addSpFeecodeLimit(SpFeecodeLimit spFeecodeLimit) throws Exception {
		// TODO Auto-generated method stub
		if(spFeecodeLimit.getLimit_id()!=null){
			return spFeecodeLimitDao.updateSpFeecodeLimit(spFeecodeLimit);
		}
		return spFeecodeLimitDao.addSpFeecodeLimit(spFeecodeLimit);
	}

	@Override
	public int deleteSpFeecodeLimit(SpFeecodeLimit spFeecodeLimit) throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeLimitDao.deleteSpFeecodeLimit(spFeecodeLimit);
	}

	@Override
	public int addSpFeecodeProvinceLimit(List<SpFeecodeProvinceLimit> proLimitList) throws Exception {
		// TODO Auto-generated method stub
		int len = proLimitList.size();
		if(len>0){
			for(int i=0;i<len;i++){
				SpFeecodeProvinceLimit proLimit = proLimitList.get(i);
				if(proLimit.getPro_limit_id()!=null){
					spFeecodeLimitDao.updateSpFeecodeProvinceLimit(proLimit);
				}else{
					spFeecodeLimitDao.addSpFeecodeProvinceLimit(proLimit);
				}
			}
			
		}
		return 0;
	}
	
	/**
	 * sjm: 添加省份计费代码限制
	 * @param proLimit
	 * @return
	 * @throws Exception
	 */
	@Override
	public int addSpFeecodeProvinceLimit(SpFeecodeProvinceLimit proLimit) throws Exception {
		// TODO Auto-generated method stub
		if(proLimit.getPro_limit_id()!=null){
			return spFeecodeLimitDao.updateSpFeecodeProvinceLimit(proLimit);
		}else{
			return spFeecodeLimitDao.addSpFeecodeProvinceLimit(proLimit);
		}
	}
	
	@Override
	public List<SpFeecodeProvinceLimit> getCpFeecodeProvinceLimitList(
			SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeLimitDao.getCpFeecodeProvinceLimitList(spFeecodeProvinceLimit);
	}

	@Override
	public int deleteSpFeecodeProvinceLimit(
			SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeLimitDao.deleteSpFeecodeProvinceLimit(spFeecodeProvinceLimit);
	}

	@Override
	public int updateSpProvinceControl(SpProvinceControl spProvinceControl)
			throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeLimitDao.updateSpProvinceControl(spProvinceControl);
	}

	@Override
	public List<SpProvinceControl> qrySpProvinceControlList(
			SpProvinceControl spProvinceControl) throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeLimitDao.qrySpProvinceControlList(spProvinceControl);
	}
}
