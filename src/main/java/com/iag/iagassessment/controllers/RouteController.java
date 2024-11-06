package com.iag.iagassessment.controllers;

import com.iag.iagassessment.AviosPointsCalculator;
import com.iag.iagassessment.entities.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RouteController {
    private Map<String, Double> response = new HashMap<>();

    @GetMapping("/getAviosPoints")
    public ResponseEntity<Map<String, Double>> getAviosPoints(@RequestParam String departureAirportCode, @RequestParam String arrivalAirportCode, @RequestParam(value = "cabinCode", required = false) Character cabinCode) {
        if(departureAirportCode.equals(arrivalAirportCode)) {
            response.put("aviosPoints", 0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Optional<Route> route = AviosPointsCalculator.getRoutes().stream().filter(routeSet -> !departureAirportCode.equals(arrivalAirportCode) && routeSet.getRouteSet().contains(departureAirportCode) && routeSet.getRouteSet().contains(arrivalAirportCode))
                .findFirst();

        if(route.isPresent() && cabinCode == null){
            response.put("aviosPoints", route.get().getTotalAviosPoints());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if (route.isPresent() && cabinCode != null) {
            double totalAviosPoints = AviosPointsCalculator.calculateTotalAviosPoints(route.get(), cabinCode);
            Route updatedRoute = route.get();
            updatedRoute.setTotalAviosPoints(totalAviosPoints);
            response.put("aviosPoints", updatedRoute.getTotalAviosPoints());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("aviosPoints", 500.0);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
