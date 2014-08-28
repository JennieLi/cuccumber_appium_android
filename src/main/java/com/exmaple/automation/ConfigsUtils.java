/**
 * Copyright (C) 2013 Myriad Group AG. All Rights Reserved.
 */

package com.exmaple.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsUtils {
    public static String CONFIG_FILE_PATH = "conf/config.properties";

    private Properties mConfig;

    /**
     * Utils to load properties from configure file.
     */
    public ConfigsUtils() {
        mConfig = new Properties();
        try {
            mConfig.load(new FileInputStream(CONFIG_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the value of property defined in the configure file.
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
    	if (mConfig.containsKey(key)){
    		return mConfig.getProperty(key);
    	}else{
    		System.out.println("[ERROR] Not defined property key: " + key);
    		return null;
    	}
        
    }
}
