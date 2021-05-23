package edu.rosehulman.covidtracer.auth;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ReflectionUtils.FieldFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@WebFilter("/*")
public class ResponseFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String newToken = JWT.create()
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.withSubject(httpServletRequest.getHeader("Username"))
				.sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));
		
//		Cookie cookie = new Cookie("Authorization", newToken);
//		cookie.setSecure(true);
//		cookie.setMaxAge(60*15);
//		cookie.setHttpOnly(true);
//		cookie.setPath("/");
//		httpServletResponse.addCookie(cookie);
		
        httpServletResponse.setHeader(SecurityConstants.HEADER_STRING, newToken);
        System.out.println(httpServletResponse.getHeader(SecurityConstants.HEADER_STRING));
        
        chain.doFilter(request, httpServletResponse);
	}


}
