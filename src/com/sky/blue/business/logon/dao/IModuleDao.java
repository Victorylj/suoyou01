package com.sky.blue.business.logon.dao;

import java.util.List;

import com.sky.blue.business.logon.entity.Module;
import com.sky.blue.business.logon.entity.User;


public interface IModuleDao {
	public List<Module> qryModuleList(Module module) throws Exception;
	public int addModule(Module module) throws Exception;
	public int deleteModule(Module module) throws Exception;
	public int updateModule(Module module) throws Exception;
	public List<Module> getUserModuleList(User user) throws Exception;
	public Module getModule(Module module) throws Exception;

}
