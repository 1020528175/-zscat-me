package com.zscat.wap;

/**
 * 错误码基类
 * 定义公共的错误码，每个具体模块的错误码要继承该类，以方便封装返回数据时可以直接调用：
 * <code>JsonResult getFailResult(WapErrorMsg errorMsg);</code>
 *
 * @author likaige
 * @date 2017-06-06
 */
public class WapErrorMsg {

    public static final WapErrorMsg ERROR_SUCCESS = new WapErrorMsg(0, "success");
    public static final WapErrorMsg ERROR_AUTH_FAIL = new WapErrorMsg(10010, "认证失败或者未登录");
    public static final WapErrorMsg ERROR_CRACKPWD_FAIL = new WapErrorMsg(1002, "解密失败");

    public static final WapErrorMsg ERROR_SERIALIZE_EXCEPTION = new WapErrorMsg(100001, "序列化异常");
    public static final WapErrorMsg ERROR_UN_SERIALIZE_EXCEPTION = new WapErrorMsg(100002, "反序列化异常");
    public static final WapErrorMsg ERROR_API_FAIL = new WapErrorMsg(100003, "接口请求失败");

    private int code;
    private String msg;

    public WapErrorMsg() {
    }

    public WapErrorMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public WapErrorMsg setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public WapErrorMsg setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
