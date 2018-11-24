package com.jidouauto.log.base;

public enum LogCode {
    RC_SUCCESS(1, "success"),
    RC_RESULT_EMPTY(501, "result data is empty");

    private int code;
    private String message;

    LogCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
