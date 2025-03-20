package com.clinic.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
public class Visit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    
    private LocalDateTime visitDate;
    private String reason;
    private double fee;
	public Visit(Long id, Pet pet, LocalDateTime visitDate, String reason, double fee) {
		super();
		this.id = id;
		this.pet = pet;
		this.visitDate = visitDate;
		this.reason = reason;
		this.fee = fee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public LocalDateTime getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(LocalDateTime visitDate) {
		this.visitDate = visitDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Visit [id=" + id + ", pet=" + pet + ", visitDate=" + visitDate + ", reason=" + reason + ", fee=" + fee
				+ "]";
	}
}

