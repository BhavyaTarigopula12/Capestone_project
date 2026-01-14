package com.ey.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RouteStop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stopId;
	
	private int routeId;
	private String stopName;
	private int sequencrNumber;
	LocalTime pickupTime;
	private double distanceFromStart;
	
	public RouteStop(int stopId, int routeId, String stopName, int sequencrNumber, LocalTime pickupTime,
			double distanceFromStart) {
		super();
		this.stopId = stopId;
		this.routeId = routeId;
		this.stopName = stopName;
		this.sequencrNumber = sequencrNumber;
		this.pickupTime = pickupTime;
		this.distanceFromStart = distanceFromStart;
	}
	
	public int getStopId() {
		return stopId;
	}
	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getStopName() {
		return stopName;
	}
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
	public int getSequencrNumber() {
		return sequencrNumber;
	}
	public void setSequencrNumber(int sequencrNumber) {
		this.sequencrNumber = sequencrNumber;
	}
	public LocalTime getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(LocalTime pickupTime) {
		this.pickupTime = pickupTime;
	}
	public double getDistanceFromStart() {
		return distanceFromStart;
	}
	public void setDistanceFromStart(double distanceFromStart) {
		this.distanceFromStart = distanceFromStart;
	}
	@Override
	public String toString() {
		return "RouteStop [stopId=" + stopId + ", routeId=" + routeId + ", stopName=" + stopName + ", sequencrNumber="
				+ sequencrNumber + ", pickupTime=" + pickupTime + ", distanceFromStart=" + distanceFromStart + "]";
	}

}
