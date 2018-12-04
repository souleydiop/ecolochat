package com.ecoloChat.controller;

import org.primefaces.push.Decoder;

/**
 * A Simple {@link org.primefaces.push.Decoder} that decode a String into a
 * {@link Message} object.
 */
public class MessageDecoder implements Decoder<String, Message> {

	// @Override
	public Message decode(String s) {
		System.out.println(s + "--- decoder");
		String[] userAndMessage = s.split(":");
		if (userAndMessage.length >= 2) {
			Message msg = new Message().setUser(userAndMessage[0]).setText(userAndMessage[1]);
			System.out.println(msg.getUser());
			return msg;

		} else {
			return new Message(s);
		}
	}
}
