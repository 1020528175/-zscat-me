/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsCat.common.common.utils;




import com.zsCat.common.base.Constant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * cookie 工具类
 *
 * @fileName : CookieUtil.java
 * @encoding : UTF-8
 * @author : zscat
 * @version : 1.0
 * @created on  : 2017/6/28  下午4:18
 */
public class CookieUtil {

    /**
     * <pre>
     *  根据cookie key获取cookie对象
     * </pre>
     *
     * @param key String Cooke name
     * @return Cookie
     */
    public static Cookie getCookie(String key) {
        Cookie cookie = null;
        Cookie[] cookieArr = RequestUtil.getRequest().getCookies();
        if (cookieArr != null) {
            for (Cookie cookieObj : cookieArr) {
                if (cookieObj.getName().equals(key)) {
                    cookie = cookieObj;
                    break;
                }
            }
        }
        return cookie;
    }

    /**
     * <pre>
     *  根据cookie key获取Cooke值
     * </pre>
     *
     * @param key String Cookie name
     * @return String
     */
    public static String getCookieValue(String key) {
        String value = "";
        Cookie cookie = getCookie(key);
        if (cookie != null) {
            value = cookie.getValue();
        }
        return value;
    }

    /**
     * 根据key判断当
     *
     * @param key String
     * @return boolean
     */
    public static boolean contains(String key) {
        boolean result = false;

        Cookie cookie = getCookie(key);
        if (cookie != null) {
            result = true;
        }
        return result;
    }



    /**
     * 从cookie取 token
     *
     * @return String
     */
    public static String getToken() {
        String leId = null;
        Cookie cookie = getCookie(Constant.SESSION_USER_KEY);
        if (cookie != null) {
            leId = cookie.getValue();
        }
        return leId;

    }
    /**
     * 添加cookie
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * 删除cookie
     *
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletResponse response, String name) {
        Cookie uid = new Cookie(name, null);
        uid.setPath("/");
        uid.setMaxAge(0);
        response.addCookie(uid);
    }

    /**
     * 获取cookie值
     *
     * @param request
     * @return
     */
    public static String getUid(HttpServletRequest request, String cookieName) {
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static void addGoodsToCookie(HttpServletRequest request, HttpServletResponse response,Long id) {
        Cookie[] cookieArray = request.getCookies();
        String recorder = "";
        String allrecorder = "";
        if (cookieArray != null) {
            for (Cookie cookie : cookieArray) {
                //recorder是预先设计的Key值
                if ("recorder".equals(cookie.getName())) {
                    recorder = cookie.getValue();
                    //这里预先设置每个pid之间利通“-”分割
                    String[] pids = recorder.split("-");
                    //保证List集合中没有重复pid
                    //并且最新的pid永远放在链表的前面
                    //这里常进行插入操作，所以用链表
                    List<String> list = Arrays.asList(pids);
                    LinkedList<String> linkedList = new LinkedList<String>(list);
                    if (recorder.contains(id+"")) {
                        linkedList.remove(id+"");
                    }
                    linkedList.addFirst(id+"");
                    StringBuffer stringBuffer = new StringBuffer();
                    //从链表中恢复前num个字符串，
                    for (int i = 0; i < linkedList.size() && i < 30; i++) {
                        stringBuffer.append(linkedList.get(i) + "-");
                    }
                    recorder = stringBuffer.toString();
                    recorder = recorder.substring(0, recorder.length() - 1);
                }
            }
            Cookie ck = new Cookie("recorder", recorder);
            ck.setMaxAge(60 * 60 * 24);
            response.addCookie(ck);
        }
    }
}
