package cn.edu.pku.sei.oo.mos.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.pku.sei.oo.mos.service.MaterialManager;
import cn.edu.pku.sei.oo.mos.service.OrderManager;

@Path("/diet")
public class DieticianAPI {
	
	/*
	 * 参数是jsonarray
	 * 每个元素是
	 * {"sodium":1,"carbo":1,"price":0,"protein":1,"father":0,"name":"松软面包","fat":1,"calorie":1,"id":1,"type":1,"energy":1}
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/modify")
	public String ModifyMaterial(@FormParam("data") String data) {
		JSONArray changedList = new JSONArray(data);
		for (int i = 0; i < changedList.length(); i++) {
			MaterialManager.GetInstance().UpdateMaterial(changedList.getJSONObject(i));
		}
		return "OK";
		
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/insert")
	public String InsertMaterial(@FormParam("data") String data) {
		JSONObject insertMaterial = new JSONObject(data);
		MaterialManager.GetInstance().AddMaterial(insertMaterial);
		return "OK";
	}
}
