package com.ey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int route_id;
	private String from;
	private String to;
	private double distance;
	private double farePricePerKm;
	
	public Route(int route_id, String from, String to, double distance, double farePricePerKm) {
		super();
		this.route_id = route_id;
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.farePricePerKm = farePricePerKm;
	}
	
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getFarePricePerKm() {
		return farePricePerKm;
	}
	public void setFarePricePerKm(double farePricePerKm) {
		this.farePricePerKm = farePricePerKm;
	}
	@Override
	public String toString() {
		return "Route [route_id=" + route_id + ", from=" + from + ", to=" + to + ", distance=" + distance
				+ ", farePricePerKm=" + farePricePerKm + "]";
	}

}
