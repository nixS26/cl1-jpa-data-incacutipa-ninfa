package pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"cities", "languages"})
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    @ColumnTransformer(read = "Name", write = "?")
    private String name;

    @Column(name = "Continent")
    @ColumnTransformer(read = "Continent", write = "?")
    private String Continent;

    @Column(name = "Region")
    @ColumnTransformer(read = "Region", write = "?")
    private String Region;

    @Column(name = "SurfaceArea")
    @ColumnTransformer(read = "SurfaceArea", write = "?")
    private Double surfaceArea;

    @Column(name = "IndepYear")
    @ColumnTransformer(read = "IndepYear", write = "?")
    private Integer indepYear;

    @Column(name = "Population")
    @ColumnTransformer(read = "Population", write = "?")
    private Integer population;

    @Column(name = "LifeExpectancy")
    @ColumnTransformer(read = "LifeExpectancy", write = "?")
    private Double lifeExpectancy;

    @Column(name = "GNP")
    @ColumnTransformer(read = "GNP", write = "?")
    private Double gnp;

    @Column(name = "GNPOld")
    @ColumnTransformer(read = "GNPOld", write = "?")
    private Double gnpOld;

    @Column(name = "LocalName")
    @ColumnTransformer(read = "LocalName", write = "?")
    private String localName;

    @Column(name = "GovernmentForm")
    @ColumnTransformer(read = "GovernmentForm", write = "?")
    private String governmentForm;

    @Column(name = "HeadOfState")
    @ColumnTransformer(read = "HeadOfState", write = "?")
    private String headOfState;

    @Column(name = "Capital")
    @ColumnTransformer(read = "Capital", write = "?")
    private Integer capital;

    @Column(name = "Code2")
    @ColumnTransformer(read = "Code2", write = "?")
    private String code2;

    // RELACIONAMOS CON CITY
    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<City> cities;

    // RELACIONAMOS CONB COUNTRYLANGUAGE
    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<CountryLanguage> languages;
}
