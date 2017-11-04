package com.pure.jd.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by pure on 2017/6/30.
 */
@Getter
@Setter
public class Result {
    private String message = "";
    private boolean success = true;
    private String code = "200";
    private Object obj;

    public Result() {
    }

    public Result(String message, boolean success, String code, Object obj) {
        this.message = message;
        this.success = success;
        this.code = code;
        this.obj = obj;
    }

    public Result(Object obj) {
        this.obj = obj;
    }
}
