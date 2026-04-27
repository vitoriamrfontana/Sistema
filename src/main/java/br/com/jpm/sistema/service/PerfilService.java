package br.com.jpm.sistema.service;

import br.com.jpm.sistema.factory.PerfilFactory;
import br.com.jpm.sistema.model.dto.request.PerfilRequestDTO;
import br.com.jpm.sistema.model.dto.response.PerfilResponseDTO;
import br.com.jpm.sistema.model.entity.Perfil;
import br.com.jpm.sistema.model.entity.Usuario;
import br.com.jpm.sistema.repository.PerfilRepository;
import br.com.jpm.sistema.repository.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

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

    public PerfilResponseDTO create(PerfilRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(()-> new EntityNotFoundException("Usuario não encontrado para criação do perfil."));

        Perfil perfil = PerfilFactory.dtoToEntitySetGet(dto, usuario);
        perfil = repository.save(perfil);
        return PerfilFactory.entityToResponse(perfil);
    }

    /**
     * DELETE
     */

    @Transactional
    public void delete(Long id) {
        Perfil perfil = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Não é possivel deletar esse Perfil: Perfil não encontrado!"));

        if (perfil.getUsuario() != null) {
            perfil.getUsuario().setPerfil(null);
        }
        repository.delete(perfil);

    }

    /**
     * UPDATE
     */

    @Transactional
    public PerfilResponseDTO update(PerfilRequestDTO dto) {
        if (dto.getPerfilId() == null) {
            throw new EntityNotFoundException("É necessario um Id para atualizar o Perfil!");
        }
        Perfil perfil = repository.findById(dto.getPerfilId())
                .orElseThrow(()-> new EntityNotFoundException("Não é possicel atualizar o perfil: Perfil não encontrado!"));

        Perfil perfilUpdate = PerfilFactory.updateEntity(perfil, dto);

        return PerfilFactory.entityToResponse(repository.save(perfilUpdate));
    }
}
