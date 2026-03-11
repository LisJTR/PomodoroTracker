package com.lis.pomodoro.sessions.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lis.pomodoro.sessions.entity.SessionPomodoro;
import com.lis.pomodoro.sessions.service.SessionsService;

@RestController
@RequestMapping("/sessions")
public class SessionController {
	
	private final SessionsService sessionService;

	public SessionController(SessionsService sessionService) {
		super();
		this.sessionService = sessionService;
	}
	
	@PostMapping
	public SessionPomodoro startSession(@RequestBody SessionPomodoro session) {
		return sessionService.startSession(session);
	}
	
	@PutMapping("/{id}")
	public SessionPomodoro endSession(@PathVariable Long id) {
		return sessionService.endSession(id);
	}
	

	@GetMapping
	public List<SessionPomodoro> getAllSessions() {
		
		return sessionService.getAllSessions();
	}
	
}
