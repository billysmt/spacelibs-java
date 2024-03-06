/* (C)2024 */
package com.siliconmtn.data.report;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: GreyHeadingBorderDataCellStyleTest.java
 * <b>Project</b>: SpaceLibs-Java
 * <b>Description: </b> Tests the grey border heading excel report style class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 1.0
 * @since Feb 14, 2021
 * @updates:
 ****************************************************************************/
class GreyHeadingBorderDataCellStyleTest {

    /**
     * Test method for {@link com.siliconmtn.data.report.GreyHeadingBorderDataCellStyle#buildStyleMap()}.
     */
    @Test
    void testBuildStyleMap() {
        GreyHeadingBorderDataCellStyle ncs = new GreyHeadingBorderDataCellStyle();
        ncs.buildStyleMap();
        assertEquals(4, ncs.getStyleMap().size());
    }

    /**
     * Test method for {@link com.siliconmtn.data.report.GreyHeadingBorderDataCellStyle#GreyHeadingBorderDataCellStyle()}.
     */
    @Test
    void testNoStyleCellStyle() throws Exception {
        GreyHeadingBorderDataCellStyle ncs = new GreyHeadingBorderDataCellStyle();
        assertNotNull(ncs);
    }

    /**
     * Gets the style map form the style formatter
     * Test method for {@link com.siliconmtn.data.report.GreyHeadingBorderDataCellStyle#getStyleMap()}.
     */
    @Test
    void testGetStyleMap() throws Exception {
        GreyHeadingBorderDataCellStyle ncs = new GreyHeadingBorderDataCellStyle();
        ncs.setDisplayDate(true);
        assertNotNull(ncs.getStyleMap());
        assertEquals(4, ncs.getStyleMap().size());
    }

    /**
     * Gets the style map form the style formatter
     * Test method for {@link com.siliconmtn.data.report.GreyHeadingBorderDataCellStyle#getDateStyle(org.apache.poi.ss.usermodel.Workbook)}.
     */
    @Test
    void testGetDateStyle() throws Exception {
        Workbook wb = new HSSFWorkbook();
        GreyHeadingBorderDataCellStyle ncs = new GreyHeadingBorderDataCellStyle();
        ncs.getStyleMap().put(AbstractExcelCellStyle.DATE_MAP, new HashMap<>());
        CellStyle style = ncs.getDateStyle(wb);
        assertNotNull(style);
        wb.close();
    }

    /**
     * Gets the style map form the style formatter
     * Test method for {@link com.siliconmtn.data.report.GreyHeadingBorderDataCellStyle#setFont(org.apache.poi.ss.usermodel.CellStyle, java.util.Map, org.apache.poi.ss.usermodel.Workbook)}.
     */
    @Test
    void testSetFont() throws Exception {
        Workbook wb = new HSSFWorkbook();
        CellStyle style = wb.createCellStyle();
        Map<String, Object> map = new HashMap<>();
        map.put(AbstractExcelCellStyle.FONT_COLOR, Short.parseShort("25"));
        GreyHeadingBorderDataCellStyle ncs = new GreyHeadingBorderDataCellStyle();
        ncs.setFont(style, map, wb);
        assertEquals(25, wb.getFontAt(style.getFontIndex()).getColor());

        // Trying to set the color to null leaves the existing color in place
        map.put(AbstractExcelCellStyle.FONT_COLOR, null);
        assertEquals(25, wb.getFontAt(style.getFontIndex()).getColor());
    }
}
