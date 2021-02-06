package com.entity.flyaway.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flightlist")
public class AirFlights implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Flight_Id")
	Integer flight_Id;
	@Column(name="FlghtNbr")
	String flightNbr;
	@Column(name="Src_id",insertable = false, updatable = false)
	Integer srcId;
	@Column(name="Dest_id", insertable = false, updatable = false)
	Integer destId;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="Air_Id")
	AirLines airLine;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="Src_id")
	Locations source;
	@Column(name="Occupancy")
	Integer Occupancy;
	@Column(name="Flight_Typ")
	String Flight_Typ;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="Dest_id")
	Locations dest;
	@Column(name="price")
	Double Price;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Flight_Id")
	Availablity avail;
	
	

	public Integer getFlight_Id() {
		return flight_Id;
	}
	public void setFlight_Id(Integer flight_Id) {
		this.flight_Id = flight_Id;
	}
	public String getFlightNbr() {
		return flightNbr;
	}
	public void setFlightNbr(String flightNbr) {
		this.flightNbr = flightNbr;
	}
	public AirLines getAirLine() {
		return airLine;
	}
	public void setAirLine(AirLines airLine) {
		this.airLine = airLine;
	}
	public Locations getSource() {
		return source;
	}
	public void setSource(Locations source) {
		this.source = source;
	}
	public Integer getOccupancy() {
		return Occupancy;
	}
	public void setOccupancy(Integer occupancy) {
		Occupancy = occupancy;
	}
	public String getFlight_Typ() {
		return Flight_Typ;
	}
	public void setFlight_Typ(String flight_Typ) {
		Flight_Typ = flight_Typ;
	}
	public Locations getDest() {
		return dest;
	}
	public void setDest(Locations dest) {
		this.dest = dest;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public Availablity getAvail() {
		return avail;
	}
	public void setAvail(Availablity avail) {
		this.avail = avail;
	}

}
