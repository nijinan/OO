package cn.edu.pku.sei.oo.mos;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.pku.sei.oo.mos.jdbc.MaterialJDBC;
import cn.edu.pku.sei.oo.mos.model.Material;
import cn.edu.pku.sei.oo.mos.service.MaterialManager;

public class Test {
	public static void main(String[] args) throws Exception {
		
		JSONObject a = new JSONObject();
		a.put("a", "123");
		if (!a.has("b"))
			System.out.println("null");
	}
}
