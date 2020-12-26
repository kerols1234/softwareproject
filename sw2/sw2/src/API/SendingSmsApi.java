package API;

import model.SmsQueue;

public interface SendingSmsApi {

	 void queuing(SmsQueue sms);
}
