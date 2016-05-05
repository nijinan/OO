package cn.edu.pku.sei.oo.neet.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/customer")
public class CustomerAPI {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/order")
	public String GetList() {
		return null;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/new")
	public String CreateNewOrder( 
			@QueryParam("id") int id, 
			@DefaultValue("0") @QueryParam("layer0") int layer0, 
			@DefaultValue("0") @QueryParam("layer1") int layer1, 
			@DefaultValue("0") @QueryParam("layer2") int layer2, 
			@DefaultValue("0") @QueryParam("layer3") int layer3, 
			@DefaultValue("0") @QueryParam("layer4") int layer4, 
			@DefaultValue("0") @QueryParam("layer5") int layer5 ) {
    	

        return null;
    }
	
}
