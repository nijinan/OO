package cn.edu.pku.sei.oo.neet.model;

public class Order {
	private int id;
	
	private Recipe recipe;
	private Customer customer;
	private Cook cook;
	private Courier courier;
	
	
	public int GetId() {
		return id;
	}
}
