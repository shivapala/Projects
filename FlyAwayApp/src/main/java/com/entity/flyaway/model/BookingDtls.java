package com.entity.flyaway.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking_dtls")
public class BookingDtls implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Booking_Id")
	Integer Booking_Id;
	
	@Column(name="Flight_Id")
	Integer Flight_Id;
	@Column(name="Total_Tickets")
	Integer Total_Tickets;
	@Column(name="Adult")
	Integer Adult;
	@Column(name="Child")
	Integer Child;
	@Column(name="NewlyBorn")
	Integer NewlyBorn;
	@Column(name="Notes")
	String Notes;
	@Column(name="crtd_dt")
	LocalDate crtd_dt ;
	public Integer getBooking_Id() {
		return Booking_Id;
	}
	public void setBooking_Id(Integer booking_Id) {
		Booking_Id = booking_Id;
	}
	public Integer getFlight_Id() {
		return Flight_Id;
	}
	public void setFlight_Id(Integer flight_Id) {
		Flight_Id = flight_Id;
	}
	public Integer getTotal_Tickets() {
		return Total_Tickets;
	}
	public void setTotal_Tickets(Integer total_Tickets) {
		Total_Tickets = total_Tickets;
	}
	public Integer getAdult() {
		return Adult;
	}
	public void setAdult(Integer adult) {
		Adult = adult;
	}
	public Integer getChild() {
		return Child;
	}
	public void setChild(Integer child) {
		Child = child;
	}
	public Integer getNewlyBorn() {
		return NewlyBorn;
	}
	public void setNewlyBorn(Integer newlyBorn) {
		NewlyBorn = newlyBorn;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public LocalDate getCrtd_dt() {
		return crtd_dt;
	}
	public void setCrtd_dt(LocalDate crtd_dt) {
		this.crtd_dt = crtd_dt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
