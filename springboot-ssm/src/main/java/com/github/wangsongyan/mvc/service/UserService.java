/**
 * 
 */
package com.github.wangsongyan.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.wangsongyan.mvc.model.dao.customized.UserDao;
import com.github.wangsongyan.mvc.model.dao.gen.UserMapper;
import com.github.wangsongyan.mvc.model.entity.gen.Role;
import com.github.wangsongyan.mvc.model.entity.gen.User;

/**
 * @author songy
 * @date 2017年8月10日 下午4:12:17 
 */
@Service
public class UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private UserDao userDao;
	
	public boolean insert(User u){
		return userMapper.insertSelective(u) > 0;
	}
	
	public User getUserById(String id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	public List<Role> getRolesByUserId(String id){
		return userDao.getRolesByUserId(id);
	}
	
}
