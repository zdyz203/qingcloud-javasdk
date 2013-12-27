package com.qingcloud.model.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.qingcloud.model.Image;


public class TestIns {
	public Map<String,Object> generateData() throws NoSuchFieldException, Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields){
			Object obj = field.get(this);
			if(null != obj && !"".equals(obj.toString()) && !"instance_id".equals(field.getName())){
				map.put(field.getName(), obj.toString());
			}
		}
		return map;
	}
	public static void main(String[] args) {
		Image i = new Image();
		i.setImage_id("");
	}
}	
