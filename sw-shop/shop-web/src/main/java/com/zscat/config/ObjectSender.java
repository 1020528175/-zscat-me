package com.zscat.config;


import com.zsCat.common.base.RabbitMsg;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(RabbitMsg user) {
		System.out.println("Sender object: " + user.toString());
		this.rabbitTemplate.convertAndSend("zscat", user);
	}
}