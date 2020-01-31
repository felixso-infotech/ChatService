package com.felixsoinfotech.chat.WebsocketChatApplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.felixsoinfotech.chat.WebsocketChatApplication.config.WebSocketConfiguration;
import com.felixsoinfotech.chat.WebsocketChatApplication.model.Message;
import org.springframework.messaging.handler.annotation.SendTo;

@Controller
public class WebSocketController {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

	private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/message")
	@SendTo("/chat")
    public void onReceivedMesage(@Payload Message message){
        //this.template.convertAndSend("/chat",  new SimpleDateFormat("HH:mm:ss").format(new Date())+"- "+message);
		
	    	logger.info("**********inside onReceivedMesage message{}",message);
		logger.info("**********inside onReceivedMesage content{}",message.getContent());  	
		logger.info("**********inside onReceivedMesage sender{}",message.getSender());
	    	
		/* SimpMessageHeaderAccessor headerAccessor = 
	               SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
		
		logger.info("******headerAccessor{}",headerAccessor);
		logger.info("******headerAccessor user{}",headerAccessor.getUser().getName());
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		 
		 if(username != null) {
	            Message chatMessage = new Message();    
	            chatMessage.setSender(username);
	            this.template.convertAndSend("/chat",message.getContent());
	    		
	        }
			 */
			this.template.convertAndSend("/chat",message);
   }
    
}
