package com.netbank.entity;

/**
 * Personinfo entity. @author MyEclipse Persistence Tools
 */

public class Personinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Account account;
	private String realname;
	private Integer age;
	private String sex;
	private Long cardid;
	private String address;
	private String telephone;

	// Constructors

	/** default constructor */
	public Personinfo() {
	}

	/** full constructor */
	public Personinfo(Account account, String realname, Integer age,
			String sex, Long cardid, String address, String telephone) {
		this.account = account;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.cardid = cardid;
		this.address = address;
		this.telephone = telephone;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getCardid() {
		return this.cardid;
	}

	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}