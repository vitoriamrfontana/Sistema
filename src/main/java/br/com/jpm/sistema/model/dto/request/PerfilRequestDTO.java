package br.com.jpm.sistema.model.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilRequestDTO {

    @Nullable
    private Long perfilId;

    @Nullable
    private Long usuarioId;

    @NotBlank(message = "A bio do perfil deve ser informada!")
    private String bio;

    @NotBlank(message = "O link da foto deve ser informado!")
    private String foto;

}
