package BackEndC3.ClinicaOdontologica;

import BackEndC3.ClinicaOdontologica.dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaPiApplication {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(ClinicaOdontologicaPiApplication.class, args);
	}




}
