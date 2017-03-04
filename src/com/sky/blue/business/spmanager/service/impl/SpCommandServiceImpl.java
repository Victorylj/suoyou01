package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.spmanager.dao.ICpMakefeeItemDao;
import com.sky.blue.business.spmanager.dao.ISpCommandDao;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.entity.SpCommand;
import com.sky.blue.business.spmanager.service.ISpCommandService;
@Service("spCommandServiceImpl")
public class SpCommandServiceImpl  implements ISpCommandService {
	@Autowired
	private ISpCommandDao spCommandDao;
	@Autowired
	private ICpMakefeeItemDao cpMakefeeItemDao;
	@Override
	public List<SpCommand> qryCpCommandList(SpCommand spCommand)
			throws Exception {
		// TODO Auto-generated method stub
		return spCommandDao.qryCpCommandList(spCommand);
	}
	
	@Override
	public List<SpCommand> listSpCommand(SpCommand spCommand)
			throws Exception {
		// TODO Auto-generated method stub
		return spCommandDao.listSpCommand(spCommand);
	}
	
	
	@Override
	public List<SpCommand> getSpCommandId(SpCommand spCommand)
			throws Exception {
		// TODO Auto-generated method stub
		return spCommandDao.getSpCommandId(spCommand);
	}

	@Override
	public int addSpCommand(SpCommand spCommand) throws Exception {
		// TODO Auto-generated method stub
		if(spCommand.getCommand_id()!=null){
			return spCommandDao.updateSpCommand(spCommand);
		}
		return spCommandDao.addSpCommand(spCommand);
	}

	@Override
	public int closeOrOpenSpCommand(SpCommand spCommand) throws Exception {
		// TODO Auto-generated method stub
		spCommandDao.closeOrOpenSpCommand(spCommand);
		//cpMakefeeItemDao.closeOrOpenCpMakefeeItemByCommandId(spCommand);
		return 0;
	}
	@Override
	public int updSpCommandPositiveStatu(SpCommand spCommand) throws Exception{
		return spCommandDao.updSpCommandPositiveStatu(spCommand);
	}

	@Override
	public List<SpCommand> getSpCommandIdBySpid(SpCommand spCommand)
			throws Exception {
		return spCommandDao.getSpCommandIdBySpid(spCommand);
	}
}
