package br.com.jpm.sistema.factory;

import br.com.jpm.sistema.model.dto.request.UsuarioRequestDTO;
import br.com.jpm.sistema.model.dto.response.UsuarioResponseDTO;
import br.com.jpm.sistema.model.entity.Perfil;
import br.com.jpm.sistema.model.entity.Usuario;

public class UsuarioFactory {

    public static Usuario dtoToEntitySetGet(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        if (dto.getPerfil() != null) {
            Perfil perfil = new Perfil();
            perfil.setBio(dto.getPerfil().getBio());
            perfil.setFoto(dto.getPerfil().getFoto());
            usuario.setPerfil(perfil);
            perfil.setUsuario(usuario);
        }
        return usuario;

    }

    public static UsuarioRequestDTO entityToDtoSetGet(Usuario usuario) {
        UsuarioRequestDTO dto = new UsuarioRequestDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());
        return dto;
    }

    public static Usuario dtoToEntityContructor(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario(
                dto.getNome(),
                dto.getEmail(),
                dto.getSenha()
        );
        return usuario;
    }

    public static UsuarioResponseDTO entityToResponse(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());

        if (usuario.getPerfil() != null){
            dto.setPerfil(PerfilFactory.entityToResponse(usuario.getPerfil()));
        }
        return dto;
    }

}
