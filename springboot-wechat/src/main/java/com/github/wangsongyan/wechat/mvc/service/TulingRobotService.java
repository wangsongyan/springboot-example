/**
 * 
 */
package com.github.wangsongyan.wechat.mvc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author songy
 * @date 2017年8月14日 下午2:04:02
 */
@Service
public class TulingRobotService {

	@Value("${tuling123.apikey}")
	private String apikey;
	
	private static final String REQUEST_URL = "http://www.tuling123.com/openapi/api?key=%s&info=%s&userid=%s";
	
	public String contact(String question,String userId){
		try{
			question = URLEncoder.encode(question, "utf-8");
			URL getUrl = new URL(String.format(REQUEST_URL, apikey, question, userId));
			//System.out.println(getUrl.toString());
			HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
			connection.connect();
	
			// 取得输入流，并使用Reader读取
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			// 断开连接
			connection.disconnect();
			return sb.toString();
		}catch(IOException exception){
			
		}
		return "internal server error";
	}

}
