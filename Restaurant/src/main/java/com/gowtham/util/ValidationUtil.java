package com.gowtham.util;

public class ValidationUtil {

	public static boolean isValid(Integer number){
		return(number!=null && number.intValue()>0);
	}
	
	public static boolean isNotValid(Integer number){
		return(number==null || number.intValue()<=0);
	}
	
	public static boolean isValid(String str) {
		return (str != null && !"".equals(str.trim()));
	}
	
	public static boolean isInValid(String str) {
		return (str == null || "".equals(str.trim()));
	}
	
	public static boolean isValid(Boolean boolnumber){
		return(boolnumber!=null);
	}
	
	public static boolean isNotValid(Boolean boolnumber){
		return(boolnumber==null);
	}
}
