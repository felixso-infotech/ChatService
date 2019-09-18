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
package com.felixsoinfotech.chat.XmppChatApplication.configuration;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */
@Configuration
public class XmppConfiguration {

	public XmppConfiguration() {
		// TODO Auto-generated constructor stub
	}
	
	private Logger logger = LoggerFactory.getLogger(XmppConfiguration.class);
	
	AbstractXMPPConnection connection;
	
	@Bean(name = "xmppConfig")
	public AbstractXMPPConnection XmppConfig() {
				
		try {
			XMPPTCPConnectionConfiguration config = XMPPTCPConnectionConfiguration.builder()
            		.setUsernameAndPassword("anjali","karma123")
  				  .setXmppDomain("jabber.hot-chilli.net")
  				  .setHost("jabber.hot-chilli.net")
  				  .build();

            connection = new XMPPTCPConnection(config);

            connection.connect();
            connection.login();
            logger.info("*****host{}",connection.getHost());
             
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
		
		return connection;
	}
	

}
