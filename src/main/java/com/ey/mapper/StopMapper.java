package com.ey.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ey.dto.request.AddStopsRequest;
import com.ey.dto.request.StopDto;
import com.ey.model.RouteStop;

public class StopMapper {	
	public static RouteStop toEntity(StopDto dto, Long routeId) {
		return new RouteStop(
				dto.getStopId(),
				routeId, 
				dto.getStopName(),
				dto.getSequenceNumber(),
				dto.getPickupTime(),
				dto.getDistanceFromStart()
				);
	}
	public static List<RouteStop> toEntities(AddStopsRequest req, Long routeId){
		List<RouteStop>list=new ArrayList<>();
		if(req==null || req.getStops()==null) 
			return list;
		for(StopDto dto: req.getStops()) {
			list.add(toEntity(dto,routeId));
		}
		return list;
	}
	
}
