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

@Path("/courier")
public class CourierAPI {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getorder")
	public String GetNewOrder(@QueryParam("id") int id) {
			Order order = OrderManager.orderManager.DeliverOrder(id);
			if (order == null)
				return "false";
			JSONObject orderInfo = new JSONObject();
			orderInfo.put("orderId", order.GetId());
			orderInfo.put("customerId", order.GetCustomerId());
			orderInfo.put("cookId", order.GetCookId());
			orderInfo.put("courierId", order.GetCourierId());
			return orderInfo.toString();

	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/confirm")
	public String ConfirmOrder(@QueryParam("orderid") int orderId) {
		if (OrderManager.orderManager.FinishOrder(orderId))
			return "OK";
		else
			return "Error";
	}
}
