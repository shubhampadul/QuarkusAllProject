package com.hdfc.rabbitMq.resource;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.vertx.core.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/send")
public class GreetingResource {
	
    @Channel("quarkus-rabbitmq")
	Emitter<JsonObject> emitter;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		JsonObject obj = new JsonObject();
		obj.put("hello", "word");
		System.out.println("GreetingResource.hello()>>>>>>>>>>>>>>>>>>>> 2n Jan");
		
		emitter.send(obj);
		return "Welcome to rabbit MQ";
		
	}
	
	

}
