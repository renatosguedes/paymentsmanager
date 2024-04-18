package com.example.paymentsmanager.entities.dtos;

public class ErrorResponse {

    private Long timestamp;
    private Integer statusCode;
    private String errorMessage;

    public ErrorResponse(Long timestamp, Integer statusCode, String errorMessage) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
