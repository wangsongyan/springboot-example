/**
 * 
 */
package com.github.wangsongyan.mvc.model.dao.customized;

import java.util.List;

import com.github.wangsongyan.mvc.model.entity.gen.Role;

/**
 * @author songy
 * @date 2017年8月10日 下午4:24:53 
 */
public interface UserDao {

	public List<Role> getRolesByUserId(String userId);
	
}
