/* (C)2024 */
package com.siliconmtn.data.parser;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/****************************************************************************
 * <b>Title</b>: BeanDataVOTest.java
 * <b>Project</b>: SpaceLibs-Java
 * <b>Description: </b> Tests the BeanDataVO base class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 3.0
 * @since Jan 28, 2021
 * @updates:
 ****************************************************************************/
class BeanDataVOTest {

    @Test
    void testBeanDataVO() {
        BeanDataVO bdvo = new BeanDataVO();
        assertNotNull(bdvo);
    }

    @Test
    void testBeanDataVOHttpServletRequest() {
        Map<String, String[]> map = new HashMap<>();
        map.put("sunsetTime", new String[] {"10:24"});
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);

        BeanDataVO bdvo = new BeanDataVO(req);
        assertNotNull(bdvo);
    }

    @Test
    void testToString() {
        BeanDataVO bdvo = new BeanDataVO();
        assertEquals("", bdvo.toString());
    }
}
