package com.example.estock.exceptions;

public class EStockNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EStockNotFoundException() {
        super();
    }

    public EStockNotFoundException(String message) {
        super(message);
    }

}
