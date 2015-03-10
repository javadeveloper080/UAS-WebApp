package org.edu.uams.server.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.edu.uams.server.api.UserContext;

public class SessionTracker {

	public static final String USERID_KEY="userID";

	public static void registerUser(HttpServletRequest req, UserContext userContext) {
		HttpSession session = req.getSession();

		session.setAttribute(USERID_KEY, userContext);
	}

	public static UserContext  getUserContext(HttpServletRequest req) {
		UserContext userContext=null;
		if (req.getSession(false)!=null && req.getSession(false).getAttribute(USERID_KEY)!=null) {
			userContext=(UserContext)req.getSession(false).getAttribute(USERID_KEY);
		}
		
		if (userContext==null) {
			throw new SessionTimeException("Sesssion Expired.User UserContext is null");
		}

		return userContext;
	}
	
	public static UserContext  checkLoginContext(HttpServletRequest req) {
		UserContext userContext=null;
		if (req.getSession(false)!=null && req.getSession(false).getAttribute(USERID_KEY)!=null) {
			userContext=(UserContext)req.getSession(false).getAttribute(USERID_KEY);
		}
		return userContext;
	}
	
	
	public static void   logOut(HttpServletRequest req) {
		if (req.getSession(false)!=null && req.getSession(false).getAttribute(USERID_KEY)!=null) {
			req.getSession(false).removeAttribute(USERID_KEY);
		}

	}

}
