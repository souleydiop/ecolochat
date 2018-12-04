package com.ecoloChat.controller;

import org.primefaces.json.JSONObject;
import org.primefaces.push.Encoder;

/**
 * A Simple {@link org.primefaces.push.Encoder} that decode a {@link Message}
 * into a simple JSON object.
 */
public final class MessageEncoder implements Encoder<Message, String> {

	// @Override
	public String encode(Message message) {
		System.out.println(new JSONObject(message).toString());
		return new JSONObject(message).toString();
	}

}