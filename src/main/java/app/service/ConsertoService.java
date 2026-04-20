package app.service;

import app.dto.ConsertoDTO;
import app.entity.Conserto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import app.repository.ConsertoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsertoService {
    private final ConsertoRepository consertoRepository;

    public ConsertoDTO create(ConsertoDTO dto) {
        Conserto conserto = toEntity(dto);
        Conserto saved = consertoRepository.save(conserto);
        return toDTO(saved);
    }

    // GET ONE - Buscar por ID
    public ConsertoDTO findById(Long id) {
        Conserto conserto = consertoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Conserto com ID " + id + " não foi encontrado."
                ));
        return toDTO(conserto);
    }

    public List<ConsertoDTO> findAll() {
        return consertoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ConsertoDTO toDTO(Conserto conserto) {
        return new ConsertoDTO(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanicoResposavel(),
                conserto.getVeiculo()
        );
    }

    private Conserto toEntity(ConsertoDTO dto) {
        return new Conserto(
                dto.id(),
                dto.dataEntrada(),
                dto.dataSaida(),
                dto.mecanicoResposavel(),
                dto.veiculo()
        );
    }

}
