package com.at.internship.exceptions;

import com.at.internship.enums.OperationsEnum;

public class ProcessAbortedException extends Exception {

    private final OperationsEnum process;

    public ProcessAbortedException(String message, OperationsEnum process) {
        super(message);
        this.process = process;
    }

    public OperationsEnum getProcess() {
        return process;
    }
}
