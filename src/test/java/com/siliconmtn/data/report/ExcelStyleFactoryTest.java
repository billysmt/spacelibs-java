/* (C)2024 */
package com.siliconmtn.data.report;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;

import com.siliconmtn.data.report.ExcelStyleFactory.Styles;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ExcelStyleFactoryTest.java
 * <b>Project</b>: SpaceLibs-Java
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 3.0
 * @since Feb 14, 2021
 * @updates:
 ****************************************************************************/
class ExcelStyleFactoryTest {

    /**
     * Test method for {@link com.siliconmtn.data.report.ExcelStyleFactory#getExcelStyle(com.siliconmtn.data.report.ExcelStyleFactory.Styles)}.
     * @throws Exception
     */
    @Test
    void testGetExcelStyle() throws Exception {
        ExcelStyleInterface style = ExcelStyleFactory.getExcelStyle(Styles.STANDARD);
        assertTrue(style instanceof GreyHeadingBorderDataCellStyle);

        style = ExcelStyleFactory.getExcelStyle(Styles.NO_STYLE);
        assertTrue(style instanceof NoStyleCellStyle);

        style = ExcelStyleFactory.getExcelStyle(Styles.BORDERS_ONLY);
        assertTrue(style instanceof BordersOnlyCellStyle);

        style = ExcelStyleFactory.getExcelStyle(null);
        assertTrue(style instanceof BordersOnlyCellStyle);
    }
}
