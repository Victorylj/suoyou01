package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.spmanager.dao.ISpFeecodeDao;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
@Service("spFeecodeServiceImpl")
public class SpFeecodeServiceImpl  implements ISpFeecodeService {
	@Autowired
	private ISpFeecodeDao spFeecodeDao;
	@Override
	public List<SpFeecode> qryCpFeecodeList(SpFeecode spFeecode)
			throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeDao.qryCpFeecodeList(spFeecode);
	}

	@Override
	public int addSpFeecode(SpFeecode spFeecode) throws Exception {
		// TODO Auto-generated method stub
		if(spFeecode.getFeecode_id()!=null){
			return spFeecodeDao.updateSpFeecode(spFeecode);
		}
		return spFeecodeDao.addSpFeecode(spFeecode);
	}

	@Override
	public int deleteSpFeecode(SpFeecode spFeecode) throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeDao.deleteSpFeecode(spFeecode);
	}

	@Override
	public int getFeecodeNumberBySpId(SpFeecode spFeecode) throws Exception {
		// TODO Auto-generated method stub
		return spFeecodeDao.getFeecodeNumberBySpId(spFeecode);
	}

}
