package com.netbank.action;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.netbank.biz.UserBiz;
import com.netbank.entity.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements RequestAware,SessionAware {
	//����ͨ��@Resourceע��ע�������userBiz����ʡ��set����
	@Resource private UserBiz userBiz;
	Map<String, Object> request;
	Map<String, Object> session;
	//����Account���Ͷ������ڷ�װ��¼������
	private Account account;
	private Personinfo personinfo;
	private Password pwd;
	
	public String logout(){
		   
		return "login";
	}
	

	/**
	 * ִ��ҳ��ͻ���¼����
	 * @return
	 */
	public String login(){
		//���ݹ�����ϵ�����˻������л�ȡ������Ϣ����
		personinfo=(Personinfo) account.getPersoninfos().iterator().next();
		//���˻��������session
		session.put("user", account);
		//�����˻�������Ϣ�������session
		session.put("personinfo",personinfo);
		//ҳ��ת��
		return "success";
	}
	
	/**
	 * ִ���޸���������
	 * @return
	 */
	public String changepwd(){
			account.setPassword(pwd.getNewpwd());
			if(userBiz.modifyAccount(account)){
				session.put("user", account);
				request.put("message", "�����޸ĳɹ���");
				return "message";
			}
			request.put("message", "�����޸�ʧ�ܣ�");
			return "message";
		
	}
	
	/**
	 * �޸�����ҳ����֤
	 */
	public void validateChangepwd(){
		account=(Account) session.get("user");
		if(!pwd.getOldpwd().equals(account.getPassword())){
			this.addFieldError("pwd.oldpwd", "���벻��ȷ");
		}
		if(!pwd.getNewpwd().equals(pwd.getConfirmpwd())){
			this.addFieldError("pwd.confirmpwd", "�������벻һ��");
		}
	}
	
	/**
	 * ��¼��У�飬��ʵ�ָ����û�����ȡ�˻�����
	 */
	public void validateLogin(){
		Account a = userBiz.getAccount(account.getUsername());
		if(a==null){
			this.addFieldError("username", "�û���������");
		}else{
			if(!account.getPassword().equals(a.getPassword())){
				this.addFieldError("password", "���벻��ȷ");
			}
		}
		account=a;		
	}

	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Password getPwd() {
		return pwd;
	}

	public void setPwd(Password pwd) {
		this.pwd = pwd;
	}

	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
