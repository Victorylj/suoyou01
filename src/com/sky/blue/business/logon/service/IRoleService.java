package com.sky.blue.business.logon.service;

import java.util.List;

import com.sky.blue.business.logon.entity.Role;


public interface IRoleService {
	public List<Role> qryRoleList(Role role) throws Exception;
	public int addRole(Role role) throws Exception;
	public int deleteRole(Role role) throws Exception;
}
