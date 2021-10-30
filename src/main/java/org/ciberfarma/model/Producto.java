package org.ciberfarma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_productos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {
	@Id
	@Column(name = "id_prod")
	private String codigo;
	@Column(name = "des_prod")
	private String descripcion;
	@Column(name = "stk_prod")
	private int stock;
	@Column(name = "pre_prod")
	private double precio;

	@JoinColumn(name="idcategoria")
	@ManyToOne()
	private Categoria categoria;

	@Column(name = "est_prod")
	private int estado;

	@JoinColumn(name="idproveedor")
	@ManyToOne()
	private Proveedor proveedor;
	
}
