package com.test.oauth2.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.oauth2.backend.dtos.MessageDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PrivateController {

	@GetMapping("/messages")
	public ResponseEntity<MessageDto> privateMessages(@AuthenticationPrincipal(expression = "name") String name  ) {
		return ResponseEntity.ok(new MessageDto("private content" + name));
	}
	
	
}
