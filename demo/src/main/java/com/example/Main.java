package com.example;

import com.example.SendingNotification.DequeuingEmail;
import com.example.SendingNotification.DequeuingSms;
import com.example.SendingNotification.IDequeue;

public class Main {

	public static void main(String[] args) {
		IDequeue dequeuingEmail = new DequeuingEmail();
		IDequeue dequeuingSms = new DequeuingSms();
		// while (true) {
		dequeuingSms.send();
		dequeuingEmail.send();
		// }
	}

}
