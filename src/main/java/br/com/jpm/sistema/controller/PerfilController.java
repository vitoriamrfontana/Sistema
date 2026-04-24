package br.com.jpm.sistema.controller;

import br.com.jpm.sistema.factory.PerfilFactory;
import br.com.jpm.sistema.model.dto.request.PerfilRequestDTO;
import br.com.jpm.sistema.model.dto.response.PerfilResponseDTO;
import br.com.jpm.sistema.model.entity.Perfil;
import br.com.jpm.sistema.model.entity.Usuario;
import br.com.jpm.sistema.service.PerfilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/{perfilId}")
    public ResponseEntity<PerfilResponseDTO> findById(@PathVariable Long perfilId) {
        return ResponseEntity.ok(perfilService.findByIdDto(perfilId));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PerfilRequestDTO dto) {
        Perfil perfilSalvo = perfilService.create(dto);
        PerfilResponseDTO response = PerfilFactory.entityToResponse(perfilSalvo);
        return ResponseEntity.ok(response);

    }
}
