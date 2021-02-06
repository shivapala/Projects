package com.entity.flyaway.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Availablity")
public class Availablity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="avl_id")
	Integer avl_id;
	@Column(name="Flight_id")
Integer Flight_id;
	@Column(name="avl_cnt")
	Integer avl_cnt;
	@Column(name="avl_date")
	LocalDate avl_date;
	public Integer getAvl_id() {
		return avl_id;
	}
	public void setAvl_id(Integer avl_id) {
		this.avl_id = avl_id;
	}
	public Integer getFlight_id() {
		return Flight_id;
	}
	public void setFlight_id(Integer flight_id) {
		Flight_id = flight_id;
	}
	public Integer getAvl_cnt() {
		return avl_cnt;
	}
	public void setAvl_cnt(Integer avl_cnt) {
		this.avl_cnt = avl_cnt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public LocalDate getAvl_date() {
		return avl_date;
	}
	public void setAvl_date(LocalDate avl_date) {
		this.avl_date = avl_date;
	}
	

}
