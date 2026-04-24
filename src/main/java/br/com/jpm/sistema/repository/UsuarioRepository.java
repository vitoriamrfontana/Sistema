package br.com.jpm.sistema.repository;

import br.com.jpm.sistema.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
