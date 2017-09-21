/**
 * 
 */
package com.github.wangsongyan.wechat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author songy
 * @date 2017年8月14日 下午1:44:10 
 */
@SpringBootApplication
@ComponentScan("com.github.wangsongyan")
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
