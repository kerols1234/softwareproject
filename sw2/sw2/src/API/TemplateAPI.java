package API;

import dataServer.SaveTemplates;
import dataServer.SavingTemplates;
import model.NotificationTemplates;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kerols
 */

@Path("/TemplateAPI")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class TemplateAPI implements ITemplateApi {
	
    private SavingTemplates dbsql = new SaveTemplates();
    
    @GET
	@Path("/getAll")
    public ArrayList<NotificationTemplates> getTemplates() {
        return dbsql.getData();
    }
    
    @GET
	@Path("/hello")
	public String sayHello() {
		
		return "Hello world";
	}
       
    
	@GET
	@Path("/{id}/get")
    public NotificationTemplates getTemplate(@PathParam("id") int id) {
		return dbsql.getTemplate(id);
	}
    
	@GET
    @Path("/{id}/delete")
    public void remove(@PathParam("id") int id){
        dbsql.delete(id);
    }
    
	@POST
    @Path("/update")
    public void update(NotificationTemplates t){
        dbsql.update(t);
    }
    
	@POST
    @Path("/add")
    public void add(NotificationTemplates t){
        dbsql.add(t);
    }
	
}
