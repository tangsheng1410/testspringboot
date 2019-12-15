package com.netbank.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Status entity. @author MyEclipse Persistence Tools
 */

public class Status implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set accounts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Status() {
	}

	/** full constructor */
	public Status(String name, Set accounts) {
		this.name = name;
		this.accounts = accounts;
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

	public Set getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set accounts) {
		this.accounts = accounts;
	}

}