package com.at.internship.enums;

public enum OperationsEnum {
    REGISTER_CALCULATE("Registrar nuevo cálculo de figura",1),
    OPEN_FILES("Abrir archivos con cálculos generados", 2),
    EXIT("Salir del programa", 3);

    private final String name;
    private final int option;

    OperationsEnum(String name, int option) {
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
