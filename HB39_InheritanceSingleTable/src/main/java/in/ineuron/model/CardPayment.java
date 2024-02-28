package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CARD_PAYMENT")
public class CardPayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long cardNo;
	private String cardType;
	private String paymentGateway;
	
	
	
	public Long getCardNo() {
		return cardNo;
	}



	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}



	public String getCardType() {
		return cardType;
	}



	public void setCardType(String cardType) {
		this.cardType = cardType;
	}



	public String getPaymentGateway() {
		return paymentGateway;
	}



	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "CardType [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateway=" + paymentGateway + "]";
	}
	
	
}