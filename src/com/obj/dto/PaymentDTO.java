package com.obj.dto;

import java.util.UUID;

public class PaymentDTO {
	// Atributos
    private int clientId;
    private UUID invoiceNumber;
    private String paymentMethod;
    private double total;
    
    // Métodos getter and setter
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public UUID getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(UUID invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
