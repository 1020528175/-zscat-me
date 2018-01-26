package com.zscat.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zsCat.common.base.Tree;
import com.zsCat.common.common.utils.BuildTree;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zscat.system.dao.DeptDao;
import com.zscat.system.dao.UserDao;
import com.zscat.system.dao.UserRoleDao;
import com.zscat.system.domain.DeptDO;
import com.zscat.system.domain.UserDO;
import com.zscat.system.domain.UserRoleDO;
import com.zscat.system.service.UserService;

import javax.annotation.Resource;

@Transactional
@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userMapper;
	@Autowired
	UserRoleDao userRoleMapper;
	@Autowired
	DeptDao deptMapper;



	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public UserDO get(Long id) {
		List<Long> roleIds = userRoleMapper.listRoleId(id);
		UserDO user = userMapper.get(id);
		user.setDeptName(deptMapper.get(user.getDeptId()).getName());
		user.setroleIds(roleIds);
		return user;
	}

	@Override
	public List<UserDO> list(Map<String, Object> map) {
		return userMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return userMapper.count(map);
	}

	@Transactional
	@Override
	public int save(UserDO user) {
		int count = userMapper.save(user);
		Long userId = user.getUserId();
		List<Long> roles = user.getroleIds();
		userRoleMapper.removeByUserId(userId);
		List<UserRoleDO> list = new ArrayList<>();
		for (Long roleId : roles) {
			UserRoleDO ur = new UserRoleDO();
			ur.setUserId(userId);
			ur.setRoleId(roleId);
			list.add(ur);
		}
		if (list.size() > 0) {
			userRoleMapper.batchSave(list);
		}
		return count;
	}
	@Override
	public int saveOnly(UserDO user) {
		return userMapper.save(user);
	}
	public int updateOnly(UserDO user) {
		return userMapper.update(user);
	}
	@Override
	public int update(UserDO user) {
		int r = userMapper.update(user);
		Long userId = user.getUserId();
		List<Long> roles = user.getroleIds();
		userRoleMapper.removeByUserId(userId);
		List<UserRoleDO> list = new ArrayList<>();
		for (Long roleId : roles) {
			UserRoleDO ur = new UserRoleDO();
			ur.setUserId(userId);
			ur.setRoleId(roleId);
			list.add(ur);
		}
		if (list.size() > 0) {
			userRoleMapper.batchSave(list);
		}
		return r;
	}

	@Override
	public int remove(Long userId) {
		userRoleMapper.removeByUserId(userId);
		return userMapper.remove(userId);
	}

	@Override
	public boolean exit(Map<String, Object> params) {
		boolean exit;
		exit = userMapper.list(params).size() > 0;
		return exit;
	}

	@Override
	public Set<String> listRoles(Long userId) {
		return null;
	}

	@Override
	public int resetPwd(UserDO user) {
		int r = userMapper.update(user);
		return r;
	}

	@Transactional
	@Override
	public int batchremove(Long[] userIds) {
		int count = userMapper.batchRemove(userIds);
		userRoleMapper.batchRemoveByUserId(userIds);
		return count;
	}

	@Override
	public Tree<DeptDO> getTree() {
		List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
		List<DeptDO> SysDepts = deptMapper.list(new HashMap<String, Object>());
		Long[] pDepts = deptMapper.listParentDept();
		Long[] uDepts = userMapper.listAllDept();
		Long[] allDepts = (Long[]) ArrayUtils.addAll(pDepts, uDepts);
		for (DeptDO SysDept : SysDepts) {
			if (!ArrayUtils.contains(allDepts, SysDept.getDeptId())) {
				continue;
			}
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(SysDept.getDeptId().toString());
			tree.setParentId(SysDept.getParentId().toString());
			tree.setText(SysDept.getName());
			Map<String, Object> state = new HashMap<>();
			state.put("opened", true);
			state.put("mType", "dept");
			tree.setState(state);
			trees.add(tree);
		}
		List<UserDO> users = userMapper.list(new HashMap<String, Object>());
		for (UserDO user : users) {
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(user.getUserId().toString());
			tree.setParentId(user.getDeptId().toString());
			tree.setText(user.getName());
			Map<String, Object> state = new HashMap<>();
			state.put("opened", true);
			state.put("mType", "user");
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptDO> t = BuildTree.build(trees);
		return t;
	}
	/**
	 * 合并微信用户信息
	 *
	 * @param wxOauthCode
	 * @return
	 */
	@Override
	public UserDO mergeUserInfo(String wxOauthCode) {
		return null;
	}

	/**
	 * 获取微信用户
	 *
	 * @param wxOauthCode
	 * @return
	 */
	@Override
	public UserDO getByWxOauthCode(String wxOauthCode) throws WxErrorException {
		/*WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(wxOauthCode);
		WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(accessToken, "zh_CN");

		UserDO user = toUserDO(wxMpUser);

		UserDO user2 = getByWxOpenId(user.getWxOpenId());

		return null == user2 ? user : user2;*/
		return null;
	}

	private UserDO toUserDO(WxMpUser wxMpUser) {
		UserDO user = new UserDO();
		user.setWxAvatar(wxMpUser.getHeadImgUrl());
		user.setName(wxMpUser.getNickname());
		user.setWxOpenId(wxMpUser.getOpenId());
		user.setWxUnionid(wxMpUser.getUnionId());
		return user;
	}


	/**
	 * 根据 微信openid查询
	 *
	 * @param openid
	 * @return
	 */
	@Override
	public UserDO getByWxOpenId(String openid) {
		UserDO promotionUser = new UserDO();
		promotionUser.setWxOpenId(openid);
		Map map =new HashMap();
		map.put("wxOpenId",openid);
		List<UserDO> list = userMapper.list(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
