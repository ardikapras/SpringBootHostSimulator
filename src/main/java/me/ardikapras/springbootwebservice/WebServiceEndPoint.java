package me.ardikapras.springbootwebservice;

import me.ardikapras.arithmeticservice.AdditionRequest;
import me.ardikapras.arithmeticservice.AdditionResponse;
import me.ardikapras.arithmeticservice.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WebServiceEndPoint {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ardikapras.me", localPart = "AdditionRequest")
	public AdditionResponse addition(@RequestPayload AdditionRequest input) {
		logger.info("Request received for addition with input " + input);
		ObjectFactory objectFactory = new ObjectFactory();
		AdditionResponse output = objectFactory.createAdditionResponse();
		output.setResult(input.getNumber1() + input.getNumber2());
		return output;
	}
}