package pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ESTRATEGIA DE GENERACION DE PK
    private Integer ID;

    private String Name;
    private String District;
    private Integer Population;

    // Relación con Country
    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;
}
