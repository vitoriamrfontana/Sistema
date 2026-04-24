package br.com.jpm.sistema.service;

import br.com.jpm.sistema.factory.UsuarioFactory;
import br.com.jpm.sistema.model.dto.request.UsuarioRequestDTO;
import br.com.jpm.sistema.model.dto.response.UsuarioResponseDTO;
import br.com.jpm.sistema.model.entity.Usuario;
import br.com.jpm.sistema.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    public UsuarioResponseDTO findByIdDto(Long usuarioId) {
        return repository.findById(usuarioId)
                .map(UsuarioFactory::entityToResponse)
                .orElseThrow(()-> new EntityNotFoundException("Usuario não encontrado"));
    }
    public UsuarioResponseDTO create(UsuarioRequestDTO dto){
        Usuario usuario = UsuarioFactory.dtoToEntitySetGet(dto);
        Usuario usuarioSave = repository.save(usuario);
        if (usuarioSave.getPerfil() == null && usuario.getPerfil() != null) {
            usuarioSave.setPerfil(usuario.getPerfil());
        }
        return UsuarioFactory.entityToResponse(usuarioSave);
    }
}
