package com.gowtham.util;

import java.time.LocalTime;

public class ValidationUtil {
	
	public static boolean isValid(Object obj){
		return(obj!=null);
	}
	
	public static boolean isNotValid(Object obj){
		return(obj==null);
	}
	
	public static boolean isValid(Integer number){
		return(number!=null && number.intValue()>0);
	}
	
	public static boolean isNotValid(Integer number){
		return(number==null || number.intValue()<=0);
	}
	
	public static boolean isValid(String str) {
		return (str != null && !"".equals(str.trim()));
	}
	
	public static boolean isNotValid(String str) {
		return (str == null || "".equals(str.trim()));
	}
	
	public static boolean isValid(Boolean boolnumber){
		return(boolnumber!=null);
	}
	
	public static boolean isNotValid(Boolean boolnumber){
		return(boolnumber==null);
	}
	
	public static boolean isValid(LocalTime time){
		return(time!=null);
	}
	
	public static boolean isNotValid(LocalTime time){
		return(time==null);
	}
	
}
