package com.sky.blue.comm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Vector;

import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * @author sjm
 */
public class MySFTP {

	/**
	 * 连接sftp服务器
	 * 
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	public ChannelSftp connect(String host, int port, String username,
			String password) {
		ChannelSftp sftp = null;
		try {
			JSch jsch = new JSch();
			jsch.getSession(username, host, port);
			Session sshSession = jsch.getSession(username, host, port);
			System.out.println("Session created.");
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			System.out.println("Session connected.");
			System.out.println("Opening Channel.");
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			System.out.println("Connected to " + host + ".");
		} catch (Exception e) {

		}
		return sftp;
	}

	/**
	 * 上传文件
	 * 
	 * @param directory
	 *            上传的目录
	 * @param uploadFile
	 *            要上传的文件
	 * @param sftp
	 */
	public void upload(String directory, String uploadFile, ChannelSftp sftp) {
		try {
			sftp.cd(directory);
			File file = new File(uploadFile);
			sftp.put(new FileInputStream(file), file.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upload(String directory, String uploadFile, ChannelSftp sftp, String newName) {
		try {
			sftp.cd(directory);
			File file = new File(uploadFile);
			sftp.put(new FileInputStream(file), newName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int upload(String directory, MultipartFile mf, ChannelSftp sftp, String newName) {
		try {
			sftp.cd(directory);
			sftp.put(mf.getInputStream(), newName);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param directory
	 *            下载目录
	 * @param downloadFile
	 *            下载的文件
	 * @param saveFile
	 *            存在本地的路径
	 * @param sftp
	 */
	public int download(String directory, String downloadFile,
			String saveFile, ChannelSftp sftp) {
		try {
			sftp.cd(directory);
			File file = new File(saveFile);
			sftp.get(downloadFile, new FileOutputStream(file));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param directory
	 *            要删除文件所在目录
	 * @param deleteFile
	 *            要删除的文件
	 * @param sftp
	 */
	public int delete(String directory, String deleteFile, ChannelSftp sftp) {
		try {
			sftp.cd(directory);
			sftp.rm(deleteFile);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 列出目录下的文件
	 * 
	 * @param directory
	 * 要列出的目录
	 * @param sftp
	 * @return
	 * @throws SftpException
	 */
	public Vector listFiles(String directory, ChannelSftp sftp)
			throws SftpException {
		return sftp.ls(directory);
	}

	public static void disconnect(ChannelSftp sftp) {
		if (sftp != null) {
			Session session = sftp.getSession();
			if (sftp.isConnected()) {
				sftp.disconnect();
				System.out.println("sftp close" + sftp);
			} else if (sftp.isClosed()) {
			}
			if (session != null && session.isConnected()) {
				session.disconnect();
			}
			System.out.println("sftp close");
		}
		
	}

	public boolean isConnected(ChannelSftp sftp) {
		return (sftp != null) && sftp.isConnected() && !sftp.isClosed()
				&& (sftp.getSession() != null) && sftp.getSession().isConnected();
	}
	
	public static int up(FtpParamBean f){
		int port = 22;
		MySFTP sf = new MySFTP();
		ChannelSftp sftp = sf.connect(f.getIp(), port, f.getUserName(), f.getPassword());
		return sf.upload(f.getPath(), f.getFile(), sftp, f.getFilename());
	}
	
	public static int down(FtpParamBean f){
		int port = 22;
		MySFTP sf = new MySFTP();
		ChannelSftp sftp = sf.connect(f.getIp(), port, f.getUserName(), f.getPassword());
		return sf.download(f.getPath(), f.getFilename(), f.getUrl(), sftp);
	}
	
	public static int del(FtpParamBean f){
		int port = 22;
		MySFTP sf = new MySFTP();
		ChannelSftp sftp = sf.connect(f.getIp(), port, f.getUserName(), f.getPassword());
		return sf.delete(f.getPath(), f.getFilename(), sftp);
	}
	

	public static void main1(String[] args) {
		ChannelSftp sftp = null;
		try {
			MySFTP sf = new MySFTP();
			String host = "120.25.151.94";
			int port = 22;
			String username = "root";
			String password = "ym!@#$56";
			String directory = "/usr/apache-tomcat-7.0.62/webapps/download/apkfile";
			String uploadFile = "F:\\tupian\\bb.txt";
			String downloadFile = "bb.txt";
			String saveFile = "F:\\tupian\\download.txt";
			// String deleteFile = "delete.txt";
			sftp = sf.connect(host, port, username, password);
			// sf.upload(directory, uploadFile, sftp);
			// sf.download("/home/test/", downloadFile, saveFile, sftp);
			// sf.delete(directory, deleteFile, sftp);
			// sftp.cd(directory);
			// sftp.mkdir("test");
			sf.listFiles(directory, sftp);
			System.out.println("finished");

			sf.disconnect(sftp);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != sftp) {
				sftp.isClosed();

			}
			// sftp.exit();
			// sftp.quit();
		}
	}

	public static void main(String[] args) {
		MySFTP sf = new MySFTP();
		String host = "120.25.151.94";
		int port = 22;
		String username = "root";
		String password = "ym!@#$56";
		String directory = "/usr/apache-tomcat-7.0.62/webapps/download/apkfile";
		String uploadFile = "f:\\sjm.txt";
		//String downloadFile = "upload.txt";
		//String saveFile = "D:\\tmp\\download.txt";
		//String deleteFile = "delete.txt";
		ChannelSftp sftp = sf.connect(host, port, username, password);
		//sf.upload(directory, uploadFile, sftp);
		sf.delete(directory, "YM_0.1.0.0.dll", sftp);
	//	sf.download(directory, downloadFile, saveFile, sftp);
	//	sf.delete(directory, deleteFile, sftp);
		try {
			//sftp.cd(directory);
			//sftp.mkdir("test");
			System.out.println("finished");
		
			sftp.getSession().disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
