package com.sky.blue.business.spmanager.dao;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SpFeecode;

public interface ISpFeecodeDao {
	public List<SpFeecode> qryCpFeecodeList(SpFeecode spFeecode) throws Exception;
	public int addSpFeecode(SpFeecode spFeecode) throws Exception;
	public int deleteSpFeecode(SpFeecode spFeecode) throws Exception;
	public int updateSpFeecode(SpFeecode spFeecode) throws Exception;
	public int getFeecodeNumberBySpId(SpFeecode spFeecode) throws Exception;
}
