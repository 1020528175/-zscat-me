package com.zscat.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zsCat.common.base.Tree;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Service;

import com.zscat.system.domain.DeptDO;
import com.zscat.system.domain.UserDO;

@Service
public interface UserService {
	UserDO get(Long id);

	List<UserDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserDO user);
	int saveOnly(UserDO user);

	int update(UserDO user);
	int updateOnly(UserDO user);
	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	int resetPwd(UserDO user);

	Tree<DeptDO> getTree();
	/**
	 * 合并微信用户信息
	 *
	 * @param wxOauthCode
	 * @return
	 */
	UserDO mergeUserInfo(String wxOauthCode);

	/**
	 * 获取微信用户
	 *
	 * @param wxOauthCode
	 * @return
	 */
	UserDO getByWxOauthCode(String wxOauthCode) throws WxErrorException;

	/**
	 * 根据 微信openid查询
	 * @param openid
	 * @return
	 */
	UserDO getByWxOpenId(String openid);
}
