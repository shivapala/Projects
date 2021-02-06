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
@Table(name="locations")
public class Locations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(name="id")
	Integer id;
@Column(name="Location_NM")
	String locName;
@Column(name="code_nm")
	String codeNM;
@Column(name="created")
	LocalDate created;
@Column(name="country")
String country;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getLocName() {
	return locName;
}
public void setLocName(String locName) {
	this.locName = locName;
}
public String getCodeNM() {
	return codeNM;
}
public void setCodeNM(String codeNM) {
	this.codeNM = codeNM;
}
public LocalDate getCreated() {
	return created;
}
public void setCreated(LocalDate created) {
	this.created = created;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
}
