package app.controller;

import app.dto.MecanicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.service.MecanicoService;

import java.util.List;

@RestController
@RequestMapping("/mecanicos")
@RequiredArgsConstructor
public class MecanicoController {

    private final MecanicoService mecanicoService;

    @PostMapping
    public ResponseEntity<MecanicoDTO> create(@RequestBody MecanicoDTO dto) {
        MecanicoDTO created = mecanicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MecanicoDTO> findById(@PathVariable Long id) {
        MecanicoDTO mecanico = mecanicoService.findById(id);
        return ResponseEntity.ok(mecanico);
    }

    @GetMapping
    public ResponseEntity<List<MecanicoDTO>> findAll() {
        List<MecanicoDTO> mecanicos = mecanicoService.findAll();
        return ResponseEntity.ok(mecanicos);
    }
}
