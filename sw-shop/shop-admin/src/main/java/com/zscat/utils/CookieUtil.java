package com.zscat.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/5 0005.
 */
public class CookieUtil {
    private CookieUtil() {
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