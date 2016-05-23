package cn.edu.pku.sei.oo.mos.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import cn.edu.pku.sei.oo.mos.service.MaterialManager;

public class Material {
	
	public int ID;
	public String name;
	public int type;
	public int father;
	
	public double price;
	
	public double fat;
	public double sodium;
	public double carbo;
	public double energy;
	public double vitamin;
	public double calcium;
	public double protein;
	public double calorie;
	
	public int mix;
	
	public Material(int ID, String name, int type, int father, double price) {
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.father = father;
		this.price = price;
		mix = 0;
	}
	
	public Material(Material m) {
		ID = m.ID;
		name = m.name;
		type = m.type;
		father = m.father;
		price = m.price;
		
		SetData(m.fat, m.sodium, m.carbo, m.energy, m.vitamin, m.calcium, m.protein, m.calorie);
	}

	public void SetData(double fat, double sod, double car, double ene, double vit, double cal, double pro, double calo) {
		this.fat = fat;
		sodium = sod;
		carbo = car;
		energy = ene;
		vitamin = vit;
		calcium = cal;
		protein = pro;
		calorie = calo;
	}
	
	public void SetFather(int father) {
		this.father = father;
	}
	
	public void SetMix(int mixId) {
		if (type != 5)
			return;
		mix = mixId;
	}
	
	public JSONObject ToJson() {
		JSONObject ret = new JSONObject();
		
		ret.put("id", ID);
		ret.put("name", name);
		ret.put("type", type);
		ret.put("price", price);
		
		ret.put("fat", fat);
		ret.put("sodium", sodium);
		ret.put("carbo", carbo);
		ret.put("protein", protein);
		ret.put("energy", energy);
		
		ret.put("calorie", calorie);
		
		// 蔬菜
		if (type == 3)
			ret.put("vitamin", vitamin);
		// 芝士
		if (type == 4)
			ret.put("calcium", calcium);
		// 酱料
		if (type == 5)
			ret.put("mix", mix);
		
		ret.put("father", father);
		return ret;
	}
	
	public JSONObject GetJsonInfo() {
		JSONObject ret = new JSONObject();
		String disc = name;
		if (type == 5 && mix != 0)
			disc += " 混合 " + MaterialManager.GetInstance().GetMixById(mix);
		ret.put("name", disc);
		ret.put("price", price);
		
		return ret;
	}
}
