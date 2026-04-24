package br.com.jpm.sistema.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilResponseDTO {

    private String bio;
    private String foto;
    private UsuarioResponseDTO usuario;
}
