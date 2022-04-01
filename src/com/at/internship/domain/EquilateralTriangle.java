package com.at.internship.domain;

import com.at.internship.abstracts.Triangle;
import com.at.internship.constants.Messages;

public class EquilateralTriangle extends Triangle {
    private double side;

    public EquilateralTriangle(double side){
        this.side = side;
        this.height = calculateHeight();

    }

    @Override
    public double calculateHeight() {
        return (Math.sqrt(3)*this.side)/2;
    }

    @Override
    public double calculatePerimeter() {
        return this.side * 3;
    }

    @Override
    public double calculateArea() {
        return (this.side * this.height)/2;
    }

    @Override
    public String readAttributes() {
        return String.format(Messages.MENSAJE_PROPIEDADES_TRIANGULO_EQUILATERO, height,side);
    }
}
