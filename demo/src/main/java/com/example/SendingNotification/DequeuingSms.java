package com.example.SendingNotification;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.model.Sms;

public class DequeuingSms implements IDequeue {

	final String GET_ALL_SMS = "http://localhost:8080/sms";
	final String DELETE_SMS_ID = "http://localhost:8080/sms/{id}";
	RestTemplate rest = new RestTemplate();

	@Override
	public void send() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Sms[]> entity = new HttpEntity<Sms[]>(headers);

		Sms[] list = rest.exchange(GET_ALL_SMS, HttpMethod.GET, entity, Sms[].class).getBody();

		HashMap<String, Integer> map = new HashMap<>();

		Random random = new Random();
		for (int i = 0; i < list.length; i++) {
			/*
			 * send function here
			 */
			System.out.println("-------------------------------------------------------------------");
			while (random.nextBoolean()) {
				/*
				 * resends notification until be successful
				 */
				System.out.println("Send sms notification failed from " + list[i].getSender() + " to "
						+ list[i].getReceiver() + " which subject " + list[i].getSubject() + "\n");
			}
			System.out.println("Send sms notification successful from " + list[i].getSender() + " to "
					+ list[i].getReceiver() + " which subject " + list[i].getSubject() + "\n");
			System.out.println("-------------------------------------------------------------------");
			map.put("id", list[i].getId());
			rest.delete(DELETE_SMS_ID, map);

		}
	}

}
