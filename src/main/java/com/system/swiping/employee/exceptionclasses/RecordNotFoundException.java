package com.system.swiping.employee.exceptionclasses;

@SuppressWarnings("serial")
public class RecordNotFoundException extends RuntimeException{
	
	public RecordNotFoundException(String excepDesc) {
		super(excepDesc);
	}

}
