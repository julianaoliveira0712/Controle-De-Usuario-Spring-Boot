package br.com.bandtec.AgendaDeObjetivos;

import br.com.bandtec.AgendaDeObjetivos.controller.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AgendaDeObjetivosApplication {

	public static void main(String[] args) {
		Database database = new Database();
		Database.database = database;
		SpringApplication.run(AgendaDeObjetivosApplication.class, args);
		System.out.println("oi");
	}

}
