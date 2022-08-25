package com.org.HomeLoan.exception;

public class LoanException extends RuntimeException {
	private String message;
	private Boolean status;
	 
    public LoanException() {}
 
    public LoanException(String msg) {
        super(msg);
        this.message = msg;
    }
    
    public LoanException(boolean stat) {
    	super();
        this.status = stat;
    }
}
