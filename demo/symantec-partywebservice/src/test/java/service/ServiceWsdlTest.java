package service;

import javax.xml.ws.Endpoint;

import com.symantec.partyservice.services.PartyServices;

public class ServiceWsdlTest {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1234/ws", new PartyServices());
	}

}
