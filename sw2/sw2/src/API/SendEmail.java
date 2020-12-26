package API;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dataServer.QueueEmail;
import dataServer.QueuingEmail;
import model.EmailQueue;

@Path("/SendEmail")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class SendEmail implements SendingEmailApi {

	private QueuingEmail saveData = new QueueEmail();
	
	@POST
    @Path("/queuing")
	public void queuing(EmailQueue email) {
		saveData.add(email);
	}
}
