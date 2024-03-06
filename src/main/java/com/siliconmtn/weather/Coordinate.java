/* (C)2024 */
package com.siliconmtn.weather;

// JDK 11.x
import java.io.Serializable;
import java.math.BigDecimal;

/****************************************************************************
 * <b>Title</b>: Coordinate.java
 * <b>Project</b>: SpaceLibs-Java
 * <b>Description: </b> Thanks to Mike Reedell for creating this class!
 * Simple value object holding lat/long coordinates
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * @author James Camire
 * @version 3.0
 * @since Jan 15, 2021
 * Copyright 2008-2009 Mike Reedell / LuckyCatLabs.
 * http://www.apache.org/licenses/LICENSE-2.0
 ****************************************************************************/
public class Coordinate implements Serializable {
    /**
     * Serial Version
     */
    private static final long serialVersionUID = -1932129305956985672L;

    // Members
    private BigDecimal latitude;
    private BigDecimal longitude;

    /**
     * Creates a new instance of <code>Location</code> with the given parameters.
     *
     * @param latitude The latitude, in degrees, of this location. North latitude is positive, south negative.
     * @param longitude The longitude, in degrees, of this location. East longitude is positive, east negative.
     */
    public Coordinate(String latitude, String longitude) {
        this.latitude = new BigDecimal(latitude);
        this.longitude = new BigDecimal(longitude);
    }

    /**
     * Creates a new instance of <code>Location</code> with the given parameters.
     *
     * @param latitude The latitude, in degrees, of this location. North latitude is positive, south negative.
     * @param longitude The longitude, in degrees, of this location. East longitude is positive, east negative.
     */
    public Coordinate(double latitude, double longitude) {
        this.latitude = BigDecimal.valueOf(latitude);
        this.longitude = BigDecimal.valueOf(longitude);
    }

    /**
     * @return the latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * @return the longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Sets the coordinates of the location object.
     *
     * @param latitude The latitude, in degrees, of this location. North latitude is positive, south negative.
     * @param longitude The longitude, in degrees, of this location. East longitude is positive, east negative.
     */
    public void setLocation(String latitude, String longitude) {
        this.latitude = new BigDecimal(latitude);
        this.longitude = new BigDecimal(longitude);
    }

    /**
     * Sets the coordinates of the location object.
     *
     * @param latitude The latitude, in degrees, of this location. North latitude is positive, south negative.
     * @param longitude The longitude, in degrees, of this location. East longitude is positive, east negative.
     */
    public void setLocation(double latitude, double longitude) {
        this.latitude = BigDecimal.valueOf(latitude);
        this.longitude = BigDecimal.valueOf(longitude);
    }
}
