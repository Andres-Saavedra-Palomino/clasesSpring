package org.ciberfarma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_proveedor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proveedor {
	@Id
	@GeneratedValue
	@Column(name="idproveedor")
	private Long codigo;
	@Column(name="nombre_rs")
	private String nombre; 
	
	private String telefono;
	
	private String email;
}
