package com.example.springmybatis.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmybatis.dao.UserInfoMapper;
import com.example.springmybatis.pojo.UserInfo;

@Service("categoryService")
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
