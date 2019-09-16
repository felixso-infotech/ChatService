package com.felixsoinfotech.chat.XmppChatApplication;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmppChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmppChatApplication.class, args);
		
	}

}
