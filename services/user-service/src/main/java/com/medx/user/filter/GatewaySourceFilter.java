package com.medx.user.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(0)
public class GatewaySourceFilter implements Filter {

    public static final String GATEWAY_SOURCE_HEADER = "X-Gateway-Source";
    public static final String GATEWAY_SOURCE_VALUE = "api-gateway";

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String gatewaySource = servletRequest.getHeader(GATEWAY_SOURCE_HEADER);

        if (!GATEWAY_SOURCE_VALUE.equals(gatewaySource)) {
            ((HttpServletResponse) response).sendError(403, "Direct access is not allowed!");
            return;
        }

        chain.doFilter(request, response);
    }
}
