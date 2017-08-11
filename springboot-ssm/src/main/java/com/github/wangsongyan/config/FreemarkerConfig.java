/**
 * 
 */
package com.github.wangsongyan.config;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import cn.org.rapid_framework.freemarker.directive.BlockDirective;
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective;
import cn.org.rapid_framework.freemarker.directive.OverrideDirective;
import freemarker.template.TemplateModelException;

/**
 * @author songy
 * @date 2017年8月11日 上午10:40:33 
 */
@Configuration
public class FreemarkerConfig {

	@Value("${project-env.contextPath}")
	private String contextPath;
	
	@Value("${project-env.smsurl}")
	private String smsurl;
	
	@Value("${project-env.baiduAk}")
	private String baiduAk;
	
	@Resource
	private freemarker.template.Configuration configuration;
	
	@PostConstruct
    public void setSharedVariable(){
        configuration.setSharedVariable("block", new BlockDirective());
        configuration.setSharedVariable("override", new OverrideDirective());
        configuration.setSharedVariable("extends", new ExtendsDirective());
        
        try {
			configuration.setSharedVariable("contextPath", contextPath);
			configuration.setSharedVariable("staticPath", contextPath+"/static");
			configuration.setSharedVariable("smsurl", smsurl);
			configuration.setSharedVariable("baiduAk", baiduAk);
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}
    }
	
}
