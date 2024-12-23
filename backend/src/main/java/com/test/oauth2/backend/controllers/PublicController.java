package com.test.oauth2.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.oauth2.backend.dtos.MessageDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PublicController {

	@GetMapping("/public/messages")
	public ResponseEntity<MessageDto> publicMessages() {
		return ResponseEntity.ok(new MessageDto("public content"));
	}
}
