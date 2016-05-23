package cn.edu.pku.sei.oo.mos.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.pku.sei.oo.mos.model.Material;
import cn.edu.pku.sei.oo.mos.service.MaterialManager;


public class MaterialJDBC {
	
/*	public static Material findMaterial(int id) throws Exception{
		Material Material = MaterialJDBC.findMaterialByProperty("user_name="+convertStr(username)+" and Material_name="+convertStr(Materialname));
		return Material;
	}
	
	public static Material findMaterialByProperty(String props) throws Exception{
		List<Material> list = findMaterialsByProperty(props);
		if(list==null||list.size()==0){
			return null;
		}
		Material Material = list.get(0);
		return Material;
	}

	public static List<Material> findMaterialsByProperty(String props) throws Exception{
		String sqlString = "select * from Material where " + props + " order by id desc";
		MySQL mySQL = new MySQL();
		ArrayList<HashMap<String, Object>> list = mySQL.execute(sqlString);
		if(list==null) 
			return null;
		return Material.getMaterials(list);
	}*/
	
	public static ArrayList<HashMap<String, Object>> GetAllMaterials() throws Exception {
		String sqlString = "select * from material";
		MySQL mySQL = new MySQL();
		ArrayList<HashMap<String, Object>> list = mySQL.execute(sqlString);
		return list;
		
	}
	
	public static ArrayList<HashMap<String, Object>> GetMix() throws Exception {
		String sqlString = "select * from mix_material";
		MySQL mySQL = new MySQL();
		ArrayList<HashMap<String, Object>> list = mySQL.execute(sqlString);
		return list;
		
	}
	
	public static ArrayList<HashMap<String, Object>> GetHamburgers() throws Exception {
		String sqlString = "select * from hamburgers";
		MySQL mySQL = new MySQL();
		ArrayList<HashMap<String, Object>> list = mySQL.execute(sqlString);
		return list;
	}
	
	public static void update(Material m) throws Exception{		
		String sqlString = "update `material` set "
				+ "`name`=" + convertStr(m.name)   
				+ ", `material-type`=" + convertNum(m.type)  
				+ ", `price`=" + convertNum(m.price)  
				+ ", `changed-father`=" + convertNum(m.father)  
				+ ", `calorie`=" + convertNum(m.calorie)  
				+ ", `protein`=" + convertNum(m.protein)  
				+ ", `calcium`=" + convertNum(m.calcium)  
				+ ", `vitamin`=" + convertNum(m.vitamin)  
				+ ", `energy`=" + convertNum(m.energy)
				+ ", `carbohydrate`=" + convertNum(m.carbo)	
				+ ", `sodium`=" + convertNum(m.sodium)
				+ ", `fat`=" + convertNum(m.fat)
				+ " where `id`=" + m.ID;
		new MySQL().execute(sqlString);
	}

	public static void insert(Material m) throws Exception{
		String sqlString = "insert into `material` ("
				+ "`id`, `name`, `material-type`, `price`, `changed-father`, `calorie`, " 
				+ "`protein`, `calcium`, `vitamin`, `energy`, `carbohydrate`, `sodium`, `fat`) "
				+ "values (" 
				+ convertStr(m.ID) + ", "
				+ convertStr(m.name)  + ", "
				+ convertStr(m.type) + ", "
				+ convertStr(m.price) + ", "
				+ convertStr(m.father) + ", " 
				+ convertStr(m.calorie) + ", "
				+ convertStr(m.protein) + ", "
				+ convertStr(m.calcium) + ", "
				+ convertStr(m.vitamin) + ", "
				+ convertStr(m.energy) + ", "
				+ convertStr(m.carbo) + ", "
				+ convertStr(m.sodium) + ", "
				+ convertStr(m.fat)
				+ ")";
		new MySQL().execute(sqlString);			
	}
	
	public static void delete(Material m) throws Exception{
		String sqlString = "delete from material where id=" + convertStr(m.ID);
		new MySQL().execute(sqlString);
	}

	public static String convertNum(Object num) {
		if (num == null) return "null";
		else
			return num.toString();
	}
	
	public static String convertStr(Object str){
		if(str==null) return "null";
		else return "'" + str.toString().replaceAll(".*([';]+|(--)+).*", " ") + "'";
	}
	
}
