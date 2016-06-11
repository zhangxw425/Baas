package fruitstore;

import java.io.IOException;

import me.chanjar.weixin.common.exception.WxErrorException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.alibaba.fastjson.JSONObject;
import com.justep.baas.action.ActionContext;

public class Merchant {
	public static JSONObject service(JSONObject params, ActionContext context) throws JsonGenerationException, JsonMappingException, IOException, WxErrorException{
		System.out.println("我的方法进入了。。。。");
		return null;
	}
}
