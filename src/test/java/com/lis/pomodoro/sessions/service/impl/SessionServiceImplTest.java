package com.lis.pomodoro.sessions.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lis.pomodoro.sessions.entity.SessionPomodoro;
import com.lis.pomodoro.sessions.repositories.SessionRepository;


@ExtendWith(MockitoExtension.class)
public class SessionServiceImplTest {
	

	@Mock
	private SessionRepository sessionRepositoryFalse;
	
	@InjectMocks
	private SessionsServiceImpl sessionService;
	
	@Test
	void shouldStartSession() {
		
		SessionPomodoro sessionPomodoro = new SessionPomodoro();
		sessionPomodoro.setMinutosSeleccionados(2L);
		sessionPomodoro.setMinutosDescanso(10L);
		sessionPomodoro.setStarted(LocalDateTime.now());
		sessionPomodoro.setCiclosSeleccionados(2L);
		
		when(sessionRepositoryFalse.save(sessionPomodoro)).thenReturn(sessionPomodoro);
		
		SessionPomodoro realSession = sessionService.startSession(sessionPomodoro);
		
		assertEquals(sessionPomodoro, realSession);
	}
	
	@Test
	void shouldEndSession() {
		
	    Long id = 1L;

	    SessionPomodoro sessionPomodoro = new SessionPomodoro();
	    sessionPomodoro.setId(id);

	    sessionPomodoro.setStarted(LocalDateTime.now().minusMinutes(25));

	    when(sessionRepositoryFalse.findById(id)).thenReturn(Optional.of(sessionPomodoro));

	    when(sessionRepositoryFalse.save(sessionPomodoro)).thenReturn(sessionPomodoro);


	    SessionPomodoro realSession = sessionService.endSession(id);

	    assertNotNull(realSession.getEnded());
	    assertNotNull(realSession.getTotalDuracion());

	    verify(sessionRepositoryFalse).findById(id);
	    verify(sessionRepositoryFalse).save(sessionPomodoro);
	}
	
	@Test
	void shouldGetAllSessions() {
		
		SessionPomodoro sessionPomodoro1 = new SessionPomodoro();
		sessionPomodoro1.setMinutosSeleccionados(2L);
		sessionPomodoro1.setMinutosDescanso(10L);
		sessionPomodoro1.setStarted(LocalDateTime.now());
		sessionPomodoro1.setCiclosSeleccionados(2L);
		
		SessionPomodoro sessionPomodoro2 = new SessionPomodoro();
		sessionPomodoro2.setMinutosSeleccionados(1L);
		sessionPomodoro2.setMinutosDescanso(15L);
		sessionPomodoro2.setStarted(LocalDateTime.now());
		sessionPomodoro2.setCiclosSeleccionados(3L);
		
		List<SessionPomodoro> sessions = List.of(sessionPomodoro1, sessionPomodoro2);
		
		when(sessionRepositoryFalse.findAll()).thenReturn(sessions);
		
		List<SessionPomodoro> listData = sessionService.getAllSessions();
		
		assertEquals(sessions, listData);
	}
}
