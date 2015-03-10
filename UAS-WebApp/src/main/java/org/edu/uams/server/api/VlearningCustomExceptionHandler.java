package org.edu.uams.server.api;

import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

public class VlearningCustomExceptionHandler extends ExceptionHandler{
	 
		private static final Logger logger = Logger.getLogger(VlearningCustomExceptionHandler.class.getName());
		
		@Override
		public ActionForward execute(Exception ex, ExceptionConfig ae,
				ActionMapping mapping, ActionForm formInstance,
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException {
			
			logger.info(ex.getMessage());
			ex.printStackTrace();
			
			return super.execute(ex, ae, mapping, formInstance, request, response);
		}
		
		
	 
	}

