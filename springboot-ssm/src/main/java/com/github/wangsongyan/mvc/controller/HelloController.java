/**
 * 
 */
package com.github.wangsongyan.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.wangsongyan.component.TestUtils;
import com.github.wangsongyan.mvc.service.TestService;

/**
 * @author songy
 * @date 2017年8月8日 下午3:51:57 
 */
@Controller
public class HelloController {

	@Resource
	private TestUtils testUtils;
	
	@Resource
	private TestService testService;
	
	@RequestMapping("/")
	@ResponseBody
	public String greeting() {
		return "Hello World!";
	}
	
	@RequestMapping("/freemarker")
	public String freemarker(){
		return "son";
	}
	
	@RequestMapping("/inject")
	@ResponseBody
	public String inject(){
		return testUtils.getPort()+testService.test();
	}
}
