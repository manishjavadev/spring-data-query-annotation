package com.manish.javadev.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Manish
 *
 */
@Entity
@Table(name = "TBL_ACCOUNT")
@NamedQueries({
		@NamedQuery(name = "AccountEntity.getByAccountType", query = "SELECT a FROM AccountEntity a WHERE LOWER(a.accountType) = LOWER(?1)"),
		@NamedQuery(name = "AccountEntity.getByStartDateBetween", query = "SELECT a FROM AccountEntity a WHERE a.startDate BETWEEN ?1 and ?2)") })
public class AccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "ACCOUNT_HOLDER_NAME")
	private String accountHolderName;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "ACCOUNT_STAR_TDATE")
	private Date startDate;

	public AccountEntity() {
		super();
	}

	public AccountEntity(String accountType, String accountHolderName, Double amount) {
		super();
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.amount = amount;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", amount=" + amount + ", startDate=" + startDate + "]";
	}

}