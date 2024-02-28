package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql="UPDATE bankaccount set status='closed' where accno=?")
@Where(clause="status not in ('closed','blocked')")
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer accNo;
	private String holderName;
	private Float balance;
	private String status;
	
	static {
		System.out.println("Bank Account .class file is loading...");
	}
	
	public BankAccount() {
		System.out.println("Bank Account Object is Created...");
	}
	
	public Integer getAccNo() {
		return accNo;
	}


	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}


	public String getHolderName() {
		return holderName;
	}


	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}


	public Float getBalance() {
		return balance;
	}


	public void setBalance(Float balance) {
		this.balance = balance;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}

}
