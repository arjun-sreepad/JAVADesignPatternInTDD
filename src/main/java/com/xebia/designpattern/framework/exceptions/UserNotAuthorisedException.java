package com.xebia.designpattern.framework.exceptions;

public class UserNotAuthorisedException extends Exception{

	   public UserNotAuthorisedException(String message) {
		super();
		this.message = message;
	}

	private String message;
	   
	    public UserNotAuthorisedException() {
	        super();
	    }
	 
	 
	    public UserNotAuthorisedException(Throwable cause) {
	        super(cause);
	    }
	 
	    @Override
	    public String toString() {
	        return message;
	    }
	 
	    @Override
	    public String getMessage() {
	        return message;
	    }
}
