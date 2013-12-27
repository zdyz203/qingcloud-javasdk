package com.qingcloud.model.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Test {
	/**
	 * 获取对象所有属性及属性值，并把不为空的返回map
	 * @return
	 * @throws Exception
	 * @throws NoSuchFieldException
	 */
	public Map<String,Object> generateData() throws Exception, NoSuchFieldException{
		Map<String,Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields){
			Object obj = field.get(this);
			if(null != obj && obj.getClass().isArray()){
				String[] objArray = (String[]) obj;
				int j = 1;
				for (int i = 0; i < objArray.length; i++){
					if(null != objArray[i] && !"".equals((objArray[i]))){
						map.put(field.getName()+"."+j, objArray[i]);
						j++;
					}
				}
			}else{
				if(null != obj && !"".endsWith(obj.toString())){
					map.put(field.getName(), obj.toString());
				}
			}
			
		}
		return map;
	}
	public static void main(String[] args) throws NoSuchFieldException, Exception {
//		List l = new ArrayList();
//		Collections.sort(l);
//		for (int i = 0; i < l.size(); i++) {
//			System.out.println(l.get(i));
//		}
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("a", "111");
//		map.put("b", "222");
//		TreeMap<String, Object> treemap = new TreeMap<String, Object>(map); 
		
//		for(Map.Entry<String, Object> entry : map.entrySet()){
//			
//			String key = entry.getKey();
//			
//			Object value = entry.getValue();
//			
//			System.out.println(key);
//		}
		//map排序
//		for(Map.Entry<String, Object> entry : treemap.entrySet()){
//			
//			String key = entry.getKey();
//
//		    Object value = entry.getValue();
//		    
//		    System.out.println(key);
//		}
		
//		EipsRequest e = new EipsRequest();
//		e.setEips0n("11111");
//		e.setStatusn("22222");
//		Map<String,Object> map = e.getData();
//		System.out.println(QingUtil.packageDataByList(map));
	}
}
