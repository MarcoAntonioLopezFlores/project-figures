package com.at.internship.utils;

import com.at.internship.constants.Messages;
import com.at.internship.enums.FiguresEnum;
import com.at.internship.enums.OperationsEnum;

public class BuilderMenu {

    public String makeMenuMain(String title){
        StringBuilder textMenu = new StringBuilder(title);
        OperationsEnum[] processes = OperationsEnum.values();
        for(OperationsEnum p : processes) {
            textMenu.append(String.format(Messages.FORMATO_OPCIONES, p.getOption(), p.getName()));
        }
        return textMenu.toString();
    }

    public String makeMenuFigures(String title){
        StringBuilder textMenu = new StringBuilder(title);
        FiguresEnum[] figures = FiguresEnum.values();
        for(FiguresEnum f : figures) {
            textMenu.append(String.format(Messages.FORMATO_OPCIONES, f.getOption(), f.getName()));
        }
        return textMenu.toString();
    }
}
