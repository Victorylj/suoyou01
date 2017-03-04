package com.sky.blue.business.cpfeeplan.dao;

import java.util.List;

import com.sky.blue.business.cpfeeplan.entity.CpFeeplan;


public interface ICpFeeplanDao {
	public List<CpFeeplan> qryCpFeeplanList(CpFeeplan cpFeeplan) throws Exception;
	public int addCpFeeplan(CpFeeplan cpFeeplan) throws Exception;
	public int deleteCpFeeplan(CpFeeplan cpFeeplan) throws Exception;
	public int updateCpFeeplan(CpFeeplan cpFeeplan) throws Exception;
}
