package com.sky.blue.business.logon.dao;

import java.util.List;

import com.sky.blue.business.logon.entity.ModuleRoleLink;
import com.sky.blue.business.logon.entity.Role;


public interface IRoleDao {
	public List<Role> qryRoleList(Role role) throws Exception;
	public int addRole(Role role) throws Exception;
	public int deleteRole(Role role) throws Exception;
	public int updateRole(Role role) throws Exception;
	public int deleteRoleModuleLink(Role role) throws Exception;
	public int addRoleModuleLink(ModuleRoleLink moduleRolelink) throws Exception;
}
