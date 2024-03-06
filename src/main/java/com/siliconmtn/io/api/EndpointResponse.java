/* (C)2024 */
package com.siliconmtn.io.api;

// JDK 11.x
import com.fasterxml.jackson.annotation.JsonFormat;
import com.siliconmtn.data.text.StringUtil;
import com.siliconmtn.io.api.validation.ValidationErrorDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;

/****************************************************************************
 * <b>Title</b>: ApiErrorResponse.java
 * <b>Project</b>: planit-api
 * <b>Description: </b> Common error response data when sending errors to the server
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author James Camire
 * @version 3.0
 * @since Mar 4, 2021
 * @updates:
 ****************************************************************************/
@Data
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class EndpointResponse {

    // Members
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Schema(description = "HTTP status code returned from the server.")
    protected HttpStatus status;

    @Schema(description = "Localized timestamp of when the response was generated.")
    protected LocalDateTime timestamp;

    @Schema(description = "Brief message intended to give context to the response.")
    protected String message;

    @Schema(description = "Error Message of any problems on the server.  Empty on Success")
    protected String debugMessage;

    @Schema(description = "The call succeeded on the server.")
    protected boolean isSuccess = false;

    @Schema(description = "Number of results returned on the response.")
    protected int count;

    @Schema(description = "Payload from the server.")
    protected Object data;

    @Schema(description = "Validation errors encountered while processing the request.")
    protected List<ValidationErrorDTO> failedValidations = new ArrayList<>();

    /**
     * Sets the current time when initializing
     */
    private EndpointResponse() {
        super();
        timestamp = LocalDateTime.now();
    }

    /**
     * Success response with the data and count
     * @param data Object data for the payload to the endpoint
     */
    public EndpointResponse(Object data) {
        this();
        this.data = data;
        this.count = 0;
        this.isSuccess = true;
        this.status = HttpStatus.OK;
    }

    /**
     * Success response with the data and count
     * @param data Object data for the payload to the endpoint
     * @param count Number of items.  Useful with server side pagination
     */
    public EndpointResponse(Object data, int count) {
        this();
        this.data = data;
        this.count = count;
        this.isSuccess = true;
        this.status = HttpStatus.OK;
    }

    /**
     * Assigns the HTTP status and the the time
     * @param status HttpStatus to return
     */
    public EndpointResponse(HttpStatusCode status) {
        this();
        if (status != null) {
            this.status = HttpStatus.resolve(status.value());
        }
    }

    /**
     * Assigns the status, time and exception stuff
     * @param status HttpStatus to return
     * @param ex Exception that was thrown
     */
    public EndpointResponse(HttpStatusCode status, Throwable ex) {
        this();
        this.status = HttpStatus.resolve(status.value());
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    /**
     * Assigns all parameters with this constructor
     * @param status HttpStatus to return
     * @param message Error message to display
     * @param ex Exception that was thrown
     */
    public EndpointResponse(HttpStatusCode status, String message, Throwable ex) {
        this();
        this.status = HttpStatus.resolve(status.value());
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    /*
     * (non-javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return StringUtil.getJsonString(this);
    }

    /**
     * Adds a single failed validation to the collection
     * @param failedValidation Adds a failed validation to the exception
     */
    public void addFailedValidation(ValidationErrorDTO failedValidation) {
        this.failedValidations.add(failedValidation);
    }

    /**
     * Adds a all failed validations to the collection
     * @param failedValidations Collection of the failed validations
     */
    public void addFailedValidations(List<ValidationErrorDTO> failedValidations) {
        this.failedValidations.addAll(failedValidations);
    }
}
