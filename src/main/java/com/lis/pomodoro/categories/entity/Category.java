package com.lis.pomodoro.categories.entity;

import java.time.LocalDateTime;

import com.lis.pomodoro.users.entity.User;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	@Column(name="fecha_creacion", nullable = false)
	private LocalDateTime fechaCreacion;
	
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = LocalDateTime.now();
	}
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String nombre, User user) {
		super();
		this.nombre = nombre;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", nombre=" + nombre + ", user=" + user + ", createdAt=" + fechaCreacion + "]";
	}

	


}
