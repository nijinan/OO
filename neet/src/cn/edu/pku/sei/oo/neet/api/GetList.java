package cn.edu.pku.sei.oo.neet.api;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/getList")
public class GetList {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@DefaultValue("2") @QueryParam("step") int step) {
    	
        return "listlist" + String.valueOf(step);
    }
}