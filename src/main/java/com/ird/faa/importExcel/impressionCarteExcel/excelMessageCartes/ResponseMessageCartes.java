package com.ird.faa.importExcel.impressionCarteExcel.excelMessageCartes;

public class ResponseMessageCartes {
    private String message;
    public ResponseMessageCartes(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}