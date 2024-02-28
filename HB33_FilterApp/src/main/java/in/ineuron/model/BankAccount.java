package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@FilterDef(name="FILTER_NOT_CLOSED_ACCOUNTS",parameters= {
		@ParamDef(type="string",name="accType1"),
		@ParamDef(type="string",name="accType2")
})
@Filter(name="FILTER_NOT_CLOSED_ACCOUNTS",condition="status NOT IN (:accType1,:accType2)")
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
