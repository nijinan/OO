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

@Path("/courier")
public class CourierAPI {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getorder")
	public String GetNewOrder(@QueryParam("id") int id) {
			Order order = OrderManager.orderManager.DeliverOrder(id);
			if (order == null)
				return "false";
			JSONObject orderInfo = order.GetCourierJson();
			return orderInfo.toString();

	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/confirm")
	public String ConfirmOrder(@FormParam("orderid") int orderId) {
		if (OrderManager.orderManager.ConfirmOrder(orderId))
			return "OK";
		else
			return "Error";
	}
}
