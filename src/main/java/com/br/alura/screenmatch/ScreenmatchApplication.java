package com.br.alura.screenmatch;

import com.br.alura.screenmatch.Model.Serie;
import com.br.alura.screenmatch.Service.ConsumoApi;
import com.br.alura.screenmatch.Service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando minha aplicação de Filmes e Séries");

		ConsumoApi consumoApi = new ConsumoApi();
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=d08562e6");

		ConverteDados conversor = new ConverteDados();

		Serie serie = conversor.obterDados(json, Serie.class);

		System.out.println("Esta é minha Série: " + serie);
	}
}
