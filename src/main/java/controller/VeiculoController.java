package controller;

import dto.MecanicoDTO;
import dto.VeiculoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@RequestBody VeiculoDTO dto) {
        VeiculoDTO created = veiculoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        VeiculoDTO veiculo = veiculoService.findById(id);
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        List<VeiculoDTO> veiculos = veiculoService.findAll();
        return ResponseEntity.ok(veiculos);
    }
}
