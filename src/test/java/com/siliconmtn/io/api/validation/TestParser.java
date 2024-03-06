/* (C)2024 */
package com.siliconmtn.io.api.validation;

// JDK 11.x
import com.fasterxml.jackson.core.JsonProcessingException;
import com.siliconmtn.io.api.validation.factory.AbstractParser;
import com.siliconmtn.io.api.validation.validator.ValidationDTO;
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: TestParser.java
 * <b>Project</b>: spacelibs-java
 * <b>Description: </b> Exists to allow for the proper testing of the parserFactory
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author Eric Damschroder
 * @version 3.0
 * @since Mar 16, 2021
 * @updates:
 ****************************************************************************/

public class TestParser extends AbstractParser {

    /**
     * Returns a single ValidationDTO to test the parser factory with
     */
    @Override
    public List<ValidationDTO> requestParser(Object ba) throws JsonProcessingException {
        List<ValidationDTO> val = new ArrayList<>();
        val.add(ValidationDTO.builder().value("Test").isRequired(true).elementId("id").build());

        return val;
    }
}
