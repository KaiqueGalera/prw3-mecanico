package app.service;

import app.dto.ConsertoDTO;
import app.dto.ConsertoResumoDTO;
import app.dto.MecanicoDTO;
import app.dto.VeiculoDTO;
import app.entity.Conserto;
import app.entity.Mecanico;
import app.entity.Veiculo;
import app.repository.ConsertoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsertoService {

    private final ConsertoRepository consertoRepository;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ConsertoDTO create(ConsertoDTO dto) {
        Conserto conserto = toEntity(dto);
        Conserto saved = consertoRepository.save(conserto);
        return toDTO(saved);
    }

    public ConsertoDTO findById(Long id) {
        Conserto conserto = consertoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Conserto com ID " + id + " não foi encontrado."
                ));
        return toDTO(conserto);
    }

    public Page<ConsertoDTO> findAll(Pageable pageable) {
        return consertoRepository.findAll(pageable)
                .map(this::toDTO);
    }

    public List<ConsertoResumoDTO> findAllResumo() {
        return consertoRepository.findAll()
                .stream()
                .map(this::toResumoDTO)
                .toList();
    }

    private MecanicoDTO toDTOMecanico(Mecanico mecanico) {
        if (mecanico == null) {
            return null;
        }

        return new MecanicoDTO(
                mecanico.getNome(),
                mecanico.getAnosDeExperiencia()
        );
    }

    private Mecanico toEntityMecanico(MecanicoDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Mecanico(
                dto.nome(),
                dto.anosDeExperiencia()
        );
    }

    private VeiculoDTO toDTOVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            return null;
        }

        return new VeiculoDTO(
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor()
        );
    }

    private Veiculo toEntityVeiculo(VeiculoDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Veiculo(
                dto.placa(),
                dto.marca(),
                dto.modelo(),
                dto.ano(),
                dto.cor()
        );
    }

    private ConsertoDTO toDTO(Conserto conserto) {
        if (conserto == null) {
            return null;
        }

        return new ConsertoDTO(
                conserto.getId(),
                formatarData(conserto.getDataEntrada()),
                formatarData(conserto.getDataSaida()),
                toDTOMecanico(conserto.getMecanicoResposavel()),
                toDTOVeiculo(conserto.getVeiculo())
        );
    }

    private Conserto toEntity(ConsertoDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Conserto(
                dto.id(),
                parseData(dto.dataEntrada()),
                parseData(dto.dataSaida()),
                toEntityMecanico(dto.mecanicoResponsavel()),
                toEntityVeiculo(dto.veiculo())
        );
    }

    private ConsertoResumoDTO toResumoDTO(Conserto conserto) {
        if (conserto == null) {
            return null;
        }

        return new ConsertoResumoDTO(
                formatarData(conserto.getDataEntrada()),
                formatarData(conserto.getDataSaida()),
                conserto.getMecanicoResposavel() != null
                        ? conserto.getMecanicoResposavel().getNome()
                        : null,
                conserto.getVeiculo() != null
                        ? conserto.getVeiculo().getMarca()
                        : null,
                conserto.getVeiculo() != null
                        ? conserto.getVeiculo().getModelo()
                        : null
        );
    }

    private LocalDate parseData(String data) {
        return LocalDate.parse(data, FORMATTER);
    }

    private String formatarData(LocalDate data) {
        return data.format(FORMATTER);
    }
}