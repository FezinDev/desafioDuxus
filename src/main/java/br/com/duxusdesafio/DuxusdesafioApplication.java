package br.com.duxusdesafio;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ApiService;

@SpringBootApplication
public class DuxusdesafioApplication {

	public static void main(String[] args) {

		SpringApplication.run(DuxusdesafioApplication.class, args);

		//  ApiService c = new ApiService();

		//  LocalDate data = LocalDate.of(2024, 11, 5);
		//  Time timeEncontrado = c.timeDaData(data, todosOsTimes);

		//  if (timeEncontrado != null) {
		//  	System.out.println("Time encontrado: " + timeEncontrado);
		//  } else {
		//  	System.out.println("Nenhum time encontrado para a data: " + data);
		//  }

	}

}
