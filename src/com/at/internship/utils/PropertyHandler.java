package com.at.internship.utils;

import java.io.*;
import java.util.Properties;

public class PropertyHandler {

    private PropertyHandler() {}

    private static final String PROP_PROPS_FILE = "com.at.internship.propsFile";

    /**
     * @param defaultPropsFile from classpath
     * @param configPropsFile anywhere in filesystem
     */
    public static void load(String defaultPropsFile, String configPropsFile) throws IOException {
        Properties defaultProps = new Properties(System.getProperties());
        InputStream in = PropertyHandler.class.getResourceAsStream(defaultPropsFile);
        defaultProps.load(in);
        if (in != null) {
            in.close();
        }

        Properties appProps = new Properties(defaultProps);

        try {
            in = new FileInputStream(configPropsFile);
        } catch (FileNotFoundException e) {
            if(!new File(configPropsFile).createNewFile()) {
                System.err.printf("Failed to create file %s", configPropsFile);
                System.exit(1);
            }
            in = new FileInputStream(configPropsFile);
        }
        appProps.load(in);
        in.close();

        System.setProperties(appProps);
        System.setProperty(PROP_PROPS_FILE, configPropsFile);
    }

    public static String getStringProperty(String key) {
        return System.getProperty(key);
    }

}
