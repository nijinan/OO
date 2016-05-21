package cn.edu.pku.sei.oo.mos.api;

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
import cn.edu.pku.sei.oo.mos.service.OrderManager;

@Path("/cook")
public class CookAPI {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/order")
	public String GetNewOrder(@QueryParam("id") int id) {
		
			Order order = OrderManager.orderManager.AcceptOrder(id);
			if (order == null)
				return "false";
			JSONObject orderInfo = order.GetCookJson();
			System.out.println(orderInfo.toString());
			return orderInfo.toString();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/finish")
	public String FinishOrder(@FormParam("orderid") int orderId) {
		
		if (OrderManager.orderManager.FinishOrder(orderId))
			return "OK";
		else
			return "Error";
		
	}
}
