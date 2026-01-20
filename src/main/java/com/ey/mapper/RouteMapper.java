package com.ey.mapper;

import com.ey.dto.request.CreateRouteRequest;
import com.ey.dto.request.UpdateFareRequest;
import com.ey.dto.response.RouteResponse;
import com.ey.model.Route;

public class RouteMapper {
	public static Route toEntity(CreateRouteRequest req) {
		Route route = new Route(
				null,
				req.getFromLocation(),
				req.getToLocation(),
				req.getDistance(),
				req.getFarePricePerKm()
				);
		return route;
	}
	public static void applyFarePatch(UpdateFareRequest req, Route r) {
		if(req !=null && r!=null) {
			r.setFarePricePerKm(req.getFarePricePerKm());
		}
	}
	public static RouteResponse toResponse(Route route) {
		return new RouteResponse(
				route.getRouteId(),
				route.getFromLocation(),
				route.getToLocation(),
				route.getDistance(),
				route.getFarePricePerKm()
				);
	}
}

