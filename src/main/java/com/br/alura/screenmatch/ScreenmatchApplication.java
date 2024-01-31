package com.br.alura.screenmatch;

import com.br.alura.screenmatch.Model.Episodio;
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
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&apikey=d08562e6");

		ConverteDados conversor = new ConverteDados();

		Serie serie = conversor.obterDados(json, Serie.class);

		System.out.println("Esta é minha Série: " + serie);

		Episodio meuEpisodio = getEpisodio("1", "1");
		Episodio outroEpisodio = getEpisodio("1","2");

		serie.episodios().add(meuEpisodio);
		serie.episodios().add(outroEpisodio);

		System.out.println("=================\nSerie com meu episodio: \n   " + serie);


	}

	public static Episodio getEpisodio(String numeroTemporada, String numeroEpisodio) {
		ConsumoApi consumoApi = new ConsumoApi();
		ConverteDados conversor = new ConverteDados();

		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season="+numeroTemporada
				+ "&Episode="+ numeroEpisodio+"&apikey=d08562e6");
		return conversor.obterDados(json, Episodio.class);
	}
}
