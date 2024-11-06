package com.iag.iagassessment;

import com.iag.iagassessment.entities.Route;

import java.util.*;


public class AviosPointsCalculator {
    private static HashMap<Character, Double> cabins = new HashMap<>();
    private static List<Route> routes = new ArrayList<>();

    static {
        cabins.put('M', 0.0);
        cabins.put('W', 0.2);
        cabins.put('J', 0.5);
        cabins.put('F', 1.0);
        routes.add(new Route(Set.of("LHR","LAX"), 4500));
        routes.add(new Route(Set.of("LHR", "SFO"), 4400));
        routes.add(new Route(Set.of("LHR", "JFK"), 3200));
        routes.add(new Route(Set.of("LGW", "YYZ"), 3250));
    }

    public static HashMap<Character, Double> getCabins() {
        return cabins;
    }

    public static List<Route> getRoutes() {
        return routes;
    }

    public static double calculateTotalAviosPoints(Route route, char cabinCode) {
        if (!cabins.containsKey(cabinCode)) {
            return route.getDefaultAviosPoints();
        }
        double defAviosPoints = route.getDefaultAviosPoints();
        double result = defAviosPoints + (defAviosPoints * cabins.get(cabinCode));
        return result;
    }
}
