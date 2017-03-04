package com.sky.blue.business.data.entity;


import org.springframework.web.multipart.MultipartFile;

public class CpApkVersion{
	private Integer id;
	private MultipartFile file;
	private String channel; //渠道
	private String packages; //包名
	private String version; //版本
	private String url; //下载地址
	private String filename; //文件名
	private String updatetime; //更新时间
	private String delname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getDelname() {
		return delname;
	}
	public void setDelname(String delname) {
		this.delname = delname;
	}
}
