package app.service;

import app.dto.VeiculoDTO;
import app.entity.Veiculo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import app.repository.VeiculoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoDTO create(VeiculoDTO dto) {
        Veiculo veiculo = toEntity(dto);
        Veiculo saved = veiculoRepository.save(veiculo);
        return toDTO(saved);
    }

    public VeiculoDTO findById(Long id){
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Veículo com ID " + id + " não foi encontrado."
                ));
        return toDTO(veiculo);
    }

    public List<VeiculoDTO> findAll(){
        return veiculoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private VeiculoDTO toDTO(Veiculo veiculo) {
        return new VeiculoDTO(
                veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno()
        );
    }

    private Veiculo toEntity(VeiculoDTO dto){
        return new Veiculo(
                dto.id(),
                dto.placa(),
                dto.marca(),
                dto.modelo(),
                dto.ano()
        );
    }

}
