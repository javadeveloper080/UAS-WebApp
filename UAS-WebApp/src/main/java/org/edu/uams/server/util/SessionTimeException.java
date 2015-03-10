package org.edu.uams.server.util;

public class SessionTimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SessionTimeException() {
		super();
	}

	public SessionTimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SessionTimeException(String message) {
		super(message);
	}

	public SessionTimeException(Throwable cause) {
		super(cause);
	}

}
