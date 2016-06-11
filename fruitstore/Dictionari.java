package fruitstore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSONObject;
import com.justep.baas.Utils;
import com.justep.baas.action.ActionContext;
import com.justep.baas.data.DataUtils;
import com.justep.baas.data.Table;
import com.justep.baas.data.Transform;

public class Dictionari {
	//查询参数信息是的参数类型的参数CODE名称：paramCode
	public static final String PARAM_CODE_NAME = "paramCode";
	//打印日志
	public static final Logger logger = Logger.getLogger("Dictionari");
	/**
	 * 请求反馈模块参数
	 * @param params
	 * @param actionContext
	 * @return
	 * @throws Exception
	 */
	public static JSONObject findParamsByCode(JSONObject params, ActionContext context) throws Exception{
		JSONObject reulstDatas = new JSONObject();
		//logger.info("进入Param.findParamsByTypeCode（）方法,参数为:"+params);
		Connection connection = null;
		try {
			connection = context.getConnection(Constants.DATA_BASE_SOURCE);
			String sql = "select t.* from sys_dictionaries t INNER join sys_dictionaries t1 on t.PARENT_ID = t1.ZD_ID where t1.P_BM = ? order by t.ORDY_BY";
			Object paramCode = params.get(PARAM_CODE_NAME);
			List<Object> queryParamLists = new ArrayList<Object>();
			if(Utils.isNull(paramCode)){
				queryParamLists.add("feedBackModel");
			}else{
				queryParamLists.add(paramCode);
			}
			//查询到的参数结果集
			Table paramDatas = DataUtils.queryData(connection, sql, queryParamLists, null, null, null);
			if(null != paramDatas){
				reulstDatas = Transform.tableToJson(paramDatas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return reulstDatas;
	}
	
}
