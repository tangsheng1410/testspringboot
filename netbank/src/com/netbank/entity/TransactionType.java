package com.netbank.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TransactionType entity. @author MyEclipse Persistence Tools
 */

public class TransactionType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set transactionLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TransactionType() {
	}

	/** full constructor */
	public TransactionType(String name, Set transactionLogs) {
		this.name = name;
		this.transactionLogs = transactionLogs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTransactionLogs() {
		return this.transactionLogs;
	}

	public void setTransactionLogs(Set transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

}