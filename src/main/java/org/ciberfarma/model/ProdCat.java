package org.ciberfarma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdCat {
	@Id
	@Column(name="id_prod")
	private String codigo;
	@Column(name="des_prod")
	private String nomprod;
	@Column(name="stk_prod")
	private int stock;
	@Column(name="pre_prod")
	private double precio;
	@Column(name="descripcion")
	private String categoria;
}
