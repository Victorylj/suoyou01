package com.sky.blue.business.spmanager.service;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SpInterfaceParam;

public interface ISpInterfaceParamService {
	public List<SpInterfaceParam> qryCpInterfaceParamList(SpInterfaceParam spInterfaceParam) throws Exception;
	public int addSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception;
	public int deleteSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception;
}
