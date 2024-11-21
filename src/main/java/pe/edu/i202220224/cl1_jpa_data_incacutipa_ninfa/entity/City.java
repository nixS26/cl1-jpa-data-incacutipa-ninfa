package pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "country")
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ESTRATEGIA DE GENERACION DE PK
    @ColumnTransformer(read = "ID", write = "?")
    private Integer id;

    @Column(name = "Name")
    @ColumnTransformer(read = "Name", write = "?")
    private String name;

    @Column(name = "District")
    @ColumnTransformer(read = "District", write = "?")
    private String district;

    @Column(name = "Population")
    @ColumnTransformer(read = "Population", write = "?")
    private Integer population;

    // Relación con Country
    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;
}
