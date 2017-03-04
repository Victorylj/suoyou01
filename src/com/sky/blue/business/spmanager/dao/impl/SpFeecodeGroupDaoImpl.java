package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.ISpFeecodeGroupDao;
import com.sky.blue.business.spmanager.entity.SpFeecodeGroup;
import com.sky.blue.comm.BasicSqlSupport;

@Repository("spFeecodeGroupDao")
public class SpFeecodeGroupDaoImpl extends BasicSqlSupport  implements ISpFeecodeGroupDao{
	
	@Override
	public List<SpFeecodeGroup> listSpFeecodeGroup(SpFeecodeGroup g) throws Exception{
		return session.selectList("listSpFeecodeGroup", g);
	}
	
	@Override
	public int addSpFeecodeGroup(SpFeecodeGroup g) throws Exception{
		return session.insert("addSpFeecodeGroup", g);
	}
	
	@Override
	public int updSpFeecodeGroup(SpFeecodeGroup g) throws Exception{
		return session.update("updSpFeecodeGroup", g);
	}
	
	@Override
	public int delSpFeecodeGroup(SpFeecodeGroup g) throws Exception{
		return session.delete("delSpFeecodeGroup", g);
	}
}
