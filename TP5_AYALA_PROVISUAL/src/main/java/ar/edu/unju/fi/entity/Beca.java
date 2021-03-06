package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "becas")
@Component
public class Beca implements Serializable{

	private static final long serialVersionUID = 1872669891004784066L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "codigo")
	private int codigo;
	@Column(name = "inicio")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @FutureOrPresent(message = "La fecha debe ser actual o futura")
	private LocalDate fechaInicio;
	@Column(name = "cierre")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @FutureOrPresent(message = "La fecha debe ser actual o futura")
	private LocalDate fechaCierre;
	@Column(name = "estado")
	@NotNull(message="Debe elegir un estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "becas")
	private Curso curso;
	
	
	public Beca(LocalDate fechaInicio, LocalDate fechaCierre, boolean estado) {
		this.fechaInicio = fechaInicio;
		this.fechaCierre = fechaCierre;
		this.estado = estado;
	}
	public Beca() {
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
	
}