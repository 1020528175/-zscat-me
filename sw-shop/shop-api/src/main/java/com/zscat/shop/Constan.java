package com.zscat.shop;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public class Constan {

    public static final Byte GOODS_ORDER_STATUS_INIT = 0;
    public static final Byte GOODS_ORDER_STATUS_SUCCESS = 1;
    public static final Byte GOODS_ORDER_STATUS_COMPLETE = 2;
    public static final Byte GOODS_ORDER_STATUS_FAIL = -1;

    public static final Constan LOGIN = new Constan(1, "登录");
    public static final Constan REGISTER = new Constan(5, "注册");
    public static final Constan SUBMITORDER = new Constan(2, "提交订单");
    private int code;
    private String msg;

    public Constan() {
    }

    public Constan(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public Constan setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Constan setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
