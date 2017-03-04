package com.sky.blue.business.spmanager.service;

import java.util.List;

import com.sky.blue.business.spmanager.entity.FilterSpCom;

public interface IFilterSpComService {
	public List<FilterSpCom> getFilterSpCom(FilterSpCom f);
	public int delFilterSpCom(FilterSpCom f);
	public int addFilterSpCom(FilterSpCom f);
	public int updFilterSpCom(FilterSpCom f);
	public int updFilterSpComById(FilterSpCom f);
}
