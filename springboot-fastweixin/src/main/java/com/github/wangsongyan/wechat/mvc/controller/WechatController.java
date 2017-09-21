/**
 * 
 */
package com.github.wangsongyan.wechat.mvc.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
import com.github.wangsongyan.wechat.mvc.service.TulingRobotService;

/**
 * @author songy
 * @date 2017年8月14日 下午1:48:08 
 */
@RestController
@RequestMapping("/weixin")
public class WechatController extends WeixinControllerSupport {
        private static final Logger log = LoggerFactory.getLogger(WechatController.class);
       
        @Value("${wechat.token}")
        private String token;
        
        @Resource
    	private TulingRobotService robotService;
        
        //设置TOKEN，用于绑定微信服务器
        @Override
        protected String getToken() {
            return token;
        }

        //重写父类方法，处理对应的微信消息
        @Override
        protected BaseMsg handleTextMsg(TextReqMsg msg) {
            String content = msg.getContent();
            log.debug("用户发送到服务器的内容:{}", content);
            return new TextMsg(robotService.contact(content, msg.getFromUserName()));
        }
}
