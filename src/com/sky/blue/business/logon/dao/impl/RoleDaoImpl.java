package com.sky.blue.business.logon.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;





import com.sky.blue.business.logon.dao.IRoleDao;
import com.sky.blue.business.logon.entity.ModuleRoleLink;
import com.sky.blue.business.logon.entity.Role;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("roleDao")
public class RoleDaoImpl extends BasicSqlSupport  implements IRoleDao {

	@Override
	public List<Role> qryRoleList(Role role)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listRole", role);
	}

	@Override
	public int addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(role);
		
		return session.insert("mybatis.mapper.Bussiness.addRole", role);
	}

	@Override
	public int deleteRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = role.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteRole", role);
	}

	@Override
	public int updateRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateRole", role);
	}

	@Override
	public int deleteRoleModuleLink(Role role) throws Exception {
		// TODO Auto-generated method stub
		return session.delete("mybatis.mapper.Bussiness.deleteRoleModuleLink", role);
	}

	@Override
	public int addRoleModuleLink(ModuleRoleLink moduleRolelink)
			throws Exception {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addRoleModuleLink", moduleRolelink);
	}

}
