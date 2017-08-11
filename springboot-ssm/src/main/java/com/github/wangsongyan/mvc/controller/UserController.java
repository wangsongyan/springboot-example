/**
 * 
 */
package com.github.wangsongyan.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.wangsongyan.mvc.model.entity.gen.User;
import com.github.wangsongyan.mvc.service.UserService;

/**
 * @author songy
 * @date 2017年8月10日 下午4:13:42 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("")
	public String index(String id,Model model){
		model.addAttribute("user", userService.getUserById(id));
		return "profile";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(User user){
		return userService.insert(user);
	}
	
	@RequestMapping("/roles/{userId}")
	@ResponseBody
	public Object getRolesByUserId(@PathVariable String userId){
		return userService.getRolesByUserId(userId);
	}
	
}
