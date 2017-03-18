package com.symantec.partyservice.exception;

public class IncorrectRequest  extends Exception{
	public IncorrectRequest(){
		super();
	}
	public IncorrectRequest(String message){
		super(message);
	}
	public IncorrectRequest(Throwable t, String s){
		super(s,t);
	}
}
