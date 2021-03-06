package com.at.internship.utils;

import com.at.internship.constants.Constants;
import com.at.internship.enums.FiguresEnum;
import com.at.internship.enums.OperationsEnum;

import java.io.File;
import java.util.Map;

public class BuilderMenu {

    public String makeMenuMain(String title){
        StringBuilder textMenu = new StringBuilder(title);
        OperationsEnum[] processes = OperationsEnum.values();
        for(OperationsEnum p : processes) {
            textMenu.append(String.format(Constants.FORMAT_OPTIONS, p.getOption(), p.getName()));
        }
        return textMenu.toString();
    }

    public String makeMenuFigures(String title){
        StringBuilder textMenu = new StringBuilder(title);
        FiguresEnum[] figures = FiguresEnum.values();
        for(FiguresEnum f : figures) {
            textMenu.append(String.format(Constants.FORMAT_OPTIONS, f.getOption(), f.getName()));
        }
        return textMenu.toString();
    }

    public String makeMenuDirectories(String title, Map<Integer, File> directories){
        StringBuilder textMenu = new StringBuilder(title);
        directories.forEach((option, file) -> textMenu.append(String.format(Constants.FORMAT_OPTIONS, option, file.getName())) );
        return textMenu.toString();
    }
}
