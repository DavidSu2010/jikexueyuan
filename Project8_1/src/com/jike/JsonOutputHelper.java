package com.jike;

import net.sf.json.JSONObject; 

public class JsonOutputHelper implements IOutputHelper {

	@Override
	public String outputcontent(Employee employee) {
		// TODO Auto-generated method stub
		JSONObject json = JSONObject.fromObject(employee);//将java对象转换为json对象  
        String jsonstr = json.toString();//将json对象转换为字符串  
		return jsonstr;
	}

}
