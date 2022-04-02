package com.at.internship.domain;

import com.at.internship.abstracts.Triangle;
import com.at.internship.constants.Messages;

import static com.at.internship.constants.Constants.NUMBER_FORMAT;

public class IsoscelesTriangle extends Triangle {
    private double side;
    private double base;

    public IsoscelesTriangle(double side, double base){
        this.side=side;
        this.base=base;
        this.height=calculateHeight();
    }

    @Override
    public double calculateHeight() {
        return Math.sqrt(Math.pow(this.side,2)-(Math.pow(this.side,2)/4));
    }

    @Override
    public double calculatePerimeter() {
        return this.base+(this.side*2);
    }

    @Override
    public double calculateArea() {
        return (this.base * this.side)/2;
    }

    @Override
    public String readAttributes() {
        return String.format(Messages.MENSAJE_PROPIEDADES_TRIANGULO_ISOSCELES,
                NUMBER_FORMAT.format(height),
                NUMBER_FORMAT.format(side),
                NUMBER_FORMAT.format(base));
    }
}
