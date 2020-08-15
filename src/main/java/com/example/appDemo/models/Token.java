package com.example.appDemo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tokens")
public class Token implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="privado", length = 1000)
	private String privado;
	
	@Column(name="publico", length = 1000)
	private String publico;
	
	private Boolean ejecutado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrivado() {
		return privado;
	}

	public void setPrivado(String privado) {
		this.privado = privado;
	}

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public Boolean getEjecutado() {
		return ejecutado;
	}

	public void setEjecutado(Boolean ejecutado) {
		this.ejecutado = ejecutado;
	}
	
}
