package com.samba.apiutils;

public class Constants {

	// Config Path
	final static String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/config/config.properties";

	// Validation Constants
	public static final String ERR_CODE_INVALIDKEY="API_KEY_INVALID";
	public static final String ERR_CODE_MISSINGKEY="API_KEY_MISSING";
	public static final String ERR_MSG_INVALIDKEY="An invalid api_key was supplied. Get one at https://api.nasa.gov:443";
	public static final String ERR_MSG_MISSINGKEY="No api_key was supplied. Get one at https://api.nasa.gov:443";
    
    //Input String 
	public static final String INVALID_KEY = "abcdefg-fgh";
	
}
