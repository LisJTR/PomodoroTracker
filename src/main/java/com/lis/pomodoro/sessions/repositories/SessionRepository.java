package com.lis.pomodoro.sessions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lis.pomodoro.sessions.entity.SessionPomodoro;

public interface SessionRepository extends JpaRepository<SessionPomodoro, Long>{

}
