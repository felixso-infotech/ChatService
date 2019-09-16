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

package com.felixsoinfotech.chat.XmppChatApplication.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felixsoinfotech.chat.XmppChatApplication.service.XmppService;

/**
 * 
 */

@RestController
@RequestMapping("/api")
public class XmppController {

	public XmppController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private XmppService xmppService;
	
	@PostMapping(value="/{sendMessage}")
	public void sendMessage() {
		
		xmppService.sendMessage();
	}

}









