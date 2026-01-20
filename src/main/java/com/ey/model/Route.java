package com.ey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long routeId;
	private String fromLocation;
	private String toLocation;
	private double distance;
	private double farePricePerKm;


	public Route() {
		super();
	}

	public Route(Long routeId, String fromLocation, String toLocation, double distance, double farePricePerKm) {
		super();
		this.routeId = routeId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.distance = distance;
		this.farePricePerKm = farePricePerKm;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
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
		return "Route [routeId=" + routeId + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation
				+ ", distance=" + distance + ", farePricePerKm=" + farePricePerKm + "]";
	}

}
