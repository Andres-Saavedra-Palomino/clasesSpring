package org.ciberfarma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_categorias")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categoria {
	@Id
	@Column(name="idcategoria")
	private int codigo;

	private String descripcion;
	
	
}
