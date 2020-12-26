package API;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dataServer.QueueSms;
import dataServer.QueuingSms;
import model.SmsQueue;

@Path("/SendSms")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class SendSms implements SendingSmsApi {
	
	private QueuingSms saveData = new QueueSms();
	
	@POST
    @Path("/queuing")
	public void queuing(SmsQueue sms) {
		saveData.add(sms);
	}
	
}
