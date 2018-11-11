package com.cielo.extratolancamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "NOT FOUND")
public class ExtratoNotFoundException extends ApplicationException {
	/**
	* 
	*/
	private static final long serialVersionUID = -6831259682343489498L;

	public ExtratoNotFoundException(final String message) {
		super(message);
	}
}