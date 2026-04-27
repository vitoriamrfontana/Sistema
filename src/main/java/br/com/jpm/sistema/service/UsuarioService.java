package br.com.jpm.sistema.service;

import br.com.jpm.sistema.factory.UsuarioFactory;
import br.com.jpm.sistema.model.dto.request.UsuarioRequestDTO;
import br.com.jpm.sistema.model.dto.response.UsuarioResponseDTO;
import br.com.jpm.sistema.model.entity.Usuario;
import br.com.jpm.sistema.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    /**
     * READ
     */

    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    public UsuarioResponseDTO findByIdDto(Long usuarioId) {
        return repository.findById(usuarioId)
                .map(UsuarioFactory::entityToResponse)
                .orElseThrow(()-> new EntityNotFoundException("Usuario não encontrado"));
    }

    /**
     * CREATE
     */

    public UsuarioResponseDTO create(UsuarioRequestDTO dto){
        Usuario usuario = UsuarioFactory.dtoToEntitySetGet(dto);
        Usuario usuarioSave = repository.save(usuario);
        if (usuarioSave.getPerfil() == null && usuario.getPerfil() != null) {
            usuarioSave.setPerfil(usuario.getPerfil());
        }
        return UsuarioFactory.entityToResponse(usuarioSave);
    }

    /**
     * DELETE
     */
    @Transactional
    public void delete(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Não é possivel deletar usuario: Usuario não encontrado!"));

        repository.delete(usuario);

    }

    /**
     * UPDATE
     */

    @Transactional
    public UsuarioResponseDTO update(UsuarioRequestDTO dto) {
        if (dto.getUsuarioId() == null) {
            throw new EntityNotFoundException("É necessario um ID para atualizar um Usuario.");
        }
        Usuario usuario = repository.findById(dto.getUsuarioId())
                .orElseThrow(()-> new EntityNotFoundException("Usuario não pode ser deleteado: Usuario não encontrado."));

        Usuario usuarioUpdate = UsuarioFactory.updateEntity(usuario, dto);

        return UsuarioFactory.entityToResponse(repository.save(usuarioUpdate));
    }
}
