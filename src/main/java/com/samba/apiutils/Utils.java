package com.samba.apiutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Utils {

	final static Logger logger = Logger.getLogger(Utils.class);

	public static String appUrl = null;

	public static String apiKey = null;
	
	public static String uiURL = null;
	public static String chormeDriver = null;

	static {
		getConfiguration();
	}

	private static void getConfiguration() {
		Properties properties = new Properties();
		properties = readConfigFile(Constants.CONFIG_FILE_PATH);
		appUrl = (String) properties.get("applicationurl");
		apiKey = (String) properties.get("apikey");
	}

	public static String getApplicationURL(String key) {
		StringBuffer url = new StringBuffer();
		url.append(appUrl).append("?api_key=").append(key);
		return url.toString();
	}

	public static String getAppURLWithoutKey() {
		StringBuffer url = new StringBuffer();
		url.append(appUrl);
		return url.toString();
	}

	public static String getApplicationURL() {
		StringBuffer url = new StringBuffer();
		url.append(appUrl).append("?api_key=").append(apiKey);
		return url.toString();
	}

	public static Properties readConfigFile(String file) {
		InputStream input = null;
		Properties properties = new Properties();
		try {
			input = new FileInputStream(file);
			properties.load(input);
		} catch (IOException ex) {
			logger.error("Error occured while reading property file" + ex.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("Error occured while reading property file" + e.getMessage());
				}
			}
		}
		return properties;
	}

}
