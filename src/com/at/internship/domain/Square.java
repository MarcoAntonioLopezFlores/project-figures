package com.at.internship.domain;
import com.at.internship.constants.Messages;
import com.at.internship.interfaces.IFigure;

import static com.at.internship.constants.Constants.NUMBER_FORMAT;

public class Square implements IFigure {

    private double side;

    public Square(double side) {
        this.side = side;
    }
    @Override
    public double calculatePerimeter() {
        return this.side * 4;
    }

    @Override
    public double calculateArea() {
        return Math.pow(this.side, 2);
    }

    @Override
    public String readAttributes() {
        return String.format(Messages.MENSAJE_PROPIEDADES_CUADRADO,  NUMBER_FORMAT.format(side));
    }
}
