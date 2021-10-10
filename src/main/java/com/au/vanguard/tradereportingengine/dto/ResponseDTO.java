package com.au.vanguard.tradereportingengine.dto;

public class ResponseDTO<T> {

    private boolean success = true;

    private String code;

    private String message;

    private T content;

    public ResponseDTO() {
    }

    public ResponseDTO(boolean success, String code, String message, T content) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("\"success\":\"").append(success);
        sb.append("\", \"code\":\"").append(code);
        sb.append("\", \"message\":\"").append(message);
        sb.append("\", \"content\":\"").append(content);
        sb.append("\"}");
        return sb.toString();
    }



}
