package com.jidouauto.log.base;

public enum LogCode {
    RC_PARAMETER_ERROR(1002, "Parameter error,Please check parameters！"),
    RC_RESULT_EMPTY(1001, "result data is empty"),
    RC_SUCCESS(1, "success");

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
