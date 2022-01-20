package erepo.dummyservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class CorrelationIdFilter implements Filter {
    public static final String CORRELATION_ID = "correlation-id";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        MDC.put(CORRELATION_ID, httpServletRequest.getHeader(CORRELATION_ID));
        log.info("Dummy Service Incoming Correlation id: {}", MDC.get(CORRELATION_ID));
        filterChain.doFilter(httpServletRequest, servletResponse);
    }
}
