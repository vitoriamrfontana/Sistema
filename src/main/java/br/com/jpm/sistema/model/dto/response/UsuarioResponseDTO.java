package br.com.jpm.sistema.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    private String nome;
    private String email;
    private String senha;
    private PerfilResponseDTO perfil;
}
