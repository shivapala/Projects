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
@Table(name="airlines")
public class AirLines implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	@Column(name="AirLines_NM")
	String airLineName;
	@Column(name="Flight_cnt")
	Integer flght_cnt;
	@Column(name="created")
	LocalDate crtd_dt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAirLineName() {
		return airLineName;
	}
	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}
	public Integer getFlght_cnt() {
		return flght_cnt;
	}
	public void setFlght_cnt(Integer flght_cnt) {
		this.flght_cnt = flght_cnt;
	}
	public LocalDate getCrtd_dt() {
		return crtd_dt;
	}
	public void setCrtd_dt(LocalDate crtd_dt) {
		this.crtd_dt = crtd_dt;
	}

}
