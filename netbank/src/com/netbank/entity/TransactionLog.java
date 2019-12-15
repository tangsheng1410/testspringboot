package com.netbank.entity;

/**
 * TransactionLog entity. @author MyEclipse Persistence Tools
 */

public class TransactionLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private TransactionType transactionType;
	private Account account;
	private Integer otherid;
	private Double trMoney;
	private String datetime;

	// Constructors

	/** default constructor */
	public TransactionLog() {
	}

	/** full constructor */
	public TransactionLog(TransactionType transactionType, Account account,
			Integer otherid, Double trMoney, String datetime) {
		this.transactionType = transactionType;
		this.account = account;
		this.otherid = otherid;
		this.trMoney = trMoney;
		this.datetime = datetime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Integer getOtherid() {
		return this.otherid;
	}

	public void setOtherid(Integer otherid) {
		this.otherid = otherid;
	}

	public Double getTrMoney() {
		return this.trMoney;
	}

	public void setTrMoney(Double trMoney) {
		this.trMoney = trMoney;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}