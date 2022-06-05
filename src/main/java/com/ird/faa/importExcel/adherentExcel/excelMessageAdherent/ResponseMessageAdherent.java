package com.ird.faa.importExcel.adherentExcel.excelMessageAdherent;


public class ResponseMessageAdherent {
    private String message;
    public ResponseMessageAdherent(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}