package org.edu.uams.server.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class AppServletContextListener implements ServletContextListener {


	public AppServletContextListener() {
	}


	public void contextInitialized(ServletContextEvent arg0) {

		ApplicationIntializer.init();
	}


	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
