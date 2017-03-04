package com.sky.blue.business.logon.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;






import com.sky.blue.business.logon.dao.IModuleDao;
import com.sky.blue.business.logon.entity.Module;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("moduleDao")
public class ModuleDaoImpl extends BasicSqlSupport  implements IModuleDao {

	@Override
	public List<Module> qryModuleList(Module module)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listModule", module);
	}

	@Override
	public int addModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(module);
		
		return session.insert("mybatis.mapper.Bussiness.addModule", module);
	}

	@Override
	public int deleteModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = module.getArrayIds();
//		String[] ids=null;
//		if(arrIds!=null&&!"".equals(arrIds)){
//			 ids = arrIds.split(",");
//		}
//		if(ids==null){
//			return -1;
//		}
		return session.delete("mybatis.mapper.Bussiness.deleteModule", arrIds);
	}

	@Override
	public int updateModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateModule", module);
	}

	@Override
	public List<Module> getUserModuleList(User user) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getUserModules", user);

	}

	@Override
	public Module getModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("mybatis.mapper.Bussiness.getModule", module);
	}

}
