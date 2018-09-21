package com.chaoscoffee.result;

import com.chaoscoffee.result.base.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chaoscoffee
 * @date 2018/9/20
 * @description
 */
public class Results {

    private static final int OK = 0;

    private static final int FAIL = 1;

    private Results() {

    }

    public static Result ok(Object dada) {
        return new Result(OK, dada, null);
    }

    public static Result kvOk(String key, Object value) {
        Map<String, Object> data = new HashMap(2);
        data.put(key, value);
        return ok(data);
    }

    public static Result noOk(String message) {
        return new Result(FAIL, null, message);
    }

    public static Result newResult(int code, Object data, String message) {
        return new Result(code, data, message);
    }


}
