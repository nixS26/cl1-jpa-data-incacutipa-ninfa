package pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity.Country;
import pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.entity.CountryLanguage;
import pe.edu.i202220224.cl1_jpa_data_incacutipa_ninfa.repository.CountryRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class Cl1JpaDataIncacutipaNinfaApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {

		SpringApplication.run(Cl1JpaDataIncacutipaNinfaApplication.class, args);
	}

	@PersistenceContext
	private EntityManager entityManager;
	//IMPLEMENTAMOS EL METODO RUN
	@Override
	public void run(String... args) throws Exception {

		/*countryRepository.findAll().forEach(System.out::println);*/

		/*if(countryRepository.existsById("ARG")){
			System.out.println("Customer exists");
		}else{
			System.out.println("Customer does not exist");
		}
*/
//PROBANDO

		/*Iterable<String> ids = List.of("ARG","PER");
		Iterable<Country> iterable = countryRepository.findAllById(ids);
		iterable.forEach(System.out::println);*/


		/**
		 * PRIMERA CONSULTA, PER O ARG
		 */

		/*Optional<Country> optionalArg = countryRepository.findById("PER");

		// Usar ifPresentOrElse para manejar el resultado
		optionalArg.ifPresentOrElse(
				(countryArg) -> {
					// Si se encuentran lenguajes para "ARG", imprimirlos
					System.out.println("Languages spoken in ARG:");
					countryArg.getLanguages().forEach(language -> System.out.println(language.getLanguage()));
				},
				() -> {
					// Si no se encuentran lenguajes para "ARG", buscar lenguajes del país "PER"
					Optional<Country> optionalPer = countryRepository.findById("PER");
					optionalPer.ifPresentOrElse(
							countryPer -> {
								// Si se encuentran lenguajes para "PER", imprimirlos
								System.out.println("Languages spoken in PER:");
								countryPer.getLanguages().forEach(language -> System.out.println(language.getLanguage()));
							},
							() -> {
								// Si no se encuentran lenguajes para ninguno de los dos países, imprimir un mensaje de error
								System.out.println("No languages found for ARG or PER.");
							}
					);
				}
		);*/







/*
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
		);*/





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
