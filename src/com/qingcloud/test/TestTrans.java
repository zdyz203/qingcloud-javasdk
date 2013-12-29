package com.qingcloud.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.qingcloud.core.QingConnector;
import com.qingcloud.model.request.PublicRequest;
import com.qingcloud.model.response.PublicResponse;
import com.qingcloud.model.trans.Trans;

public class TestTrans {
	
	public static void main(String[] args) throws NoSuchFieldException, Exception {
		QingConnector qc = new QingConnector("https://api.qingcloud.com/iaas/","AHWWMNZAZANMVXEDYGOQ"
				,"tPDFuwrXLDEwdnhENhoS1hJYgzuTafm7Luxl2ywe");
		PublicRequest pr = new PublicRequest();
		pr.setZone("pek1");
		pr.setSignature_method("HmacSHA1");
		pr.setSignature_version("1");
		pr.setTime_stamp("2013-12-29T21:07:35Z");
		PublicResponse pres = qc.doTrans(pr,Trans.DescribeInstances);
		System.out.println(pres.getRet_code());
		System.out.println(pres.getMessage());
		System.out.println(pres.getInstance_set()[0].getCreate_time());
		System.out.println(pres.getInstance_set()[0].getImage_id());
		System.out.println(pres.getInstance_set()[0].getKeypair_ids());
		System.out.println(pres.getInstance_set()[0].getInstance_id());
		System.out.println(pres.getTotal_count());
	}
	
	
	
	
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
}
