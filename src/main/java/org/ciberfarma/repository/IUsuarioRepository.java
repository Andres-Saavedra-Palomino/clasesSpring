package org.ciberfarma.repository;

import java.util.List;

import org.ciberfarma.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByCorreoAndClave(String correo, String clave);
	
	@Query(name = "select * from tb_usuarios;", nativeQuery = true )
  List<Usuario> productoscat();
}
