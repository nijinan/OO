package cn.edu.pku.sei.oo.mos.model;

import java.util.ArrayList;

import org.json.JSONObject;

public class Order {
	private int id;
	
	private Recipe recipe;
	private int customerId;
	private int cookId;
	private int courierId;
	private double price = 0;
	
	/*
	 * 创建新订单，由客户创建，指定客户和菜单
	 */
	public Order(int customerId, Recipe recipe) {
		this.customerId = customerId;
		this.recipe = recipe;
		
		for (Material m : recipe.layer) {
			price += m.price;
		}
		
	}
	
	public void SetId(int id) {
		this.id = id;
	}
	
	public void SetCookId(int id) {
		cookId = id;
	}
	
	public void SetCourierId(int id) {
		this.courierId = id;
	}
	
	public int GetCustomerId() {
		return customerId;
	}
	
	public int GetCookId() {
		return cookId;
	}
	
	public int GetCourierId() {
		return courierId;
	}
	
	public Recipe GetRecipe() {
		return recipe;
	}
	
	public int GetId() {
		return id;
	}
	
	public boolean Finish() {
		// do sth
		return true;
	}
	
	public double GetPrice() {
		return price;
	}
	
	public JSONObject GetCustomerJson() {
		JSONObject orderInfo = new JSONObject();
		orderInfo.put("orderId", GetId());
		orderInfo.put("customerId", GetCustomerId());
		orderInfo.put("recipe", GetRecipe().GetJsonRecipe());
		return orderInfo;
	}
	
	public JSONObject GetCookJson() {
		JSONObject orderInfo = GetCustomerJson();
		orderInfo.put("cookId", GetCookId());
		return orderInfo;
	}
	
	public JSONObject GetCourierJson() {
		JSONObject orderInfo = GetCookJson();
		orderInfo.put("courierId", GetCourierId());
		return orderInfo;
	}
	
	
}
