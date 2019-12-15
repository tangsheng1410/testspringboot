package com.netbank.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;


import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class FileAction extends ActionSupport implements RequestAware,
		SessionAware{
	private Map<String, Object> request;
	private Map<String, Object> session;
	private String result;
	
	public String getResult() {
		return result;
	}


	String realPath=ServletActionContext.getServletContext().getRealPath("/upload");
	String contextPath=ServletActionContext.getServletContext().getContextPath();
	String contextName=ServletActionContext.getServletContext().getServletContextName();
	
	private File image;
	private String imageFileName;
	private Date date;
	
	
	public String addImages()throws IOException{
		if(image!=null){
		File file=new File(realPath);
		if(!file.exists())
			file.mkdirs();
		FileUtils.copyFile(image, new File(file,imageFileName));
		request.put("message", "文件上传成功!<br><a href='upload.jsp'  title='继续上传'>[继续上传]</a>");
		return "message";
		}
		request.put("message", "您没有上传文件!<br><a href='javascript: history.go(-1)' >[返回]</a>");
		//result="../upload.jsp";
		return "message";
	}


	public File getImage()  {
		
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public void setRequest(Map<String, Object> request) {
		this.request=request;

	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}


	public String getContextName() {
		return contextName;
	}


	public String getContextPath() {
		return contextPath;
	}


	public String getRealPath() {
		return realPath;
	}

}
