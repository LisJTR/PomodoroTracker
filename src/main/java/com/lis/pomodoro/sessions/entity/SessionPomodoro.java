package com.lis.pomodoro.sessions.entity;

import java.time.LocalDateTime;

import com.lis.pomodoro.categories.entity.Category;

import jakarta.persistence.*;

@Entity
@Table(name = "pomodoro_session")
public class SessionPomodoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "focus_minutes_selected", nullable = false)
    private Long focusMinutesSelected;

    @Column(name = "break_minutes_selected", nullable = false)
    private Long breakMinutesSelected;

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "total_duration_minutes")
    private Long totalDurationMinutes;

    @Column(name = "cycles_selected")
    private Long cyclesSelected;

    public SessionPomodoro() {
    	
    }

    @PrePersist
    protected void onCreate() {
        this.startedAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getFocusMinutesSelected() {
		return focusMinutesSelected;
	}

	public void setFocusMinutesSelected(Long focusMinutesSelected) {
		this.focusMinutesSelected = focusMinutesSelected;
	}

	public Long getBreakMinutesSelected() {
		return breakMinutesSelected;
	}

	public void setBreakMinutesSelected(Long breakMinutesSelected) {
		this.breakMinutesSelected = breakMinutesSelected;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}

	public Long getTotalDurationMinutes() {
		return totalDurationMinutes;
	}

	public void setTotalDurationMinutes(Long totalDurationMinutes) {
		this.totalDurationMinutes = totalDurationMinutes;
	}

	public Long getCyclesSelected() {
		return cyclesSelected;
	}

	public void setCyclesSelected(Long cyclesSelected) {
		this.cyclesSelected = cyclesSelected;
	}

    
  
}
