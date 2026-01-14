package com.ey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentId;
	private Long bookingId;
	private double amount;
	private double currency;
	private String method;
	private String status;
	
	public Payment(Long paymentId, Long bookingId, double amount, double currency, String method, String status) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.amount = amount;
		this.currency = currency;
		this.method = method;
		this.status = status;
	}
	
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getCurrency() {
		return currency;
	}
	public void setCurrency(double currency) {
		this.currency = currency;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", bookingId=" + bookingId + ", amount=" + amount + ", currency="
				+ currency + ", method=" + method + ", status=" + status + "]";
	}
}
