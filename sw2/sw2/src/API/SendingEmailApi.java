package API;

import model.EmailQueue;

public interface SendingEmailApi {

	 void queuing(EmailQueue email);
}
