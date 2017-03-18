package com.symantec.partyservice.exception;

public class PersistanceException extends Exception{
	public PersistanceException(){
		super();
	}
	public PersistanceException(String message){
		super(message);
	}
	
	public PersistanceException(Throwable t, String m){
		super(m, t);
	}
}
