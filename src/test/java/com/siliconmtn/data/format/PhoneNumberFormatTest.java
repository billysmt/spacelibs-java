/* (C)2024 */
package com.siliconmtn.data.format;

// JUnit5
import static org.junit.jupiter.api.Assertions.*;

import com.siliconmtn.data.format.PhoneNumberFormat.FormatType;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PhoneNumberFormatTest.java
 * <b>Project</b>: SpaceLibs-Java
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 3.0
 * @since Jan 13, 2021
 * @updates:
 ****************************************************************************/
class PhoneNumberFormatTest {

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#getFullNumber()}.
     */
    @Test
    void testGetFullNumber() {
        PhoneNumberFormat pnf = new PhoneNumberFormat("3031234567", FormatType.DOT_FORMATTING);
        assertEquals("13031234567", pnf.getFullNumber());

        pnf = new PhoneNumberFormat("3031234567", "US", FormatType.DASH_FORMATTING);
        assertEquals("13031234567", pnf.getFullNumber());

        pnf = new PhoneNumberFormat("13031234567", "US", FormatType.DASH_FORMATTING);
        assertEquals("13031234567", pnf.getFullNumber());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#getFormattedNumber()}.
     */
    @Test
    void testGetFormattedNumber() {
        PhoneNumberFormat pnf =
                new PhoneNumberFormat("303-123-4567", "US", FormatType.DOT_FORMATTING);
        assertEquals("303.123.4567", pnf.getFormattedNumber());

        pnf = new PhoneNumberFormat("3031234567", "US", FormatType.DASH_FORMATTING);
        assertEquals("303-123-4567", pnf.getFormattedNumber());

        pnf = new PhoneNumberFormat("3031234567", "US", FormatType.NATIONAL_FORMAT);
        assertEquals("(303) 123-4567", pnf.getFormattedNumber());

        pnf = new PhoneNumberFormat("3031234567", "US", FormatType.INTERNATIONAL_FORMAT);
        assertEquals("+1 303-123-4567", pnf.getFormattedNumber());

        pnf = new PhoneNumberFormat(null);
        assertEquals(null, pnf.getFormattedNumber());

        pnf = new PhoneNumberFormat("303123", FormatType.DASH_FORMATTING);
        assertEquals("303123", pnf.getFormattedNumber());

        pnf = new PhoneNumberFormat("303", FormatType.DASH_FORMATTING);
        assertEquals("303", pnf.getFormattedNumber());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#getPhoneNumber()}.
     */
    @Test
    void testGetPhoneNumber() {
        PhoneNumberFormat pnf =
                new PhoneNumberFormat("3031234567", "US", FormatType.DOT_FORMATTING);
        assertEquals("3031234567", pnf.getPhoneNumber());

        pnf = new PhoneNumberFormat("303.123.4567", "US", FormatType.DOT_FORMATTING);
        assertEquals("303.123.4567", pnf.getPhoneNumber());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#setPhoneNumber(java.lang.String)}.
     */
    @Test
    void testSetPhoneNumber() {
        PhoneNumberFormat pnf = new PhoneNumberFormat("3031234567");
        assertEquals("3031234567", pnf.getPhoneNumber());

        pnf = new PhoneNumberFormat("303-123-4567");
        assertEquals("303-123-4567", pnf.getPhoneNumber());

        pnf = new PhoneNumberFormat(null);
        pnf.setPhoneNumber(null);
        assertEquals(null, pnf.getPhoneNumber());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#getFormatType()}.
     */
    @Test
    void testGetFormatType() {
        PhoneNumberFormat pnf = new PhoneNumberFormat("3031234567", FormatType.DOT_FORMATTING);
        assertEquals(FormatType.DOT_FORMATTING, pnf.getFormatType());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#setFormatType(int)}.
     */
    @Test
    void testSetFormatType() {
        PhoneNumberFormat pnf = new PhoneNumberFormat("303-123-4567");
        pnf.setFormatType(FormatType.DASH_FORMATTING);
        assertEquals(FormatType.DASH_FORMATTING, pnf.getFormatType());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#getCountryCode()}.
     */
    @Test
    void testGetCountryCode() {
        PhoneNumberFormat pnf =
                new PhoneNumberFormat("3031234567", "US", FormatType.DOT_FORMATTING);
        assertEquals("US", pnf.getCountryCode());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#setCountryCode(java.lang.String)}.
     */
    @Test
    void testSetCountryCode() {
        PhoneNumberFormat pnf = new PhoneNumberFormat("303-123-4567");
        pnf.setCountryCode("CH");
        assertEquals("CH", pnf.getCountryCode());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#assignPhoneNumber()}.
     */
    @Test
    void testAssignPhoneNumber() {
        PhoneNumberFormat pnf = new PhoneNumberFormat(null);
        assertEquals(null, pnf.assignPhoneNumber());
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#assignUSFormatting(char, char)}.
     */
    @Test
    void testAssignUSFormatting() {
        PhoneNumberFormat pnf = new PhoneNumberFormat(null);
        assertEquals(null, pnf.assignUSFormatting('.', '.'));
    }

    /**
     * Test method for {@link com.smt.data.formatter.PhoneNumberFormat#obfuscatePhoneNumber()}.
     */
    @Test
    void testObfuscatePhoneNumber() {
        PhoneNumberFormat pnf = new PhoneNumberFormat("303-123-4567");
        assertEquals("(XXX) XXX-4567", pnf.obfuscatePhoneNumber());

        pnf = new PhoneNumberFormat("3031234567", FormatType.DOT_FORMATTING);
        assertEquals("XXX.XXX.4567", pnf.obfuscatePhoneNumber());

        pnf = new PhoneNumberFormat("3031234567", FormatType.DASH_FORMATTING);
        assertEquals("XXX-XXX-4567", pnf.obfuscatePhoneNumber());
    }
}
