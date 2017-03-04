package com.sky.blue.business.spmanager.dao;

import java.util.List;

import com.sky.blue.business.spmanager.entity.SpInterfaceParam;

public interface ISpInterfaceParamDao {
	public List<SpInterfaceParam> qryCpInterfaceParamList(SpInterfaceParam spInterfaceParam) throws Exception;
	public int addSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception;
	public int deleteSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception;
	public int updateSpInterfaceParam(SpInterfaceParam spInterfaceParam) throws Exception;
}
