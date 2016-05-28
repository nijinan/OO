package cn.edu.pku.sei.oo.mos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.pku.sei.oo.mos.jdbc.MaterialJDBC;
import cn.edu.pku.sei.oo.mos.model.Hamburger;
import cn.edu.pku.sei.oo.mos.model.Material;

public class MaterialManager {
	public ArrayList<Material> materialList;
	public ArrayList<String> mixList;
	public ArrayList<Hamburger> hamList;
	
	private static MaterialManager materialManager = null; 
	
	public synchronized static MaterialManager GetInstance() {
		if (materialManager == null)
			materialManager = new MaterialManager();
		return materialManager;
	}
	
	private MaterialManager() {
		materialList = new ArrayList<Material>();
		mixList = new ArrayList<String>();
		hamList = new ArrayList<Hamburger>();
		LoadData();
	}
	
	public void LoadData() {
		try {
			GetMaterialFromMap(MaterialJDBC.GetAllMaterials());
			GetMixFromMap(MaterialJDBC.GetMix());
			GetHamburgerFromMap(MaterialJDBC.GetHamburgers());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ClearData() {
		materialList.clear();
		mixList.clear();
		hamList.clear();
	}
	
	public void AddMaterial(JSONObject jm) {
		if (!(jm.has("id") && jm.has("name") && jm.has("type") && jm.has("price")))
			return;
		Material m = new Material(jm.getInt("id"), jm.getString("name"), jm.getInt("type"), (int)JReadNum(jm, "father"), jm.getDouble("price"));
		m.SetData(JReadNum(jm, "fat"), 
				  JReadNum(jm, "sodium"),
				  JReadNum(jm, "carbo"),
				  JReadNum(jm, "energy"), 
				  JReadNum(jm, "vitamin"), 
				  JReadNum(jm, "calcium"), 
				  JReadNum(jm, "protein"), 
				  JReadNum(jm, "calorie"));
		materialList.add(m);
		try {
			MaterialJDBC.insert(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClearData();
		LoadData();
	}
	
	public void UpdateMaterial(JSONObject jm){
		if (!(jm.has("id") && jm.has("name") && jm.has("type") && jm.has("price")))
			return;
		Material m = GetMaterialById(jm.getInt("id"));
		if (m == null)
			return;
		m.price = jm.getDouble("price");
		m.name = jm.getString("name");
		if (jm.has("father"))
			m.father = jm.getInt("father");
		m.SetData(JReadNum(jm, "fat"), 
				  JReadNum(jm, "sodium"),
				  JReadNum(jm, "carbo"),
				  JReadNum(jm, "energy"), 
				  JReadNum(jm, "vitamin"), 
				  JReadNum(jm, "calcium"), 
				  JReadNum(jm, "protein"), 
				  JReadNum(jm, "calorie"));
		try {
			MaterialJDBC.update(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClearData();
		LoadData();
	}
	
	private double JReadNum(JSONObject j, String key) {
		if (!j.has(key))
			return 0;
		else
			return j.getDouble(key);
	}
	
	public JSONArray GetMaterialList() {
		JSONArray mList = new JSONArray();
		for (Material m : materialList) {
			mList.put(m.ToJson());
		}
		return mList;
	}
	
	public JSONArray GetMixList() {
		JSONArray ret = new JSONArray();
		for (int i = 0; i < mixList.size(); i++) {
			JSONObject mi = new JSONObject();
			mi.put("id", i);
			mi.put("name", mixList.get(i));
			ret.put(mi);
		}
		return ret;
	}
	
	public JSONArray GetHamList() {
		JSONArray ret = new JSONArray();
		for (Hamburger h : hamList) {
			System.out.println(h.name);
			ret.put(h.ToJson());
		}
		return ret;
	}
	
	public Material GetMaterialById(int id) {
		for (Material m : materialList) {
			if (m.ID == id)
				return new Material(m);
		}
		return null;
	}
	
	public Material GetMaterialCopy(int materialId) {
		Material ret = null;
		for (Material m : materialList) {
			if (m.ID == materialId) {
				ret = new Material(m);
			}
		}
		return ret;
	}
	
	public Material GetMaterialCopy(int materialId, int mixId) {
		Material ret = null;
		for (Material m : materialList) {
			if (m.ID == materialId) {
				if (m.type != 5)
					return null;
				ret = new Material(m);
				
				ret.SetMix(mixId);
				return ret;
			}
		}
		return ret;
	}
	
	public String GetMixById(int id) {
		if (id < 0 || id >= mixList.size())
			return "Out of Index";
		return mixList.get(id);
	}
	
	public void GetMaterialFromMap(ArrayList<HashMap<String, Object>> ml){
		for(HashMap<String, Object> mMap : ml){
			//System.out.println(mMap.toString());
			Material m = new Material(ConvertNum((Integer)mMap.get("id")), (String)mMap.get("name"), 
										ConvertNum((Integer)mMap.get("material-type")), ConvertNum((Integer)mMap.get("changed-father")), 
										ConvertNum((Double)mMap.get("price")));
			m.SetData(
					ConvertNum((Double)mMap.get("fat")), 
					ConvertNum((Double)mMap.get("sodium")), 
					ConvertNum((Double)mMap.get("carbohydrate")), 
					ConvertNum((Double)mMap.get("energy")), 
					ConvertNum((Double)mMap.get("vitamin")), 
					ConvertNum((Double)mMap.get("calcium")), 
					ConvertNum((Double)mMap.get("protein")), 
					ConvertNum((Double)mMap.get("calorie")));
			materialList.add(m);
		}
	}
	
	public void GetMixFromMap(ArrayList<HashMap<String, Object>> ml) {
		mixList.add("无混合");
		for(HashMap<String, Object> mMap : ml){
			//System.out.println(mMap.toString());
			mixList.add((String)mMap.get("name"));
		}
	}
	
	public void GetHamburgerFromMap(ArrayList<HashMap<String, Object>> hl) {
		for(HashMap<String, Object> mMap : hl){
			Hamburger h = new Hamburger(ConvertNum((Integer)mMap.get("id")), (String)mMap.get("name"));
			h.SetLayer((Integer)mMap.get("01"), (Integer)mMap.get("02"), (Integer)mMap.get("03"), 
					(Integer)mMap.get("04"), (Integer)mMap.get("05"), (Integer)mMap.get("06"), 
					(Integer)mMap.get("07"), (Integer)mMap.get("08"), (Integer)mMap.get("09"), (Integer)mMap.get("10"));
			hamList.add(h);
		}
	}
	
	private double ConvertNum(Double a) {
		if (a == null)
			return 0;
		else
			return a.doubleValue();
	}
	
	private int ConvertNum(Integer a) {
		if (a == null)
			return 0;
		else
			return a.intValue();
	}
}
