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

    @Column(name = "minutos_seleccionados", nullable = false)
    private Long minutosSeleccionados;

    @Column(name = "minutos_descanso", nullable = false)
    private Long minutosDescanso;

    @Column(name = "started", nullable = false)
    private LocalDateTime started;

    @Column(name = "ended")
    private LocalDateTime ended;

    @Column(name = "total_duration")
    private Long totalDuracion;

    @Column(name = "ciclos_seleccionados")
    private Long ciclosSeleccionados;

    public SessionPomodoro() {
    	
    }

    @PrePersist
    protected void onCreate() {
        this.started = LocalDateTime.now();
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

	public Long getMinutosSeleccionados() {
		return minutosSeleccionados;
	}

	public void setMinutosSeleccionados(Long minutosSeleccionados) {
		this.minutosSeleccionados = minutosSeleccionados;
	}

	public Long getMinutosDescanso() {
		return minutosDescanso;
	}

	public void setMinutosDescanso(Long minutosDescanso) {
		this.minutosDescanso = minutosDescanso;
	}

	public LocalDateTime getStarted() {
		return started;
	}

	public void setStarted(LocalDateTime started) {
		this.started = started;
	}

	public LocalDateTime getEnded() {
		return ended;
	}

	public void setEnded(LocalDateTime ended) {
		this.ended = ended;
	}

	public Long getTotalDuracion() {
		return totalDuracion;
	}

	public void setTotalDuracion(Long totalDuracion) {
		this.totalDuracion = totalDuracion;
	}

	public Long getCiclosSeleccionados() {
		return ciclosSeleccionados;
	}

	public void setCiclosSeleccionados(Long ciclosSeleccionados) {
		this.ciclosSeleccionados = ciclosSeleccionados;
	}

	

    
  
}
