package com.sky.blue.business.spmanager.service;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SpCommand;

public interface ISpCommandService {
	public List<SpCommand> qryCpCommandList(SpCommand spCommand) throws Exception;
	public int addSpCommand(SpCommand spCommand) throws Exception;
	public int closeOrOpenSpCommand(SpCommand spCommand) throws Exception;
	public int updSpCommandPositiveStatu(SpCommand spCommand) throws Exception;
	public List<SpCommand> getSpCommandId(SpCommand spCommand) throws Exception;
	public List<SpCommand> getSpCommandIdBySpid(SpCommand spCommand) throws Exception;
	public List<SpCommand> listSpCommand(SpCommand spCommand) throws Exception;
}
