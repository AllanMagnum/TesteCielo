package com.cielo.extratolancamento.exception;

public abstract class ApplicationException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3396907473460251254L;

	public ApplicationException(final String message) {
        super(message);
    }

    public ApplicationException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
