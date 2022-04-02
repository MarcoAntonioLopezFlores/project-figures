package com.at.internship.domain;

import com.at.internship.constants.Messages;
import com.at.internship.interfaces.IFigure;

import static com.at.internship.constants.Constants.NUMBER_FORMAT;

public class Circle implements IFigure {
    private double radio;

    public Circle(double radio) {
        this.radio = radio;
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (this.radio * 2);
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public String readAttributes() {
        return String.format(Messages.MENSAJE_PROPIEDADES_CIRCULO, NUMBER_FORMAT.format(radio));
    }
}
