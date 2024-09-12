package com.javawhizz.App.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Bank_details")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq",initialValue = 1000)
	private long acc_num;
	@Column(name="account_holder_name")
	private String acc_holder;
	@Column(name="account_balance")
	private Double acc_bal;
	
	public Account() {
		
	}
	
	public Account(String acc_holder, Double acc_bal) {
		super();
		this.acc_holder = acc_holder;
		this.acc_bal = acc_bal;
	}
	
	public long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(long acc_num) {
		this.acc_num = acc_num;
	}
	public String getAcc_holder() {
		return acc_holder;
	}
	public void setAcc_holder(String acc_holder) {
		this.acc_holder = acc_holder;
	}
	public Double getAcc_bal() {
		return acc_bal;
	}
	public void setAcc_bal(Double acc_bal) {
		this.acc_bal = acc_bal;
	}
	
	
}
