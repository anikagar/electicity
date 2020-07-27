package com.electricity.exception;

public class ElectricityException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionMesg;
	
    public ElectricityException(String exceptionMsg) {
		 this.exceptionMesg = exceptionMsg; 
	}

	public String getExceptionMesg() {
		return exceptionMesg;
	}

	public void setExceptionMesg(String exceptionMesg) {
		this.exceptionMesg = exceptionMesg;
	}
    
    
    
}
