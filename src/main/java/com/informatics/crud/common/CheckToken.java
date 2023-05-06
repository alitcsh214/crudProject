package com.informatics.crud.common;


import com.informatics.crud.entity.LoginEntity;
import com.informatics.crud.service.LoginService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;
import java.io.IOException;


/**
 * @author Ali Alavi
 */

@Configuration
@Order(1)
public class CheckToken implements Filter {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtProvider jwtProvider;

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckToken.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("########## Initiating Custom filter ##########");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String authorizationHeader= request.getHeader("authorization");

        if(!request.getRequestURI().equals("/mainRest/login") && StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")){

            String token= request.getHeader("authorization").replace("Bearer ","");
            String userName=jwtProvider.extractUserName(token);
            LoginEntity entity= loginService.get(userName);
           if(jwtProvider.validateToken(token,entity)==false)
               throw new RuntimeException();
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}