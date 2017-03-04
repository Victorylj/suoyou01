package com.sky.blue.business.spmanager.dao;

import java.util.List;

import com.sky.blue.business.spmanager.entity.VideoResource;

public interface IVideoResourceDao {
	public List<VideoResource> qryCpCommandList(VideoResource videoResource) throws Exception;
	public int addVideoResource(VideoResource videoResource) throws Exception;
	public int deleteVideoResource(VideoResource videoResource) throws Exception;
	public int updateVideoResource(VideoResource videoResource) throws Exception;
}
