package br.com.jpm.sistema.controller;

import br.com.jpm.sistema.factory.PerfilFactory;
import br.com.jpm.sistema.model.dto.request.PerfilRequestDTO;
import br.com.jpm.sistema.model.dto.response.PerfilResponseDTO;
import br.com.jpm.sistema.model.entity.Perfil;
import br.com.jpm.sistema.model.entity.Usuario;
import br.com.jpm.sistema.service.PerfilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    /**
     * READ
     */

    @GetMapping("/{perfilId}")
    public ResponseEntity<PerfilResponseDTO> findById(@PathVariable Long perfilId) {
        return ResponseEntity.ok(perfilService.findByIdDto(perfilId));
    }

    /**
     * CREATE
     */

    @PostMapping
    public ResponseEntity<PerfilResponseDTO> create(@Valid @RequestBody PerfilRequestDTO dto) {
        PerfilResponseDTO responseDto = perfilService.create(dto);
        return ResponseEntity.status(201).body(responseDto);

    }

    /**
     * DELETE
     */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        perfilService.delete(id);
    }

    /**
     * UPDATE
     */

    @PutMapping("/{PerfilId}")
    public ResponseEntity<PerfilResponseDTO> update(@RequestBody PerfilRequestDTO dto) {
        return ResponseEntity.ok(perfilService.update(dto));
    }
}
