/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.felixsoinfotech.chat.XmppChatApplication.service;
/**
 * 
 */

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.IncomingChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felixsoinfotech.chat.XmppChatApplication.configuration.XmppConfiguration;

@Service
public class XmppService implements MessageListener  {

	public XmppService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private AbstractXMPPConnection connection;
	
	private Logger logger = LoggerFactory.getLogger(XmppService.class);
	
	private ChatManager chatManager;
	
	private Message newMessage;
	
	private Chat chat;
	
	public void sendMessage() {
		
		chatManager = ChatManager.getInstanceFor(connection);
		chatManager.addIncomingListener(new IncomingChatMessageListener() {
			@Override
			public void newIncomingMessage(EntityBareJid from, Message message, Chat chat) {
			    System.out.println("New message from " + from + ": " + message.getBody());
			  }
			});
		
		newMessage = new Message();
		newMessage.setBody("haii");
		
		if(chatManager!=null) {
		try {
			
			chat = chatManager.chatWith(JidCreate.from("sanil@jabber.hot-chilli.net").asEntityBareJidOrThrow());

		if (connection.isConnected()) {
			chat.send(newMessage.getBody());
			logger.info("message sent***{}",newMessage);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else
		{
		logger.info("chatmanager is null");
		}
	}
	
	public void getMessage(){
		try{ 
			  chatManager = ChatManager.getInstanceFor(connection); 
			  final EntityBareJid from = chat.getXmppAddressOfChatPartner();
					
			  newIncomingMessage(from,newMessage,chat);
			    
			}catch (Exception e) {
	            logger.error(e.getMessage(), e);
	        }
			
	}

	 @Override
	  	public void processMessage(Message newMessage) {
	  		 if(newMessage.getType() == Message.Type.chat){
	  			    logger.info(newMessage.getBody());
	  		 }
	  	}
	 
	 public void newIncomingMessage(EntityBareJid from, Message newMessage, Chat chat) {
	     // System.out.println("New message from " + from + ": " + newMessage.getBody());
	      logger.info("chat body{}",newMessage.getBody());
	           
	  }


}
