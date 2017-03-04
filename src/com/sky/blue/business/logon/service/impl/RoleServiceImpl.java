package com.sky.blue.business.logon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.logon.dao.IRoleDao;
import com.sky.blue.business.logon.entity.ModuleRoleLink;
import com.sky.blue.business.logon.entity.Role;
import com.sky.blue.business.logon.service.IRoleService;

@Service("roleServiceImpl")
public class RoleServiceImpl  implements IRoleService {
	@Autowired
	private IRoleDao roleDao;
	@Override
	public List<Role> qryRoleList(Role role)
			throws Exception {
		// TODO Auto-generated method stub
		return roleDao.qryRoleList(role);
	}

	@Override
	public int addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		if(role.getRole_id()!=null){
			roleDao.deleteRoleModuleLink(role);
			String[] modules = role.getModules();
			if(modules!=null){
				for(String str:modules){
					ModuleRoleLink moduleRoleLink = new ModuleRoleLink();
					moduleRoleLink.setRole_id(role.getRole_id());
					moduleRoleLink.setModule_id(Integer.parseInt(str));
					roleDao.addRoleModuleLink(moduleRoleLink);
				}
			}
			return roleDao.updateRole(role);
		}else{
			int i = roleDao.addRole(role);
			int role_id=role.getRole_id();
			String[] modules = role.getModules();
			if(modules!=null){
				for(String str:modules){
					ModuleRoleLink moduleRoleLink = new ModuleRoleLink();
					moduleRoleLink.setRole_id(role_id);
					moduleRoleLink.setModule_id(Integer.parseInt(str));
					roleDao.addRoleModuleLink(moduleRoleLink);
				}
			}
			
		}
		return 0;
	}

	@Override
	public int deleteRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleDao.deleteRole(role);
	}

}
