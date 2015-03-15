package com.util;

public class ApplicationUtil {
	
	
	 public static String getFomatedSQLDate(String dt1) {
	        
	        // dt1="04-Mar-2015";
	        
	        String dayText = dt1.substring(0, 2);
	        String monText = dt1.substring(3, 6);
	        String yearText = dt1.substring(7, 11);
	        
	        
	        if ("Jan".equals(monText)) {
	            monText = ""+01;
	        } else if ("Feb".equals(monText)) {
	            monText = "02";
	            
	        } else if ("Mar".equals(monText)) {
	            monText = "03";
	            
	        } else if ("Apr".equals(monText)) {
	            monText = ""+04;
	            
	        } else if ("May".equals(monText)) {
	            monText = ""+05;
	            
	        } else if ("Jun".equals(monText)) {
	            monText = ""+06;
	            
	        } else if ("Jul".equals(monText)) {
	            monText = ""+07;
	            
	        } else if ("Aug".equals(monText)) {
	            monText = "08";
	        }
	        else if ("Sep".equals(monText)) {
	            monText = "09";
	            
	        } else if ("Oct".equals(monText)) {
	            monText = ""+10;
	            
	        } else if ("Nov".equals(monText)) {
	            monText = ""+11;
	            
	        } else if ("Dec".equals(monText)) {
	            monText = ""+12;
	        }
	        
	        return  yearText+"-"+monText+"-"+dayText;
	        
	    }

}
