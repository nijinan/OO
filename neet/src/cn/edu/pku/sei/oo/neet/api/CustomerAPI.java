package cn.edu.pku.sei.oo.neet.api;

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

import cn.edu.pku.sei.oo.neet.constants.RecipeConstant;
import cn.edu.pku.sei.oo.neet.model.Order;
import cn.edu.pku.sei.oo.neet.model.Recipe;
import cn.edu.pku.sei.oo.neet.service.OrderManager;

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
	 * {0, 1, 2, 1, 1, 1}
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
		String parsedOrder = java.net.URLDecoder.decode(orderJSON, "UTF-8");
		JSONArray orderArray = new JSONArray(parsedOrder);
		System.out.println(orderJSON + "->" + parsedOrder);
		// 创建菜单
		Recipe customRecipe = new Recipe();
		customRecipe.SetRecipe(orderArray.getInt(0),
				orderArray.getInt(1), 
				orderArray.getInt(2), 
				orderArray.getInt(3), 
				orderArray.getInt(4), 
				orderArray.getInt(5));
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
		ArrayList<List<Integer>> rec = RecipeConstant.recommendation;
		JSONArray recJson = new JSONArray();
		for (List<Integer> l : rec) {
			JSONObject obj = new JSONObject();
			obj.put("name", "主厨推荐");
			JSONArray materialList = new JSONArray();
			for (int i = 0; i < 6; i++) {
				materialList.put(l.get(i));
			}
			obj.put("recipe", materialList);
			recJson.put(obj);
		}
		return recJson.toString();
	}
}
