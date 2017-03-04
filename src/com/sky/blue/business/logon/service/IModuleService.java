package com.sky.blue.business.logon.service;

import java.util.List;

import com.sky.blue.business.logon.entity.Module;
import com.sky.blue.business.logon.entity.User;


public interface IModuleService {
	public List<Module> qryModuleList(Module module) throws Exception;
	public int addModule(Module module) throws Exception;
	public int deleteModule(Module module) throws Exception;
	public List<Module> getUserModuleList(User user) throws Exception;
	public Module getModule(Module module) throws Exception;
}
