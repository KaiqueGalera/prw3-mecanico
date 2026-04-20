package controller;

import dto.ConsertoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ConsertoService;

import java.util.List;

@RestController
@RequestMapping("/conserto")
@RequiredArgsConstructor
public class ConsertoController {
    private final ConsertoService consertoService;

    @PostMapping
    public ResponseEntity<ConsertoDTO> create(@RequestBody ConsertoDTO dto) {
        ConsertoDTO created = consertoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsertoDTO> findById(@PathVariable Long id) {
        ConsertoDTO conserto = consertoService.findById(id);
        return ResponseEntity.ok(conserto);
    }

    @GetMapping
    public ResponseEntity<List<ConsertoDTO>> findAll() {
        List<ConsertoDTO> consertos = consertoService.findAll();
        return ResponseEntity.ok(consertos);
    }
}
