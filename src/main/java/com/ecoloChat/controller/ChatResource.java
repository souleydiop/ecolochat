package com.ecoloChat.controller;

import org.primefaces.json.JSONObject;
import org.primefaces.push.EventBus;
import org.primefaces.push.RemoteEndpoint;
import org.primefaces.push.annotation.OnClose;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.OnOpen;
import org.primefaces.push.annotation.PathParam;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.annotation.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.primefaces.json.JSONObject;

@PushEndpoint("/{room}/{user}")
@Singleton
public class ChatResource {

	private final Logger logger = LoggerFactory.getLogger(ChatResource.class);

	@PathParam("room")
	private String room;

	@PathParam("user")
	private String username;

	@Inject
	private ServletContext ctx;

	@OnOpen
	public void onOpen(RemoteEndpoint r, EventBus eventBus) {
		logger.info("OnOpen {}", r);
		// System.out.println((room + "/*"+","+ new JSONObject(new
		// Message(String.format("%s has entered the room ", username).toString()),
		// true))+"");
		eventBus.publish(room + "/*", new Message(String.format("%s est connecter ", username), true));
	}

	@OnClose
	public void onClose(RemoteEndpoint r, EventBus eventBus) {
		ChatUsers users = (ChatUsers) ctx.getAttribute("chatUsers");
		users.remove(username);
		eventBus.publish(room + "/*", new Message(String.format("%s vient de se deconnecter", username), true));
	}

	@OnMessage(decoders = { MessageDecoder.class }, encoders = { MessageEncoder.class })
	public Message onMessage(Message message) {
		return message;
	}

}
