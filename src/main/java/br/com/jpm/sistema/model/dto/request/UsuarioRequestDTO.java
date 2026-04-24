package br.com.jpm.sistema.model.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {

    @Nullable
    private Long usuarioId;

    @NotBlank(message = "O nome do usuario deve ser informado!")
    private String nome;

    @NotBlank(message = "O email do usuario deve ser informado!")
    private String email;

    @NotBlank(message = "A senha do usuario deve ser informada!")
    private String senha;

    private PerfilRequestDTO perfil;
}
