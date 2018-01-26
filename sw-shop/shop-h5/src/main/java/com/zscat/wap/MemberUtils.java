package com.zscat.wap;


import com.zscat.config.ShiroUtils;
import com.zscat.shop.domain.TMemberDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @ClassName:SysUserUtils
 * @date:2015年2月4日 下午8:12:41
 * @author  ?
 */
public class MemberUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberUtils.class);
	public static final String SESSION_LOGIN_MEMBER = "MEMBER_LOGIN";


	/**
	 * 得到当前session
	 */
	public static HttpSession getSession() {
		HttpSession session = getCurRequest().getSession();
		return session;
	}
	

	
	/**
	 * @Title: getCurRequest
	 * @Description:(获得当前的request) 
	 * @param:@return 
	 * @return:HttpServletRequest
	 */
	public static HttpServletRequest getCurRequest(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if(requestAttributes != null && requestAttributes instanceof ServletRequestAttributes){
			ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
			return servletRequestAttributes.getRequest();
		}
		return null;
	}



	public static TMemberDO getSessionLoginUser() {
		return ShiroUtils.getUser();
	//	return (TMemberDO) getSession().getAttribute(MemberUtils.SESSION_LOGIN_MEMBER);
	}

}
