package granja.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import granja.web.models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//Esta es la lógica de progra.

}
