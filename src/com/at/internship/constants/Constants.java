package com.at.internship.constants;

import com.at.internship.utils.PropertyHandler;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class Constants {

    private static final String PROP_UNITY = "com.at.internship.unity";
    private static final String PROP_DIRECTORY = "com.at.internship.directory";
    private static final String PROP_EXTENSION = "com.at.internship.extension";

    static{
        try {
            PropertyHandler.load("/application-default.properties", "application.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String PATH = PropertyHandler.getStringProperty(PROP_DIRECTORY);
    public static final String PATH_FILE_CREATE = PATH+"%s";
    public static final String FILE_INPUT = "%s."+PropertyHandler.getStringProperty(PROP_EXTENSION);
    public static final String SEPARATOR_FILES = ",";
    public static final String UNITY_MEASURE = PropertyHandler.getStringProperty(PROP_UNITY);
    public static final String FORMAT_OPTIONS = "\n%s - %s";
    public static final String NAME_SEPARATOR = "\ncoma";
    public static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance(Locale.ENGLISH);
}
