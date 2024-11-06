package com.iag.iagassessment.entities;

import java.util.Set;

public class Route {
    private Set<String> routeSet;
    private double defaultAviosPoints;
    private double totalAviosPoints;

    public Route(Set<String> routeSet, double defaultAviosPoints) {
        this.routeSet = routeSet;
        this.defaultAviosPoints = defaultAviosPoints;
        this.totalAviosPoints = defaultAviosPoints;
    }

    public Set<String> getRouteSet() {
        return routeSet;
    }

    public void setRouteSet(Set<String> routeSet) {
        this.routeSet = routeSet;
    }

    public double getDefaultAviosPoints() {
        return defaultAviosPoints;
    }

    public void setDefaultAviosPoints(double defaultAviosPoints) {
        this.defaultAviosPoints = defaultAviosPoints;
    }

    public double getTotalAviosPoints() {
        return totalAviosPoints;
    }

    public void setTotalAviosPoints(double totalAviosPoints) {
        this.totalAviosPoints = totalAviosPoints;
    }
}
