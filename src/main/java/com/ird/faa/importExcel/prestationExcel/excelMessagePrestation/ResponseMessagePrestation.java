package com.ird.faa.importExcel.prestationExcel.excelMessagePrestation;


public class ResponseMessagePrestation {
    private String message;
    public ResponseMessagePrestation(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}