/* (C)2024 */
package com.siliconmtn.data.format;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: BooleanUtilTest.java
 * <b>Project</b>: SpaceLibs-Java
 * <b>Description: </b> Test of the Boolean util class.  This test ensures
 * the conversion of objects and primitives to a boolean works properly
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 3.0
 * @since Jan 20, 2021
 * @updates:
 ****************************************************************************/
class BooleanUtilTest {

    /**
     * Test method for {@link com.siliconmtn.data.format.BooleanUtil#toBoolean(int)}.
     */
    @Test
    void testToBooleanInt() {
        assertTrue(BooleanUtil.toBoolean(1));
        assertFalse(BooleanUtil.toBoolean(0));
        assertFalse(BooleanUtil.toBoolean(2));
    }

    /**
     * Test method for {@link com.siliconmtn.data.format.BooleanUtil#toBoolean(long)}.
     */
    @Test
    void testToBooleanLong() {
        assertTrue(BooleanUtil.toBoolean(1l));
        assertFalse(BooleanUtil.toBoolean(0l));
        assertFalse(BooleanUtil.toBoolean(2l));
    }

    /**
     * Test method for {@link com.siliconmtn.data.format.BooleanUtil#toBoolean(char)}.
     */
    @Test
    void testToBooleanChar() {
        assertTrue(BooleanUtil.toBoolean('y'));
        assertTrue(BooleanUtil.toBoolean('Y'));
        assertTrue(BooleanUtil.toBoolean('1'));
        assertFalse(BooleanUtil.toBoolean('0'));
        assertFalse(BooleanUtil.toBoolean('N'));
        assertFalse(BooleanUtil.toBoolean('n'));
    }

    /**
     * Test method for {@link com.siliconmtn.data.format.BooleanUtil#toBoolean(java.lang.Object)}.
     */
    @Test
    void testToBooleanObject() {
        assertTrue(BooleanUtil.toBoolean("yes"));
        assertTrue(BooleanUtil.toBoolean("Yes"));
        assertTrue(BooleanUtil.toBoolean("on"));
        assertTrue(BooleanUtil.toBoolean("ON"));
        assertTrue(BooleanUtil.toBoolean("1"));
        assertTrue(BooleanUtil.toBoolean(Integer.valueOf(1)));
        assertTrue(BooleanUtil.toBoolean(Long.valueOf(1)));
        assertTrue(BooleanUtil.toBoolean(Character.valueOf('y')));
        assertFalse(BooleanUtil.toBoolean(Boolean.FALSE));
        assertFalse(BooleanUtil.toBoolean(null));
        assertFalse(BooleanUtil.toBoolean(new Object()));
        assertFalse(BooleanUtil.toBoolean("Test"));
    }
}
