package br.com.jpm.sistema.controller;

import br.com.jpm.sistema.model.dto.request.UsuarioRequestDTO;
import br.com.jpm.sistema.model.dto.response.UsuarioResponseDTO;
import br.com.jpm.sistema.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * READ
     */

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long usuarioId) {
         return ResponseEntity.ok(usuarioService.findByIdDto(usuarioId));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.create(dto));

    }
}
