package com.sky.blue.business.cpfeeplan.service;

import java.util.List;

import com.sky.blue.business.cpfeeplan.entity.CpFeeplan;


public interface ICpFeeplanService {
	public List<CpFeeplan> qryCpFeeplanList(CpFeeplan cpFeeplan) throws Exception;
	public int addCpFeeplan(CpFeeplan cpFeeplan) throws Exception;
	public int deleteCpFeeplan(CpFeeplan cpFeeplan) throws Exception;
}
