package com.ey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	private Long bookingId;
	private double amount;
    @ManyToOne
    private Employee employee;
	private String currency;
	private String method;
	private String status;

	public Payment() {
		super();
	}

	public Payment(Long paymentId, Long bookingId, double amount,Employee employee, String currency, String method, String status) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.amount = amount;
		this.employee=employee;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
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
				+ currency + ", employee" + employee+", method=" + method + ", status=" + status + "]";
	}
}
