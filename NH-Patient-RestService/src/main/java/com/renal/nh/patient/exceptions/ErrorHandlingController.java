
package com.renal.nh.patient.exceptions;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller for handling the global exceptions
 * @author dasaraa
 *
 */
@ControllerAdvice
public class ErrorHandlingController {

	/**
     * Exception handler for PatientNotFoundException.
     *
     * @param patientNotFoundException - the exception to handle
     */
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorResponse> patientNotFoundExceptions(PatientNotFoundException patientNotFoundException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.NOT_FOUND.toString());
		errorResponse.setReason(patientNotFoundException.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,
				HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Exception handler for default exception
	 * @return the error response
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> defaultException(Exception e){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorResponse.setReason(e.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/**
	 * Exception handler for SqlException
	 * @param sqlException
	 * @return the error response
	 */
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ErrorResponse> sqlException(SQLException sqlException){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setCode(HttpStatus.NOT_FOUND.toString());
		errorResponse.setReason(sqlException.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}

}
