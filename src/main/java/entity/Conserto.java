package entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_conserto")
public class Conserto {
    @Id
    private Long id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    @Embedded
    private Mecanico mecanicoResposavel;
    @Embedded
    private Veiculo veiculo;
}
