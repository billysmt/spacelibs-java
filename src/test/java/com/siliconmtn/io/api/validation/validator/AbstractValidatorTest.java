/* (C)2024 */
package com.siliconmtn.io.api.validation.validator;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.siliconmtn.io.api.validation.ValidationErrorDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> AbstractValidatorTest.java <b>Project:</b> spacelibs-java
 * <b>Description:</b> Unit tests for the abstract. This tests the concrete
 * methods for the class <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b>
 * Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 3.0
 * @since May 4, 2021 <b>updates:</b>
 *
 ****************************************************************************/
class AbstractValidatorTest {

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateUriText(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateUriText() throws Exception {
        List<ValidationErrorDTO> errors = new ArrayList<>();
        ValidationDTO val =
                ValidationDTO.builder().uriText("hello World").value("hello World").build();

        TestValidator tv = new TestValidator();
        tv.validateUriText(val, errors);
        assertEquals(0, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateUriText(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateUriTextFailed() throws Exception {
        List<ValidationErrorDTO> errors = new ArrayList<>();
        ValidationDTO val =
                ValidationDTO.builder().uriText("hello World").value("hello World broken").build();

        TestValidator tv = new TestValidator();
        tv.validateUriText(val, errors);
        assertEquals(1, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateOptions(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateOptions() throws Exception {
        Map<String, String> validOptions = new HashMap<>();
        validOptions.put("one", "VALID");

        List<ValidationErrorDTO> errors = new ArrayList<>();
        ValidationDTO val =
                ValidationDTO.builder().value("VALID").validOptions(validOptions).build();

        TestValidator tv = new TestValidator();
        tv.validateOptions(val, errors);
        assertEquals(0, errors.size());

        validOptions = new HashMap<>();
        validOptions.put("one", null);

        errors = new ArrayList<>();
        val = ValidationDTO.builder().value("VALID").validOptions(validOptions).build();

        tv = new TestValidator();
        tv.validateOptions(val, errors);
        assertEquals(0, errors.size());

        validOptions = new HashMap<>();
        validOptions.put("one", "oneValWrong");

        errors = new ArrayList<>();
        val = ValidationDTO.builder().value("oneVal").validOptions(validOptions).build();

        tv = new TestValidator();
        tv.validateOptions(val, errors);
        assertEquals(1, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validate(com.siliconmtn.io.api.validation.validator.ValidationDTO)}.
     */
    @Test
    void testValidate() throws Exception {
        ValidationDTO val =
                ValidationDTO.builder().uriText("hello World").value("hello World").build();

        TestValidator tv = new TestValidator();
        List<ValidationErrorDTO> errors = tv.validate(val);
        assertEquals(0, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateRequired(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateRequired() throws Exception {
        ValidationDTO val = ValidationDTO.builder().isRequired(true).value("hello World").build();

        List<ValidationErrorDTO> errors = new ArrayList<>();
        TestValidator tv = new TestValidator();
        tv.validateRequired(val, errors);
        assertEquals(0, errors.size());

        val = ValidationDTO.builder().isRequired(true).value(null).build();

        tv.validateRequired(val, errors);
        assertEquals(1, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateRequired(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateRequiredNot() throws Exception {
        ValidationDTO val = ValidationDTO.builder().isRequired(false).value("hello World").build();

        List<ValidationErrorDTO> errors = new ArrayList<>();
        TestValidator tv = new TestValidator();
        tv.validateRequired(val, errors);
        assertEquals(0, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateRequired(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateRequiredNotEmpty() throws Exception {
        ValidationDTO val = ValidationDTO.builder().isRequired(false).value(null).build();

        List<ValidationErrorDTO> errors = new ArrayList<>();
        TestValidator tv = new TestValidator();
        tv.validateRequired(val, errors);
        assertEquals(0, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateRegex(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateRegexBothEmpty() throws Exception {
        List<ValidationErrorDTO> errors = new ArrayList<>();
        ValidationDTO val = ValidationDTO.builder().regex(null).value(null).build();

        TestValidator tv = new TestValidator();
        tv.validateRegex(val, errors);
        assertEquals(0, errors.size());

        val = ValidationDTO.builder().regex(null).value("test").build();

        tv.validateRegex(val, errors);
        assertEquals(0, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateRegex(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateRegexSuccess() throws Exception {
        List<ValidationErrorDTO> errors = new ArrayList<>();
        ValidationDTO val = ValidationDTO.builder().regex("[a-zA-Z]+").value("test").build();

        TestValidator tv = new TestValidator();
        tv.validateRegex(val, errors);
        assertEquals(0, errors.size());
    }

    /**
     * Test method for
     * {@link com.siliconmtn.io.api.validation.validator.AbstractValidator#validateRegex(com.siliconmtn.io.api.validation.validator.ValidationDTO, java.util.List)}.
     */
    @Test
    void testValidateRegexFailure() throws Exception {
        List<ValidationErrorDTO> errors = new ArrayList<>();
        ValidationDTO val = ValidationDTO.builder().regex("[a-zA-Z]+").value("test123").build();

        TestValidator tv = new TestValidator();
        tv.validateRegex(val, errors);
        assertEquals(1, errors.size());
    }
}

class TestValidator extends AbstractValidator {

    @Override
    public void validateMin(ValidationDTO validation, List<ValidationErrorDTO> errors) {
        // nothiing to do

    }

    @Override
    public void validateMax(ValidationDTO validation, List<ValidationErrorDTO> errors) {
        // nothing to do

    }
}
