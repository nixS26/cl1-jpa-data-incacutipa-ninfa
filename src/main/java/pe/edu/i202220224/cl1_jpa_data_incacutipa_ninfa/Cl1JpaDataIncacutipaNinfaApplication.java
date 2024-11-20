package pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity.Country;
import pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity.CountryLanguage;
import pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.repository.CountryRepository;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class Cl1JpaDataIncacutipaNinfaApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {

		SpringApplication.run(Cl1JpaDataIncacutipaNinfaApplication.class, args);
	}


	//IMPLEMENTAMOS EL METODO RUN
	@Override
	public void run(String... args) throws Exception {

		/*countryRepository.findAll().forEach(System.out::println);*/

		//CONSULTA 1 CON IS PRESENT OR ELSE
		Optional<Country> optional =countryRepository.findById("ARG"); //ARGENTINA
		optional.ifPresentOrElse(
				(item) -> {
					System.out.println("Languages spoken in ARG:");
					for (CountryLanguage countryLanguage : item.getLanguages()) {
						System.out.println(countryLanguage.getLanguage());
					}
				},
				()-> {
					Optional<Country> optionalPer = countryRepository.findById("PER");//PERU
					optionalPer.ifPresentOrElse(
							(perItem) -> {
								System.out.println("Languages spoken in PER:");
								for (CountryLanguage countryLanguage : perItem.getLanguages()) {
									System.out.println(countryLanguage.getLanguage());
								}
							},
							() -> System.out.println("Country PER not found.")

					);
				}
		);


		//CONSULTA 2 CON o	deleteAllById()

		// LISTA DE COD DE APISES A ELIMINAR
		List<String> countryCodes = List.of("COL", "ARG");

		// REALIZAMOS PRIMERO LA VERIFICACIÓN DE SU EXISTENCIA
		for (String code : countryCodes) {
			Optional<Country> countryOptional = countryRepository.findById(code);
			if (countryOptional.isPresent()) {
				countryRepository.deleteAllById(List.of(code));

				System.out.println("PAIS " + code + " ELIMINADO CON EXITO.");
			} else {
				System.out.println("EL PAIS " + code + " NO SE ESTA EN LA BASE DE DATOS.");
			}
		}




	} //fin del metodo run...
}
