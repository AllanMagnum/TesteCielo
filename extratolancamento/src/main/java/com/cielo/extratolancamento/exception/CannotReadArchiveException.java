package com.cielo.extratolancamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class CannotReadArchiveException extends ApplicationException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6109396010547791709L;

	public CannotReadArchiveException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
