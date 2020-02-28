package com.sudhir.market.core;

public class IdGenerator {
	

	public static int getId(String employeeName, String password) {
		int id = employeeName.hashCode() +password.hashCode();
	    int length = String.valueOf(id).length();
	    int Max_Length = 5;
	    if(String.valueOf(id).length()>Max_Length) 
	    {
	        id = (int) (id /Math.pow(10.0,length - Max_Length ));
	    }
	    return  id;
	}

}
