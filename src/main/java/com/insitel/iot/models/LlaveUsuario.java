/**
 * 
 */
package com.insitel.iot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_key_user")
public class LlaveUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kus_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "kus_key_id")
	private Long llave;
	
	@Column(name = "kus_usr_id")
	private Long usuario;
	
	//**Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLlave() {
		return llave;
	}

	public void setLlave(Long llave) {
		this.llave = llave;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "LlsveUsuario [id=" + id + ", llave=" + llave + ", usuario=" + usuario + "]";
	}
	
}
