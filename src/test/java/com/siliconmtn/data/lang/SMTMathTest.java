/* (C)2024 */
package com.siliconmtn.data.lang;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SMTMathTest.java
 * <b>Project</b>: SpaceLibs-Java
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 3.0
 * @since Jan 22, 2021
 * @updates:
 ****************************************************************************/
class SMTMathTest {

    /**
     * Test method for {@link com.siliconmtn.data.lang.SMTMath#getArcCosineFor(java.math.BigDecimal)}.
     */
    @Test
    void testGetArcCosineFor() {
        assertEquals(BigDecimal.valueOf(1.2345), SMTMath.getArcCosineFor(BigDecimal.valueOf(.33)));
    }

    /**
     * Test method for {@link com.siliconmtn.data.lang.SMTMath#convertRadiansToDegrees(java.math.BigDecimal)}.
     */
    @Test
    void testConvertRadiansToDegrees() {
        assertEquals(
                BigDecimal.valueOf(18.9076),
                SMTMath.convertRadiansToDegrees(BigDecimal.valueOf(.33)));
    }

    /**
     * Test method for {@link com.siliconmtn.data.lang.SMTMath#convertDegreesToRadians(java.math.BigDecimal)}.
     */
    @Test
    void testConvertDegreesToRadians() {
        assertEquals(
                BigDecimal.valueOf(.3300).setScale(4, RoundingMode.HALF_EVEN),
                SMTMath.convertDegreesToRadians(BigDecimal.valueOf(18.9076)));
    }

    /**
     * Test method for {@link com.siliconmtn.data.lang.SMTMath#multiplyBy(java.math.BigDecimal, java.math.BigDecimal)}.
     */
    @Test
    void testMultiplyBy() {
        assertEquals(
                BigDecimal.valueOf(.66).setScale(4, RoundingMode.HALF_EVEN),
                SMTMath.multiplyBy(BigDecimal.valueOf(.33), BigDecimal.valueOf(2.0)));
    }

    /**
     * Test method for {@link com.siliconmtn.data.lang.SMTMath#divideBy(java.math.BigDecimal, java.math.BigDecimal)}.
     */
    @Test
    void testDivideBy() {
        assertEquals(
                BigDecimal.valueOf(.33).setScale(4, RoundingMode.HALF_EVEN),
                SMTMath.divideBy(BigDecimal.valueOf(.66), BigDecimal.valueOf(2.0)));
        assertEquals(
                BigDecimal.valueOf(0.0),
                SMTMath.divideBy(BigDecimal.valueOf(.66), BigDecimal.valueOf(0.0)));
        assertEquals(BigDecimal.valueOf(0.0), SMTMath.divideBy(BigDecimal.valueOf(.66), null));
        assertEquals(BigDecimal.valueOf(0.0), SMTMath.divideBy(BigDecimal.valueOf(0), null));
        assertEquals(BigDecimal.valueOf(0.0), SMTMath.divideBy(null, null));
        assertEquals(BigDecimal.valueOf(0.0), SMTMath.divideBy(null, BigDecimal.valueOf(0.0)));
    }
}
