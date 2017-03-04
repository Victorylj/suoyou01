package com.sky.blue.business.spmanager.dao;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SpFeecodeLimit;
import com.sky.blue.business.spmanager.entity.SpFeecodeProvinceLimit;
import com.sky.blue.business.spmanager.entity.SpProvinceControl;

public interface ISpFeecodeLimitDao {
	public List<SpFeecodeLimit> qryCpFeecodeLimitList(SpFeecodeLimit spFeecodeLimit) throws Exception;
	public int addSpFeecodeLimit(SpFeecodeLimit spFeecodeLimit) throws Exception;
	public int deleteSpFeecodeLimit(SpFeecodeLimit spFeecodeLimit) throws Exception;
	public int updateSpFeecodeLimit(SpFeecodeLimit spFeecodeLimit) throws Exception;
	
	public int updateSpFeecodeProvinceLimit(SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception;
	public int addSpFeecodeProvinceLimit(SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception;
	public List<SpFeecodeProvinceLimit> getCpFeecodeProvinceLimitList(SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception;
	public int deleteSpFeecodeProvinceLimit(SpFeecodeProvinceLimit spFeecodeProvinceLimit) throws Exception;
	public int updateSpProvinceControl(SpProvinceControl spProvinceControl) throws Exception;
	public List<SpProvinceControl> qrySpProvinceControlList(SpProvinceControl spProvinceControl) throws Exception;
}
