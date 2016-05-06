package cn.edu.pku.sei.oo.neet.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.pku.sei.oo.neet.model.Material;
import cn.edu.pku.sei.oo.neet.model.Order;
import cn.edu.pku.sei.oo.neet.service.OrderManager;

@Path("/cook")
public class CookAPI {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/order")
	public String GetNewOrder(@QueryParam("id") int id) {
		
			Order order = OrderManager.orderManager.AcceptOrder(id);
			if (order == null)
				return "false";
			JSONObject orderInfo = new JSONObject();
			orderInfo.put("orderId", order.GetId());
			orderInfo.put("customerId", order.GetCustomerId());
			orderInfo.put("cookId", order.GetCookId());
			JSONArray recipe = new JSONArray();
			for (Material m : order.GetRecipe()) {
				recipe.put(m.name);
			}
			orderInfo.put("recipe", recipe);
			return orderInfo.toString();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/finish")
	public String FinishOrder(@QueryParam("orderid") int orderId) {
		
		if (OrderManager.orderManager.FinishOrder(orderId))
			return "OK";
		else
			return "Error";
		
	}
}
