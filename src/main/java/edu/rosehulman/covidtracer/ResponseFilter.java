package edu.rosehulman.covidtracer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ReflectionUtils.FieldFilter;

@WebFilter("/*")
public class ResponseFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Authorization", SecurityContextHolder.getContext().getAuthentication().toString());
        chain.doFilter(request, response);
	}


}
