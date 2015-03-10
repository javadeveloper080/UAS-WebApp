package org.edu.uams.server.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.edu.uams.server.api.UserContext;

/**
 * Servlet Filter implementation class SessionFilter
 */
public class SessionFilter implements Filter {

	private static  FilterConfig fConfig =null;
	private ArrayList<String> urlList;
	private static ArrayList<String> adminUrlList=new ArrayList<String>();
	private static ArrayList<String> studentUrlList=new ArrayList<String>();
	private static ArrayList<String> professorUrlList=new ArrayList<String>();

	/**
	 * Default constructor. 
	 */
	public SessionFilter() {
		super();
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


		HttpServletRequest httpRequest=null;
		HttpServletResponse httpResponse =null;
		boolean authorized = false;
		if (request instanceof HttpServletRequest) {
			httpRequest = (HttpServletRequest) request;
			httpResponse = (HttpServletResponse) response;
			String url = httpRequest.getRequestURL().toString();
			System.out.println("url:"+url);
			
			chain.doFilter(request, response);

			UserContext userContext =  SessionTracker.getUserContext(httpRequest);
			if (userContext != null) {
				authorized = true;
			}

			if (authorized) {
				chain.doFilter(request, response);
				return;
			} else if (fConfig != null) {
				String login_page = fConfig.getInitParameter("login_page");
				if (login_page != null && !"".equals(login_page)) {
					//httpResponse.sendRedirect("/views/index.jsp");
					//RequestDispatcher requestDispatcher = httpRequest.getRequestDispatcher(httpRequest.getContextPath()+ "/");
					
					httpResponse.sendRedirect(url);
					//requestDispatcher.forward(httpRequest, httpResponse);
					//httpResponse.sendRedirect(httpRequest.getContextPath()+"/views/index.jsp");
					//return;
				}
			}
		}



	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		SessionFilter.fConfig=fConfig;
		String urls = fConfig.getInitParameter("login_page");
		StringTokenizer token = new StringTokenizer(urls, ",");

		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			String nextUrl=token.nextToken();
			urlList.add(nextUrl);	
		}
	}
}

