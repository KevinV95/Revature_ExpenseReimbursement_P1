package com.revature.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CidAuthenticationFilter
 */
public class CidAuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CidAuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//we only want Headmaster Cid to be able to access this page via his session's "headmaster" role
		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpres = (HttpServletResponse) response;
		
		//get existing session, or null if no session in play
		HttpSession session = httpreq.getSession(false);
		if(session == null) {
			//goTo login page if you have no session at all
			httpres.setStatus(420);
			httpres.sendRedirect("/Project_1/index.html");		
		}
		else if(!session.getAttribute("role").equals("headmaster")) {
			httpres.setStatus(420);
			httpres.getWriter().write("You're not the headmaster! Access Denied");
//			httpres.sendRedirect("/Project_1/index.html");
			
		}
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
