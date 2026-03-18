package com.lis.pomodoro.sessions.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lis.pomodoro.sessions.entity.SessionPomodoro;
import com.lis.pomodoro.sessions.repositories.SessionRepository;
import com.lis.pomodoro.sessions.service.SessionsService;

@Service
public class SessionsServiceImpl implements SessionsService{
	
	private final SessionRepository sessionRepository;
	
	public SessionsServiceImpl(SessionRepository sessionRepository) {
		super();
		this.sessionRepository = sessionRepository;
	}

	@Override
	public SessionPomodoro startSession(SessionPomodoro session) {
		// TODO Auto-generated method stub
		return sessionRepository.save(session);
	}

	@Override
	public SessionPomodoro endSession(Long id) {
		// TODO Auto-generated method stub
		
		SessionPomodoro existingSession = sessionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Session no encontrada"));
				
				LocalDateTime endTime = LocalDateTime.now();
				existingSession.setEnded(endTime);
				
				Long durationMinutes = 
						ChronoUnit.MINUTES.between(existingSession.getStarted(), endTime);
				existingSession.setTotalDuracion(durationMinutes);
		
		return sessionRepository.save(existingSession);
	}

	@Override
	public List<SessionPomodoro> getAllSessions() {
		// TODO Auto-generated method stub
		return sessionRepository.findAll();
	}

}
