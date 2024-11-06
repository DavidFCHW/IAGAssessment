package com.iag.iagassessment;

import com.iag.iagassessment.entities.Route;
import com.iag.iagassessment.utils.TestData;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class AviosPointsCalculatorTest {

    @Test
    public void testThatCorrectAviosPointsIsReturnedWithCabinCodeM() {
        Route route = TestData.testRouteStandard();
        double currentAviosPoints = route.getDefaultAviosPoints();
        double actual = AviosPointsCalculator.calculateTotalAviosPoints(route, 'M');
        double expected = currentAviosPoints + (currentAviosPoints * 0.0);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testThatCorrectAviosPointsIsReturnedWithCabinCodeW() {
        Route route = TestData.testRouteStandard();
        double currentAviosPoints = route.getDefaultAviosPoints();
        double actual = AviosPointsCalculator.calculateTotalAviosPoints(route, 'W');
        double expected = currentAviosPoints + (currentAviosPoints * 0.2);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testThatCorrectAviosPointsIsReturnedWithCabinCodeJ() {
        Route route = TestData.testRouteStandard();
        double currentAviosPoints = route.getDefaultAviosPoints();
        double actual = AviosPointsCalculator.calculateTotalAviosPoints(route, 'J');
        double expected = currentAviosPoints + (currentAviosPoints * 0.5);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testThatCorrectAviosPointsIsReturnedWithCabinCodeF() {
        Route route = TestData.testRouteStandard();
        double currentAviosPoints = route.getDefaultAviosPoints();
        double actual = AviosPointsCalculator.calculateTotalAviosPoints(route, 'F');
        double expected = currentAviosPoints + (currentAviosPoints * 1.0);
        assertThat(expected).isEqualTo(actual);
    }

}
