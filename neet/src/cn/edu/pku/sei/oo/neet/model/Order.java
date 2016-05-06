package cn.edu.pku.sei.oo.neet.model;

import java.util.ArrayList;

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
	
	public ArrayList<Material> GetRecipe() {
		return recipe.layer;
	}
	
	public int GetId() {
		return id;
	}
	
	public boolean Finish() {
		// do sth
		return true;
	}
}
