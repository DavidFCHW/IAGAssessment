package com.iag.iagassessment.utils;

import com.iag.iagassessment.entities.Route;

import java.util.Map;
import java.util.Set;

public class TestData {
    private TestData() {
    }

    public static Route testRouteStandard() {
        return new Route(Set.of("LHR", "LAX"), 4500);
    }

    public static Route testRouteSwitched() {
        return new Route(Set.of("LAX", "LHR"), 4500);
    }
    public static Route testRouteSame() {
        return new Route(Set.of("LAX", "LAX"), 4500);
    }

    public static Route testRouteWithCabinW() {
        return new Route(Set.of("LHR", "LAX"), 4500+(4500*0.2));
    }

    public static Route testRouteWithCabinJ() {
        return new Route(Set.of("LHR", "LAX"), 4500+(4500*0.5));
    }

    public static Route testRouteWithCabinF() {
        return new Route(Set.of("LHR", "LAX"), 4500+(4500*1.0));
    }

    public static Map<Character, Double> testCabins() {
        return Map.of('M',0.0,'W', 0.2, 'J', 0.5, 'F', 1.0);
    }
}
