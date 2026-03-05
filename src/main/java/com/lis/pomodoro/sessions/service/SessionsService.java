package com.lis.pomodoro.sessions.service;

import java.util.List;

import com.lis.pomodoro.sessions.entity.SessionPomodoro;

public interface SessionsService {

	SessionPomodoro startSession(SessionPomodoro session);
	SessionPomodoro endSession(Long id);
	List<SessionPomodoro> getAllSessions();
	
	
	
}
