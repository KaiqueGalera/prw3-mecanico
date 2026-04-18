package entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_mecanico")
public class Mecanico {
    @Id
    private Long id;
    private String nome;
    private int anosDeExperiencia;
}
