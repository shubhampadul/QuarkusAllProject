package com.hdfc.rabbitMq.producer;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.OnOverflow;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/producer")
public class ProducerResource {
	
	@Inject
    @Channel("rabbitmq-outgoing")
    @OnOverflow(value = OnOverflow.Strategy.BUFFER, bufferSize = 1000)
    Emitter<JsonObject> emitter;
	
	@GET
    public String produceMessage() {
        JsonObject message = new JsonObject().put("key", "value");
        emitter.send(message);

        return "Message sent to RabbitMQ";
    }

}
