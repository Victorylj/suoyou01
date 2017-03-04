package com.sky.blue.business.logon.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;




import com.sky.blue.business.logon.dao.IGroupDao;
import com.sky.blue.business.logon.entity.Group;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("groupDao")
public class GroupDaoImpl extends BasicSqlSupport  implements IGroupDao {

	@Override
	public List<Group> qryGroupList(Group group)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listGroup", group);
	}

	@Override
	public int addGroup(Group group) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(group);
		
		return session.insert("mybatis.mapper.Bussiness.addGroup", group);
	}

	@Override
	public int deleteGroup(Group group) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = group.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteGroup", ids);
	}

	@Override
	public int updateGroup(Group group) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateGroup", group);
	}

}
