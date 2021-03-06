package com.sky.blue.business.spmanager.service;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SpFeecodeGroup;

public interface ISpFeecodeGroupServer {
	public List<SpFeecodeGroup> listSpFeecodeGroup(SpFeecodeGroup g) throws Exception;
	
	public int addSpFeecodeGroup(SpFeecodeGroup g) throws Exception;
	
	public int updSpFeecodeGroup(SpFeecodeGroup g) throws Exception;
	
	public int delSpFeecodeGroup(SpFeecodeGroup g) throws Exception;
}
