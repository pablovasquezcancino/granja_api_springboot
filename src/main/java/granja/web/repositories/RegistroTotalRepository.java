package granja.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import granja.web.models.RegistroTotal;





@Repository
public interface RegistroTotalRepository extends JpaRepository<RegistroTotal, Long>{ //agregar datos e primary key
	//logica de manipulacion de datos(CRUD+)
}