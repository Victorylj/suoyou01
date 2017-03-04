package com.sky.blue.business.stat.dao;

import java.util.List;

import com.sky.blue.business.stat.entity.RecCallAllDate;

public interface IRecCallAllDateDao {
	public List<RecCallAllDate> listCallAllDate(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> listRecDate(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> listInitDate(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> listRecCallAllDate(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> listRecCallAllDatehis(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> exportListRecCallAllDate(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> exportListRecCallAllDatehis(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> listrecalldate(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> listSumAllDate(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> listCallAllData13(RecCallAllDate r) throws Exception;
	public List<RecCallAllDate> listCallAllDataNo13(RecCallAllDate r) throws Exception;
}
