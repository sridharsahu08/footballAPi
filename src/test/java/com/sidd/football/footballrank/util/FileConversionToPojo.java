package com.sidd.football.footballrank.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileConversionToPojo {
	
	public static String convertToString(String filename) throws Exception {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	    try (InputStream is = classLoader.getResourceAsStream(filename)) {
	        if (is == null) return null;
	        try (InputStreamReader isr = new InputStreamReader(is);
	             BufferedReader reader = new BufferedReader(isr)) {
	        	 return  reader.lines().collect(Collectors.joining(System.lineSeparator()));
	        }
	    } catch ( Exception ex) {
	    	throw ex;
	    }
	}

}
