package pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryLanguage {

    @Id
    @Column(name = "CountryCode", nullable = false)
    private String CountryCode;
    @Id
    @Column(name = "Language", nullable = false)
    private String Language;
    @Column(name = "IsOfficial")
    private String isOfficial;
    private Double Percentage;

    // Relación con Country
    @ManyToOne
    @MapsId("CountryCode")
    @JoinColumn(name = "CountryCode", nullable = false, insertable = false, updatable = false)
    private Country country;
}
