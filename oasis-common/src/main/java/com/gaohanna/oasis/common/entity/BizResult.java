package com.gaohanna.oasis.common.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * something
 *
 * @author keben
 * @date 2017/12/15
 */
public class BizResult<T> implements Serializable{
    private static final long serialVersionUID = -7501088012188035089L;

    private boolean success = false;
    private String code;
    private String message;
    private T data;
    private Map<String, Object> extraInfo;


    public static <T> BizResult<T> success(T data) {
        return create(data);
    }

    public static <T> BizResult<T> empty() {
        BizResult result = create();
        result.setSuccess(true);
        return result;
    }

    public static <T> BizResult<T> error(String code, String message) {
        return create(code, message);
    }

    public static <T, S> BizResult<T> error(BizResult<S> errorBizResult) {
        return error(errorBizResult.getCode(), errorBizResult.getMessage());
    }

    public static <T> BizResult<T> paramsError(String msg) {
        return error(ErrorCodeEnum.PARAM_ERROR.getErrCode(), ErrorCodeEnum.PARAM_ERROR.getErrMsg() + "：" + msg);
    }

    public static <T> BizResult<T> bizError(String msg) {
        return error(ErrorCodeEnum.BIZ_EXCEPTION.getErrCode(), ErrorCodeEnum.BIZ_EXCEPTION.getErrMsg() + "：" + msg);
    }

    public static <T> BizResult<T> systemError(String msg) {
        return error(ErrorCodeEnum.EXCEPTION.getErrCode(), ErrorCodeEnum.EXCEPTION.getErrMsg() + "：" + msg);
    }

    public static <T> BizResult<T> create() {
        return new BizResult();
    }

    public static <T> BizResult<T> create(T data){
        BizResult bizResult = create();
        bizResult.setSuccess(true);
        bizResult.setData(data);
        return bizResult;
    }

    public static <T> BizResult<T> create(T data, String code, String message) {
        BizResult result = create();
        result.setSuccess(true);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> BizResult<T> create(T data, boolean isSuccess, String code, String message) {
        BizResult result = create();
        result.setSuccess(isSuccess);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> BizResult<T> create(T data, Map<String, Object> extraInfo) {
        BizResult bizResult = create();
        bizResult.setSuccess(true);
        bizResult.setData(data);
        bizResult.setExtraInfo(extraInfo);
        return bizResult;
    }

    public static <T> BizResult<T> create(T data, Map<String, Object> extraInfo, boolean isSuccess, String code, String message) {
        BizResult bizResult = create();
        bizResult.setSuccess(true);
        bizResult.setData(data);
        bizResult.setExtraInfo(extraInfo);
        bizResult.setSuccess(isSuccess);
        bizResult.setCode(code);
        bizResult.setMessage(message);
        return bizResult;
    }

    public static <T> BizResult<T> create(String code, String message) {
        BizResult bizResult = create();
        bizResult.setSuccess(false);
        bizResult.setCode(code);
        bizResult.setMessage(message);
        return bizResult;
    }

    public static <T> BizResult<T> create(ErrorCodeEnum errorCodeEnum) {
        BizResult bizResult = create();
        bizResult.setSuccess(false);
        bizResult.setCode(errorCodeEnum.getErrCode());
        bizResult.setMessage(errorCodeEnum.getErrMsg());
        return bizResult;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Map<String, Object> extraInfo) {
        this.extraInfo = extraInfo;
    }
}
