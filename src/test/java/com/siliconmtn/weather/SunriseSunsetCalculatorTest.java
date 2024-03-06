/* (C)2024 */
package com.siliconmtn.weather;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;

import com.siliconmtn.data.format.DateFormat;
import com.siliconmtn.data.format.DateFormat.DatePattern;
import java.util.Calendar;
import java.util.TimeZone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SunriseSunsetCalculatorTest.java
 * <b>Project</b>: SpaceLibs-Java
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 3.0
 * @since Jan 28, 2021
 * @updates:
 ****************************************************************************/
class SunriseSunsetCalculatorTest {

    // Members
    SunriseSunsetCalculator ssCal;
    Coordinate coord;
    TimeZone tz;

    @BeforeEach
    void setUpBeforeEach() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Denver"));
        coord = new Coordinate("100.123", "-34.5678");
        tz = TimeZone.getTimeZone("America/Denver");
        ssCal = new SunriseSunsetCalculator(coord, tz);
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#SunriseSunsetCalculator(com.siliconmtn.weather.Coordinate, java.lang.String)}.
     */
    @Test
    void testSunriseSunsetCalculatorCoordinateString() {
        ssCal = new SunriseSunsetCalculator(coord, tz.getID());
        assertEquals(coord, ssCal.getLocation());
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#SunriseSunsetCalculator(com.siliconmtn.weather.Coordinate, java.util.TimeZone)}.
     */
    @Test
    void testSunriseSunsetCalculatorCoordinateTimeZone() {
        assertEquals(coord, ssCal.getLocation());
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getAstronomicalSunriseForDate(java.util.Calendar)}.
     */
    @Test
    void testGetAstronomicalSunriseForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals("01:22", ssCal.getAstronomicalSunriseForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getAstronomicalSunriseCalendarForDate(java.util.Calendar)}.
     */
    @Test
    void testGetAstronomicalSunriseCalendarForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));

        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 01:22:00"));
        assertEquals(sunrise, ssCal.getAstronomicalSunriseCalendarForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getAstronomicalSunsetForDate(java.util.Calendar)}.
     */
    @Test
    void testGetAstronomicalSunsetForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals("13:22", ssCal.getAstronomicalSunsetForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getAstronomicalSunsetCalendarForDate(java.util.Calendar)}.
     */
    @Test
    void testGetAstronomicalSunsetCalendarForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));

        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 13:22:00"));
        assertEquals(sunrise, ssCal.getAstronomicalSunsetCalendarForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getNauticalSunriseForDate(java.util.Calendar)}.
     */
    @Test
    void testGetNauticalSunriseForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals("01:22", ssCal.getNauticalSunriseForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getNauticalSunriseCalendarForDate(java.util.Calendar)}.
     */
    @Test
    void testGetNauticalSunriseCalendarForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));

        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 01:22:00"));
        assertEquals(sunrise, ssCal.getNauticalSunriseCalendarForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getNauticalSunsetForDate(java.util.Calendar)}.
     */
    @Test
    void testGetNauticalSunsetForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals("13:22", ssCal.getNauticalSunsetForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getNauticalSunsetCalendarForDate(java.util.Calendar)}.
     */
    @Test
    void testGetNauticalSunsetCalendarForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));

        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 13:22:00"));
        assertEquals(sunrise, ssCal.getNauticalSunsetCalendarForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getCivilSunriseForDate(java.util.Calendar)}.
     */
    @Test
    void testGetCivilSunriseForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals("01:22", ssCal.getCivilSunriseForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getCivilSunriseCalendarForDate(java.util.Calendar)}.
     */
    @Test
    void testGetCivilSunriseCalendarForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));

        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 01:22:00"));
        assertEquals(sunrise, ssCal.getCivilSunriseCalendarForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getCivilSunsetForDate(java.util.Calendar)}.
     */
    @Test
    void testGetCivilSunsetForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals("13:22", ssCal.getCivilSunsetForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getCivilSunsetCalendarForDate(java.util.Calendar)}.
     */
    @Test
    void testGetCivilSunsetCalendarForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));

        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 13:22:00"));
        assertEquals(sunrise, ssCal.getCivilSunsetCalendarForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getOfficialSunriseForDate(java.util.Calendar)}.
     */
    @Test
    void testGetOfficialSunriseForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals("01:22", ssCal.getOfficialSunriseForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getOfficialSunriseCalendarForDate(java.util.Calendar)}.
     */
    @Test
    void testGetOfficialSunriseCalendarForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));

        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 01:22:00"));
        assertEquals(sunrise, ssCal.getOfficialSunriseCalendarForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getOfficialSunsetForDate(java.util.Calendar)}.
     */
    @Test
    void testGetOfficialSunsetForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals("13:22", ssCal.getOfficialSunsetForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getOfficialSunsetCalendarForDate(java.util.Calendar)}.
     */
    @Test
    void testGetOfficialSunsetCalendarForDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));

        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 13:22:00"));
        assertEquals(sunrise, ssCal.getOfficialSunsetCalendarForDate(cal));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getSunrise(double, double, java.util.TimeZone, java.util.Calendar, double)}.
     */
    @Test
    void testGetSunrise() {
        Calendar sunrise = Calendar.getInstance();
        sunrise.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 01:22:00"));

        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals(
                sunrise,
                SunriseSunsetCalculator.getSunrise(
                        coord.getLatitude().doubleValue(),
                        coord.getLongitude().doubleValue(),
                        tz,
                        cal,
                        0));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getSunset(double, double, java.util.TimeZone, java.util.Calendar, double)}.
     */
    @Test
    void testGetSunset() {
        Calendar sunset = Calendar.getInstance();
        sunset.setTime(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2020-01-01 13:22:00"));

        Calendar cal = Calendar.getInstance();
        cal.setTime(DateFormat.formatDate(DatePattern.DATE_DASH, "2020-01-01"));
        assertEquals(
                sunset,
                SunriseSunsetCalculator.getSunset(
                        coord.getLatitude().doubleValue(),
                        coord.getLongitude().doubleValue(),
                        tz,
                        cal,
                        0));
    }

    /**
     * Test method for {@link com.siliconmtn.weather.SunriseSunsetCalculator#getLocation()}.
     */
    @Test
    void testGetLocation() {
        assertEquals(coord, ssCal.getLocation());
    }
}
