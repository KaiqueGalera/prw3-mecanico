package service;

import dto.MecanicoDTO;
import entity.Mecanico;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.MecanicoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MecanicoService {
    private final MecanicoRepository mecanicoRepository;

    // POST - Criar novo mecânico
    public MecanicoDTO create(MecanicoDTO dto) {
        Mecanico mecanico = toEntity(dto);
        Mecanico saved = mecanicoRepository.save(mecanico);
        return toDTO(saved);
    }

    // GET ONE - Buscar por ID
    public MecanicoDTO findById(Long id) {
        Mecanico mecanico = mecanicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Mecânico com ID " + id + " não foi encontrado."
                ));
        return toDTO(mecanico);
    }

    // GET ALL - Listar todos
    public List<MecanicoDTO> findAll() {
        return mecanicoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Mappers
    private MecanicoDTO toDTO(Mecanico mecanico) {
        return new MecanicoDTO(
                mecanico.getId(),
                mecanico.getNome(),
                mecanico.getAnosDeExperiencia()
        );
    }

    private Mecanico toEntity(MecanicoDTO dto) {
        return new Mecanico(
                dto.id(),
                dto.nome(),
                dto.anosDeExperiencia()
        );
    }
}
