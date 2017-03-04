package com.sky.blue.business.spmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.spmanager.dao.IVideoResourceDao;
import com.sky.blue.business.spmanager.entity.VideoResource;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("videoResourceDao")
public class VideoResourceDaoImpl extends BasicSqlSupport  implements IVideoResourceDao {

	@Override
	public List<VideoResource> qryCpCommandList(VideoResource videoResource)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listVideoResource", videoResource);
	}

	@Override
	public int addVideoResource(VideoResource videoResource) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(videoResource);
		
		return session.insert("mybatis.mapper.Bussiness.addVideoResource", videoResource);
	}

	@Override
	public int deleteVideoResource(VideoResource videoResource) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = videoResource.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteVideoResource", ids);
	}

	@Override
	public int updateVideoResource(VideoResource videoResource) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateVideoResource", videoResource);
	}

}
