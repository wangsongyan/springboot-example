package com.example;
import org.json.JSONException;
import org.json.JSONObject;


class JSONResult{
    public static String fillResultString(Integer status, String message, Object result){
        JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(){{
			    put("status", status);
			    put("message", message);
			    put("result", result);
			}};
			return jsonObject.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "";
    }
}
