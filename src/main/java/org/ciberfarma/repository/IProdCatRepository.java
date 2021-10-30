package org.ciberfarma.repository;

import java.util.List;

import org.ciberfarma.model.ProdCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdCatRepository extends JpaRepository<ProdCat, String> {
//CRUD
	@Query(value = "call usp_prodcat();", nativeQuery = true)
	List<ProdCat> listaProdCat();

}
