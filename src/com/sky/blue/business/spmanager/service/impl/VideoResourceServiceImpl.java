package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.spmanager.dao.IVideoResourceDao;
import com.sky.blue.business.spmanager.entity.VideoResource;
import com.sky.blue.business.spmanager.service.IVideoResourceService;
@Service("videoResourceServiceImpl")
public class VideoResourceServiceImpl  implements IVideoResourceService {
	@Autowired
	private IVideoResourceDao videoResourceDao;
	@Override
	public List<VideoResource> qryCpCommandList(VideoResource videoResource)
			throws Exception {
		// TODO Auto-generated method stub
		return videoResourceDao.qryCpCommandList(videoResource);
	}

	@Override
	public int addVideoResource(VideoResource videoResource) throws Exception {
		// TODO Auto-generated method stub
		if(videoResource.getId()!=null){
			return videoResourceDao.updateVideoResource(videoResource);
		}
		return videoResourceDao.addVideoResource(videoResource);
	}

	@Override
	public int deleteVideoResource(VideoResource videoResource) throws Exception {
		// TODO Auto-generated method stub
		return videoResourceDao.deleteVideoResource(videoResource);
	}

}
