/**
 * 
 */
package com.github.wangsongyan.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author songy
 * @date 2017年8月8日 下午4:02:21 
 */
@Component
public class TestUtils {

	@Value("${server.port}")
	private String port;
	
	public String getPort(){
		return port;
	}
}
