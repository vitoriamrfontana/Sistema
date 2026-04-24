package br.com.jpm.sistema.repository;

import br.com.jpm.sistema.model.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
