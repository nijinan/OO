package cn.edu.pku.sei.oo.neet.service;

import java.util.ArrayList;

import cn.edu.pku.sei.oo.neet.model.Order;

public class OrderManager {
	
	private OrderManager() {
		newOrder = new ArrayList<Order>();
		acceptedOrder = new ArrayList<Order>();
		cookedOrder = new ArrayList<Order>();
		unconfirmedOrder = new ArrayList<Order>();
	}  
	
    public static final OrderManager orderManager = new OrderManager();  

	private int orderCnt = 0;
	private ArrayList<Order> newOrder;
	private ArrayList<Order> acceptedOrder;
	private ArrayList<Order> cookedOrder;
	private ArrayList<Order> unconfirmedOrder;
	
	
	public String test() {
		return "123";
	}
	
	/*
	 * 从顾客，新建订单
	 */
	public boolean AddNewOrder(Order order) {
		
		order.SetId(orderCnt);
		newOrder.add(order);
		orderCnt++;
		return true;
	}
	
	/*
	 * 从厨师，接一个订单
	 */
	public Order AcceptOrder(int cookId) {
		if (newOrder.isEmpty())
			return null;
		Order order = newOrder.remove(0);
		order.SetCookId(cookId);
		acceptedOrder.add(order);
		return order;
	}
	
	/*
	 * 删除一个订单
	 */
	public boolean DeleteOrderById(int id) {
		return false;
	}
	
	/*
	 * 通过orderid从accepted里获取order
	 */
	public Order GetAcceptedOrderById(int orderId) {
		for (Order o : acceptedOrder) {
			if (o.GetId() == orderId)
				return o;
		}
		return null;
	}
	
	/*
	 * 通过orderid从cooked里获取order
	 */
	public Order GetCookedOrderById(int orderId) {
		for (Order o : unconfirmedOrder) {
			if (o.GetId() == orderId)
				return o;
		}
		return null;
	}
	
	/*
	 * 从厨师，完成订单，待配送
	 */
	public boolean FinishOrder(int orderId) {
		Order order = GetAcceptedOrderById(orderId);
		if (order == null) {
			return false;
		}
		cookedOrder.add(order);
		acceptedOrder.remove(order);
		return true;
	}
	
	/*
	 * 从递送员，接一个订单
	 */
	public Order DeliverOrder(int courierId) {
		if (cookedOrder.isEmpty())
			return null;
		Order order = cookedOrder.remove(0);
		order.SetCourierId(courierId);
		unconfirmedOrder.add(order);
		return order;
	}
	
	/*
	 * 从递送员，确认订单完成
	 */
	public boolean ConfirmOrder(int orderId) {
		Order order = GetCookedOrderById(orderId);
		if (order == null) {
			return false;
		}
		order.Finish();
		return true;
	}
}
