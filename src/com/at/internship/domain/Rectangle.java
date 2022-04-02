package com.at.internship.domain;
import com.at.internship.constants.Messages;
import com.at.internship.interfaces.IFigure;

import static com.at.internship.constants.Constants.NUMBER_FORMAT;

public class Rectangle implements IFigure {

    private double base;
    private double height;

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return (this.base * 2) + (this.height * 2);
    }

    @Override
    public double calculateArea() {
        return this.base * this.height;
    }

    @Override
    public String readAttributes() {
        return String.format(Messages.MENSAJE_PROPIEDADES_RECTANGULO,  NUMBER_FORMAT.format(height),  NUMBER_FORMAT.format(base));
    }
}
