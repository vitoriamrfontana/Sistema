package br.com.jpm.sistema.factory;

import br.com.jpm.sistema.model.dto.request.PerfilRequestDTO;
import br.com.jpm.sistema.model.dto.response.PerfilResponseDTO;
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
        PerfilResponseDTO responseDto = new PerfilResponseDTO();
        responseDto.setBio(perfil.getBio());
        responseDto.setFoto(perfil.getFoto());

        if (perfil.getUsuario() != null){
            responseDto.setUsuarioId(perfil.getUsuario().getId());

        }
        return responseDto;
    }

    public static Perfil updateEntity(Perfil perfil, PerfilRequestDTO dto) {
        perfil.setBio(dto.getBio());
        perfil.setFoto(dto.getFoto());
        return perfil;
    }
}
