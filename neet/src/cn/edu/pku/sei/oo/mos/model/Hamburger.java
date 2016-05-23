package cn.edu.pku.sei.oo.mos.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.pku.sei.oo.mos.service.MaterialManager;

public class Hamburger {
	public int id;
	public String name;
	public ArrayList<Integer> layer;
	
	public Hamburger(int id, String name) {
		this.id = id;
		this.name = name;
		layer = new ArrayList<Integer>();
	}
	
	public void SetLayer(Integer l1, Integer l2, Integer l3, Integer l4, Integer l5, 
					Integer l6, Integer l7, Integer l8, Integer l9, Integer l10) {
		if (l1 != null) layer.add(l1);
		if (l2 != null) layer.add(l2);
		if (l3 != null) layer.add(l3);
		if (l4 != null) layer.add(l4);
		if (l5 != null) layer.add(l5);
		if (l6 != null) layer.add(l6);
		if (l7 != null) layer.add(l7);
		if (l8 != null) layer.add(l8);
		if (l9 != null) layer.add(l9);
		if (l10 != null) layer.add(l10);
	}
	
	public JSONObject ToJson() {
		JSONObject ret = new JSONObject();
		ret.put("name", name);
		JSONArray mlayer = new JSONArray();
		for (Integer i : layer) {
			mlayer.put(MaterialManager.GetInstance().GetMaterialById(i.intValue()).name);
		}
		ret.put("recipe", mlayer);
		return ret;
	}
}
