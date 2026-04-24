package app.conserto;

import app.mecanico.Mecanico;
import app.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Conserto")
@Table(name = "consertos")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    @Embedded
    private Mecanico mecanicoResposavel;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public void inativar() {
        this.ativo = false;
    }

    public void atualizarInformacoes(LocalDate novaDataSaida, String nomeMecanico, Integer anosExperiencia) {
        if (novaDataSaida != null) {
            this.dataSaida = novaDataSaida;
        }

        // Repassa a atualização para o objeto embutido (Mecanico)
        if (this.mecanicoResposavel != null) {
            this.mecanicoResposavel.atualizarDados(nomeMecanico, anosExperiencia);
        }
    }
}
