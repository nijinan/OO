package cn.edu.pku.sei.oo.mos;

import org.json.JSONArray;

import cn.edu.pku.sei.oo.mos.jdbc.MaterialJDBC;
import cn.edu.pku.sei.oo.mos.model.Material;
import cn.edu.pku.sei.oo.mos.service.MaterialManager;

public class Test {
	public static void main(String[] args) throws Exception {
		
		//MaterialJDBC.GetMix();
		JSONArray m = MaterialManager.GetInstance().GetHamList();
		System.out.println(m);
	}
}
