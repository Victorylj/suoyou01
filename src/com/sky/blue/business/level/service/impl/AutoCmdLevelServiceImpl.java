package com.sky.blue.business.level.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.level.dao.IAutoCmdLevelDao;
import com.sky.blue.business.level.entity.AutoCmdLevel;
import com.sky.blue.business.level.service.IAutoCmdLevelService;
@Service("autoCmdLevelServiceImpl")
public class AutoCmdLevelServiceImpl implements IAutoCmdLevelService {
	@Autowired
	private IAutoCmdLevelDao autoCmdLevelDao;
	@Override
	public List<AutoCmdLevel> qryAutoCmdLevelList(AutoCmdLevel autoCmdLevel)
			throws Exception {
		return autoCmdLevelDao.qryAutoCmdLevelList(autoCmdLevel);
	}

	@Override
	public int addAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception {
		//如果id不为空执行更新操作
		if(autoCmdLevel.getId()!=null){
			return autoCmdLevelDao.updateAutoCmdLevel(autoCmdLevel);
		}
		autoCmdLevel.setCall_num(new Integer(0));
		return autoCmdLevelDao.addAutoCmdLevel(autoCmdLevel);
	}

	@Override
	public int updateAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception {
		return autoCmdLevelDao.updateAutoCmdLevel(autoCmdLevel);
	}

	@Override
	public int closeOrOpenAutoCmdLevel(AutoCmdLevel autoCmdLevel)
			throws Exception {
		// TODO Auto-generated method stub
		return autoCmdLevelDao.closeOrOpenAutoCmdLevel(autoCmdLevel);
	}

	@Override
	public int deleteAutoCmdLevel(AutoCmdLevel autoCmdLevel) throws Exception {
		// TODO Auto-generated method stub
		return autoCmdLevelDao.deleteAutoCmdLevel(autoCmdLevel);
	}

}
