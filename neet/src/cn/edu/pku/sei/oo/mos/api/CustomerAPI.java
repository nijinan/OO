package cn.edu.pku.sei.oo.mos.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.pku.sei.oo.mos.model.Material;
import cn.edu.pku.sei.oo.mos.model.Order;
import cn.edu.pku.sei.oo.mos.model.Recipe;
import cn.edu.pku.sei.oo.mos.service.MaterialManager;
import cn.edu.pku.sei.oo.mos.service.OrderManager;

@Path("/customer")
public class CustomerAPI {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/order")
	public String GetList() {
		return null;
	}
	
	
	/*
	 * 获得订单JSON
	 * [JSONArray, 元素是JSONObject{"id":食材编号, "mix":可选，如果食材是酱料，选择混合的编号}]
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/new")
	public String CreateNewOrder( 
			@FormParam("id") int id, 
			@FormParam("order") String orderJSON) throws UnsupportedEncodingException {
    	// 解析JSON
		System.out.println("Get A Order: " + String.valueOf(id) + " " + orderJSON);
		if (orderJSON == null)
			return "Error";
		JSONArray orderList = new JSONArray(orderJSON);
		ArrayList<Material> mList = new ArrayList<Material>();
		for (int i = 0; i < orderList.length(); i++) {
			Material mi = null;
			if (orderList.getJSONObject(i).has("mix")) {
				mi = MaterialManager.meterialManager.GetMaterialCopy(orderList.getJSONObject(i).getInt("id"), orderList.getJSONObject(i).getInt("mix"));
			}
			mi = MaterialManager.meterialManager.GetMaterialCopy(orderList.getJSONObject(i).getInt("id"));
			mList.add(mi);
		}
		
		// 创建菜单
		Recipe customRecipe = new Recipe();
		customRecipe.SetRecipe(mList);
		// 创建订单
		Order order = new Order(id, customRecipe);
		// 添加到列表
		OrderManager.orderManager.AddNewOrder(order);
		
        return String.valueOf(order.GetPrice());
    }
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/chef")
	public String GetRecommendation() {
//		ArrayList<List<Integer>> rec = RecipeConstant.recommendation;
//		JSONArray recJson = new JSONArray();
//		for (List<Integer> l : rec) {
//			JSONObject obj = new JSONObject();
//			obj.put("name", "主厨推荐");
//			JSONArray materialList = new JSONArray();
//			for (int i = 0; i < 6; i++) {
//				materialList.put(l.get(i));
//			}
//			obj.put("recipe", materialList);
//			recJson.put(obj);
//		}
//		return recJson.toString();
		return "123";
	}
}
