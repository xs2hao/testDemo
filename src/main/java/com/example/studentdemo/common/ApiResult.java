// ApiResult.java
package com.example.studentdemo.common;

public class ApiResult<T> {
    private boolean success;
    private String message;
    private T data;
    private Integer code;

    // 成功状态码
    public static final Integer CODE_SUCCESS = 200;
    // 失败状态码
    public static final Integer CODE_ERROR = 500;
    // 未找到状态码
    public static final Integer CODE_NOT_FOUND = 404;

    public ApiResult() {}

    public ApiResult(boolean success, String message, T data, Integer code) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    // 成功响应
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, "操作成功", data, CODE_SUCCESS);
    }

    public static <T> ApiResult<T> success(String message, T data) {
        return new ApiResult<>(true, message, data, CODE_SUCCESS);
    }

    // 失败响应
    public static <T> ApiResult<T> error(String message) {
        return new ApiResult<>(false, message, null, CODE_ERROR);
    }

    // 未找到响应
    public static <T> ApiResult<T> notFound(String message) {
        return new ApiResult<>(false, message, null, CODE_NOT_FOUND);
    }

    // Getter 和 Setter
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
}