package pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "country")
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @Column(name = "IsOfficial")
    @ColumnTransformer(read = "IsOfficial", write = "?")
    private Boolean isOfficial;

    @Column(name = "Percentage")
    @ColumnTransformer(read = "Percentage", write = "?")
    private Double percentage;

    // Relación con Country
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("countryCode")
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class CountryLanguageId implements Serializable {
        @Column(name = "CountryCode")
        @ColumnTransformer(read = "CountryCode", write = "?")
        private String countryCode;

        @Column(name = "Language")
        @ColumnTransformer(read = "Language", write = "?")
        private String language;
    }

    public String getLanguage() {
        return id.getLanguage();
    }
}