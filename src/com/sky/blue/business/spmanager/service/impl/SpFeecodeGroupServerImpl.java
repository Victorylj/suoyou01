package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ISpFeecodeGroupDao;
import com.sky.blue.business.spmanager.entity.SpFeecodeGroup;
import com.sky.blue.business.spmanager.service.ISpFeecodeGroupServer;

@Repository("spFeecodeGroupServer")
public class SpFeecodeGroupServerImpl implements ISpFeecodeGroupServer{
	
	@Autowired
	public ISpFeecodeGroupDao spFeecodeGroupDao;
	
	public List<SpFeecodeGroup> listSpFeecodeGroup(SpFeecodeGroup g) throws Exception{
		return spFeecodeGroupDao.listSpFeecodeGroup(g);
	}
	
	public int addSpFeecodeGroup(SpFeecodeGroup g) throws Exception{
		return spFeecodeGroupDao.addSpFeecodeGroup(g);
	}
	
	public int updSpFeecodeGroup(SpFeecodeGroup g) throws Exception{
		return spFeecodeGroupDao.updSpFeecodeGroup(g);
	}
	
	public int delSpFeecodeGroup(SpFeecodeGroup g) throws Exception{
		return spFeecodeGroupDao.delSpFeecodeGroup(g);
	}
}
