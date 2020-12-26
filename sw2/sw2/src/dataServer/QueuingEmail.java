package dataServer;

import model.EmailQueue;

public interface QueuingEmail {
	public void add(EmailQueue email);
    public void delete(int id);
}
