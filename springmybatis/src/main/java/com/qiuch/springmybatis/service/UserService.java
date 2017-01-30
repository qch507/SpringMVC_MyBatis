package com.qiuch.springmybatis.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qiuch.springmybatis.dao.UserInfoMapper;
import com.qiuch.springmybatis.pojo.UserInfo;

@Service("userService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserService {

	@Resource
	private UserInfoMapper userInfoMapper;

	public UserInfo getUser() {
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1l);
		if (userInfo == null) {
			addUser();
			userInfo = userInfoMapper.selectByPrimaryKey(1l);
		}
		return userInfo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(10);
		userInfo.setCreateTime(new Date());
		userInfo.setGender("male");
		userInfo.setName("test");
		userInfoMapper.insertSelective(userInfo);
	}

}
