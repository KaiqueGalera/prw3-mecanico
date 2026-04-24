package app.controller;

import app.dto.ConsertoDTO;
import app.dto.ConsertoResumoDTO;
import app.dto.DadosAtualizacaoConsertoDTO;
import app.service.ConsertoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/consertos")
@RequiredArgsConstructor
public class ConsertoController {

    private final ConsertoService consertoService;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsertoDTO> create(@RequestBody @Valid ConsertoDTO dto, UriComponentsBuilder uriBuilder) {
        ConsertoDTO salvo = consertoService.create(dto);
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(salvo.id()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsertoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(consertoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ConsertoDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(consertoService.findAll(pageable));
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<ConsertoResumoDTO>> findAllResumo() {
        return ResponseEntity.ok(consertoService.findAllResumo());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ConsertoDTO> update(@RequestBody @Valid DadosAtualizacaoConsertoDTO dto) {
        ConsertoDTO atualizado = consertoService.update(dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        consertoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}