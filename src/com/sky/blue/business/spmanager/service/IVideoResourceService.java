package com.sky.blue.business.spmanager.service;

import java.util.List;

import com.sky.blue.business.spmanager.entity.VideoResource;

public interface IVideoResourceService {
	public List<VideoResource> qryCpCommandList(VideoResource videoResource) throws Exception;
	public int addVideoResource(VideoResource videoResource) throws Exception;
	public int deleteVideoResource(VideoResource videoResource) throws Exception;
}
