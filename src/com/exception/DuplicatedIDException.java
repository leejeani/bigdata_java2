package com.exception;

public class DuplicatedIDException extends Exception {
	public DuplicatedIDException(){
		super("DplicatedIDException Exception ...");
	}
	public DuplicatedIDException(String str){
		super(str);
	}
}
