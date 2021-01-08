package com.example;

import com.example.SendingNotification.DequeuingEmail;
import com.example.SendingNotification.DequeuingSms;
import com.example.SendingNotification.IDequeue;

public class BackOperation {

	static IDequeue dequeuingEmail = new DequeuingEmail();
	static IDequeue dequeuingSms = new DequeuingSms();
	
	public static void main(String[] args) {
		// while (true) {
		dequeuingSms.send();
		dequeuingEmail.send();
		// }
	}

}
