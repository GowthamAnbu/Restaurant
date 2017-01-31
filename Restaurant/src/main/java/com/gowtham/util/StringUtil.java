package com.gowtham.util;

public class StringUtil {

	public boolean isValid(String str) {
		return (str != null && !"".equals(str.trim()));
	}
	
	public boolean isInValid(String str) {
		return (str == null || "".equals(str.trim()));
	}
	
	
}
