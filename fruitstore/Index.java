package fruitstore;

import java.sql.Connection;

import com.alibaba.fastjson.JSONObject;
import com.justep.baas.action.ActionContext;
import com.justep.baas.data.DataUtils;
import com.justep.baas.data.Table;
import com.justep.baas.data.Transform;

/**
 * 请求首页数据
 * @author zhangxiaowu
 *
 */
public class Index {

		/**
		 * 请求热卖商品数据(只取前10条数据)
		 * @param params
		 * @param actionContext
		 * @return
		 * @throws Exception
		 */
		public static JSONObject findHotGoodsDatas(JSONObject params, ActionContext context) throws Exception{
			JSONObject reulstDatas = new JSONObject();
			Connection connection = null;
			try {
				connection = context.getConnection(Constants.DATA_BASE_SOURCE);
				String sql = "select goo.GKEY as goodsKey,goo.GNAME as goodsName,pic.PICURL as goodsMainPic,goo.GPRICE as goodsPrice,goo.GSTOCK as goodsStore,goo.ISPINKAGE as isPackageMail from FS_GOODS goo left join (select t.GOODSKEY,t.PICURL from FS_GOODS_PICTURE t where t.PICISMASTERDRAW = '00A') pic on goo.GKEY = pic.GOODSKEY ";
				//查询到的参数结果集
				Table goodsDatas = DataUtils.queryData(connection, sql,null, null, null, null);
				if(null != goodsDatas){
					reulstDatas = Transform.tableToJson(goodsDatas);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				connection.close();
			}
			return reulstDatas;
		}
		
	
}
