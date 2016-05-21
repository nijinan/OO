package cn.edu.pku.sei.oo.mos.model;

import java.util.ArrayList;

import org.json.JSONArray;

public class Recipe {
	public ArrayList<Material> layer;
	
	public Recipe() {
		layer = new ArrayList<Material>();
	}
	
	public void SetRecipe(ArrayList<Material> o) {
		layer.addAll(o);
	}
	
	public JSONArray GetJsonRecipe() {
		JSONArray ret = new JSONArray();
		for (Material m : layer)
			ret.put(m.GetJsonInfo());
		return ret;
	}
}
