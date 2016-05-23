package cn.edu.pku.sei.oo.mos.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cn.edu.pku.sei.oo.mos.service.MaterialManager;

@Path("/common")
public class Common {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/list")
	public String GetList() {
		return MaterialManager.GetInstance().GetMaterialList().toString();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/mix")
	public String GetMix() {
		return MaterialManager.GetInstance().GetMixList().toString();
	}
}
