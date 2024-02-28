package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BankAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accNo;
	private String holderName;
	private double balance;
	private String type;
	@CreationTimestamp
	private LocalDateTime openingDate;
	@UpdateTimestamp
	private LocalDate lastUpdated;
	
	@Version
	private Integer count;
	
	static {
		System.out.println("Bank Account .class file is loading...");
	}
	
	public BankAccount() {
		System.out.println("Bank Account object has been created...");
	}
	public long getAccNo() {
		return accNo;
	}


	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}


	public String getHolderName() {
		return holderName;
	}


	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public LocalDateTime getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}


	public LocalDate getLastUpdated() {
		return lastUpdated;
	}


	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + ", type=" + type
				+ ", openingDate=" + openingDate + ", lastUpdated=" + lastUpdated + ", count=" + count + "]";
	}
	
	

}
