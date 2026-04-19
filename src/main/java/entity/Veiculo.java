package entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
    @Id
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private LocalDate ano;
}
