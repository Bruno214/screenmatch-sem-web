package com.br.alura.screenmatch;

import com.br.alura.screenmatch.Model.Episodio;
import com.br.alura.screenmatch.Model.Serie;
import com.br.alura.screenmatch.Model.Temporada;
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
	private static final ConsumoApi consumoApi = new ConsumoApi();
	private static final ConverteDados conversor= new ConverteDados();
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando minha aplicação de Filmes e Séries");

		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&apikey=d08562e6");

		Serie serie = conversor.obterDados(json, Serie.class);

		System.out.println("Esta é minha Série: " + serie);

		// temporada
		String numeroTemporada = "1";
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season="+numeroTemporada+"&apikey=d08562e6");
		Temporada temporada = conversor.obterDados(json, Temporada.class);
		System.out.println(temporada);

		// pegando todos os epsodios de todas as temporadas
		getTodasTemporadasSerie(serie);

		System.out.println("primeira Temporada: " + serie.temporadas().get(0) + "\n");
		System.out.println("segunda Temporada: " + serie.temporadas().get(1));
		System.out.println(serie);


	}

	public static Episodio getEpisodio(String numeroTemporada, String numeroEpisodio) {
		ConsumoApi consumoApi = new ConsumoApi();
		ConverteDados conversor = new ConverteDados();

		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season="+numeroTemporada
				+ "&Episode="+ numeroEpisodio+"&apikey=d08562e6");
		return conversor.obterDados(json, Episodio.class);
	}

	public static void getTodasTemporadasSerie(Serie serie) {
		if (serie.totalTemporadas() <= 0) {
			throw new RuntimeException("Não existe nenhuma temporada para esta serie");
		}
		String json = "";
		Temporada temporada = null;
		for (int temporadaAtual = 1; temporadaAtual <= serie.totalTemporadas(); temporadaAtual++) {
			 json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season="+temporadaAtual+"&apikey=d08562e6");
			 temporada = conversor.obterDados(json, Temporada.class);
			 serie.temporadas().add(temporada);

		}

	}
}
