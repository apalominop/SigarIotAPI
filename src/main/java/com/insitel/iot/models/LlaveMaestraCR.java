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
@Table(name = "iot_masterkey_mcr")
public class LlaveMaestraCR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mkc_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "mkc_mcr_id")
	private Long cr;

	@Column(name = "mkc_key_id")
	private Long llave;
	
	//**Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCr() {
		return cr;
	}

	public void setCr(Long cr) {
		this.cr = cr;
	}

	public Long getLlave() {
		return llave;
	}

	public void setLlave(Long llave) {
		this.llave = llave;
	}

	@Override
	public String toString() {
		return "LlaveMaestraCR [id=" + id + ", cr=" + cr + ", llave=" + llave + "]";
	}

}
