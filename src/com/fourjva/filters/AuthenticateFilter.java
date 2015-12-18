package com.fourjva.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fourjva.entities.User;
import com.sun.istack.logging.Logger;

/**
 * Filter handling access authorization to specific jsp servlet functionnalities
 */
@WebFilter({"/myobjects","/profile"})
public class AuthenticateFilter implements Filter {

    public AuthenticateFilter() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Login filter reached");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		User u = (User)req.getSession().getAttribute("user");
		if(u==null){
			
			res.sendRedirect(req.getServletContext().getContextPath()+"/login");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
