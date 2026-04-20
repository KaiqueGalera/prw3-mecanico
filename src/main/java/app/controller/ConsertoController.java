package app.controller;

import app.dto.ConsertoDTO;
import app.dto.ConsertoResumoDTO;
import app.service.ConsertoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consertos")
@RequiredArgsConstructor
public class ConsertoController {

    private final ConsertoService consertoService;

    @PostMapping
    public ConsertoDTO create(@RequestBody @Valid ConsertoDTO dto) {
        return consertoService.create(dto);
    }

    @GetMapping("/{id}")
    public ConsertoDTO findById(@PathVariable Long id) {
        return consertoService.findById(id);
    }

    // todos os dados com paginação
    @GetMapping
    public Page<ConsertoDTO> findAll(Pageable pageable) {
        return consertoService.findAll(pageable);
    }

    // apenas datas + nome do mecânico + marca + modelo, sem paginação
    @GetMapping("/resumo")
    public List<ConsertoResumoDTO> findAllResumo() {
        return consertoService.findAllResumo();
    }
}