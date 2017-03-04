package com.sky.blue.business.logon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.logon.dao.IModuleDao;
import com.sky.blue.business.logon.entity.Module;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.logon.service.IModuleService;

@Service("moduleServiceImpl")
public class ModuleServiceImpl  implements IModuleService {
	@Autowired
	private IModuleDao moduleDao;
	@Override
	public List<Module> qryModuleList(Module module)
			throws Exception {
		// TODO Auto-generated method stub
		return moduleDao.qryModuleList(module);
	}

	@Override
	public int addModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		if(module.getModule_id()!=null){
			return moduleDao.updateModule(module);
		}
		return moduleDao.addModule(module);
	}

	@Override
	public int deleteModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		return moduleDao.deleteModule(module);
	}

	@Override
	public List<Module> getUserModuleList(User user) throws Exception {
		// TODO Auto-generated method stub
		return moduleDao.getUserModuleList(user);
	}

	@Override
	public Module getModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		return moduleDao.getModule(module);
	}

}
