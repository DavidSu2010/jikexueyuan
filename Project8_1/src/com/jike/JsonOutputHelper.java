package com.jike;

import net.sf.json.JSONObject; 

public class JsonOutputHelper implements IOutputHelper {

	@Override
	public String outputcontent(Employee employee) {
		// TODO Auto-generated method stub
		JSONObject json = JSONObject.fromObject(employee);//��java����ת��Ϊjson����  
        String jsonstr = json.toString();//��json����ת��Ϊ�ַ���  
		return jsonstr;
	}

}
