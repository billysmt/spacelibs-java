/* (C)2024 */
package com.siliconmtn.io.api.security;

import com.siliconmtn.data.text.StringUtil;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/****************************************************************************
 * <b>Title</b>: XSSFilter.java
 * <b>Project</b>: spacelibs-java
 * <b>Description: </b> Load the body from the request object and remove any
 * potential XSS vectors from it before passing it on to the rest of the app.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author Chris Scarola
 * @version 3.0
 * @since Mar 5, 2021
 * @updates:
 ****************************************************************************/
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class XSSFilter implements Filter {

    /**
     * Sanitize the request object by removing any potential XSS attack vectors
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        XSSRequestWrapper wrappedRequest = new XSSRequestWrapper((HttpServletRequest) request);

        String body = IOUtils.toString(wrappedRequest.getReader());
        if (!StringUtil.isEmpty(body)) {
            body = XSSRequestWrapper.stripXSS(body);
            wrappedRequest.resetInputStream(body.getBytes());
        }

        chain.doFilter(wrappedRequest, response);
    }
}
