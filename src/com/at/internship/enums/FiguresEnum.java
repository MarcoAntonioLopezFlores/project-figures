package com.at.internship.enums;

public enum FiguresEnum {
    CIRCLE("Circulo",1),
    SQUARE("Cuadrado", 2),
    RECTANGLE("Rectangulo", 3),
    EQUILATERAL_TRIANGLE("Triangulo equilatero", 4),
    ISOSCELES_TRIANGLE("Triangulo isosceles", 5);

    private final String name;
    private final int option;

    FiguresEnum(String name, int option) {
        this.name = name;
        this.option = option;
    }

    public String getName() {
        return name;
    }

    public int getOption() {
        return option;
    }
}
