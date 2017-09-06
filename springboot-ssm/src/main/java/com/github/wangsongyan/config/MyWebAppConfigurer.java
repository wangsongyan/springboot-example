/**
 * 
 */
package com.github.wangsongyan.config;

import net.kmeb.oa.mvc.service.CustomDateConverter;
import net.kmeb.oa.mvc.service.CustomTrimConvert;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.wangsongyan.interceptor.MyInterceptor1;

/**
 * @author songy
 * @date 2017年8月10日 下午5:11:30 
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{

    @Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new CustomTrimConvert());
		registry.addConverter(new CustomDateConverter());
		super.addFormatters(registry);
	}

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
	
    
    
}
