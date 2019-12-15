package com.netbank.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer accountid;
	private Status status;
	private String username;
	private String password;
	private Double balance;
	private Set transactionLogs = new HashSet(0);
	private Set personinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(Status status, String username, String password,
			Double balance, Set transactionLogs, Set personinfos) {
		this.status = status;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.transactionLogs = transactionLogs;
		this.personinfos = personinfos;
	}

	// Property accessors

	public Integer getAccountid() {
		return this.accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Set getTransactionLogs() {
		return this.transactionLogs;
	}

	public void setTransactionLogs(Set transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

	public Set getPersoninfos() {
		return this.personinfos;
	}

	public void setPersoninfos(Set personinfos) {
		this.personinfos = personinfos;
	}

}