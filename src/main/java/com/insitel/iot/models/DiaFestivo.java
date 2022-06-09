/**
 * 
 */
package com.insitel.iot.models;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_holiday")
public class DiaFestivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hol_id", unique = true, nullable = false)
	private Long id;
	
	@JoinColumn(name = "hol_cnt_id", referencedColumnName = "cnt_id")
//	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@ManyToOne
	private Pais pais;
	
	@Column(name = "hol_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@Column(name = "hol_description")
	private String descripcion;

	//**Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "DiaFestivo [id=" + id + ", pais=" + pais + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}
	
}
