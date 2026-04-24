package br.com.jpm.sistema.service;

import br.com.jpm.sistema.factory.PerfilFactory;
import br.com.jpm.sistema.model.dto.request.PerfilRequestDTO;
import br.com.jpm.sistema.model.dto.response.PerfilResponseDTO;
import br.com.jpm.sistema.model.entity.Perfil;
import br.com.jpm.sistema.model.entity.Usuario;
import br.com.jpm.sistema.repository.PerfilRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    /**
     * READ
     */

    public Optional<Perfil> findById(Long id) {
        return repository.findById(id);

    }

    public PerfilResponseDTO findByIdDto(Long perfilId) {
        return repository.findById(perfilId)
                .map(PerfilFactory::entityToResponse)
                .orElseThrow(()-> new EntityNotFoundException("Perfil não encontraddo."));
    }

    /**
     * CREATE
     */

    public Perfil create(PerfilRequestDTO dto) {
        Usuario usuario = usuarioService.findById(dto.getUsuarioId())
                .orElseThrow(()-> new EntityNotFoundException("Usuario não encontrado para criação do perfil."));

        Perfil perfil = PerfilFactory.dtoToEntityContructor(dto, usuario);
        return repository.save(perfil);
    }

    /**
     * UPDATE
     */


}
