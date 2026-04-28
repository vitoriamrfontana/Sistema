package br.com.jpm.sistema.factory;

import br.com.jpm.sistema.model.dto.request.PerfilRequestDTO;
import br.com.jpm.sistema.model.dto.response.PerfilResponseDTO;
import br.com.jpm.sistema.model.dto.response.UsuarioResponseDTO;
import br.com.jpm.sistema.model.entity.Perfil;
import br.com.jpm.sistema.model.entity.Usuario;

public class PerfilFactory {

    public static Perfil dtoToEntitySetGet(PerfilRequestDTO dto, Usuario usuario) {
        Perfil perfil = new Perfil();
        perfil.setBio(dto.getBio());
        perfil.setFoto(dto.getFoto());

        if (usuario != null) {
            perfil.setUsuario(usuario);
            usuario.setPerfil(perfil);
        }
        return perfil;
    }

    public static PerfilRequestDTO entityToDtoSetGet(Perfil perfil) {
        PerfilRequestDTO dto = new PerfilRequestDTO();
        dto.setBio(perfil.getBio());
        dto.setFoto(perfil.getFoto());
        return dto;
    }

    public static Perfil dtoToEntityContructor(PerfilRequestDTO dto, Usuario usuario) {
        Perfil perfil = new Perfil(
                dto.getBio(),
                dto.getFoto()
        );
        return perfil;
    }

    public static PerfilResponseDTO entityToResponse(Perfil perfil) {
        PerfilResponseDTO responseDTO = new PerfilResponseDTO();
        responseDTO.setBio(perfil.getBio());
        responseDTO.setFoto(perfil.getFoto());

        if (perfil.getUsuario() != null) {
            UsuarioResponseDTO dto = new UsuarioResponseDTO();
            dto.setNome(perfil.getUsuario().getNome());
            dto.setEmail(perfil.getUsuario().getEmail());
            dto.setSenha(perfil.getUsuario().getSenha());
            responseDTO.setUsuarioResponseDTO(dto);
        }
        return responseDTO;
    }

    public static Perfil updateEntity(Perfil perfil, PerfilRequestDTO dto) {
        perfil.setBio(dto.getBio());
        perfil.setFoto(dto.getFoto());
        return perfil;
    }
}
