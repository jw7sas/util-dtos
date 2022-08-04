package com.obj.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
	// Atributos
    private int id;
    private LocalDateTime receivedDate;
    private LocalDateTime deliveryDeadline;
    private LocalDateTime deliveryDate;
    private String observation;
    private String state;
    private int clientId;
    private List<OrderDetailDTO> details;
    
    // Métodos getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(LocalDateTime receivedDate) {
		this.receivedDate = receivedDate;
	}
	public LocalDateTime getDeliveryDeadline() {
		return deliveryDeadline;
	}
	public void setDeliveryDeadline(LocalDateTime deliveryDeadline) {
		this.deliveryDeadline = deliveryDeadline;
	}
	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public List<OrderDetailDTO> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetailDTO> details) {
		this.details = details;
	}
}
