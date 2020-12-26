package dataServer;

import model.SmsQueue;

public interface QueuingSms {
	public void add(SmsQueue sms);
    public void delete(int id);
}
