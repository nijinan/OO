package cn.edu.pku.sei.oo.neet.service;

import java.util.ArrayList;

import cn.edu.pku.sei.oo.neet.model.Order;

public class OrderManager {
	private ArrayList<Order> orderList;
	
	public OrderManager() {
		orderList = new ArrayList<Order>();
	}
	/*
	 * 从顾客，新建订单
	 */
	public boolean AddNewOrder() {
		return false;
	}
	
	/*
	 * 从厨师，接一个订单
	 */
	public Order AcceptOrder() {
		return null;
	}
	
	/*
	 * 删除一个订单
	 */
	public boolean DeleteOrderById(int id) {
		return false;
	}
}
