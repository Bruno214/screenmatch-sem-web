package com.br.alura.screenmatch;

import com.br.alura.screenmatch.Model.DadosEpisodio;
import com.br.alura.screenmatch.Model.Principal;
import com.br.alura.screenmatch.Model.Serie;
import com.br.alura.screenmatch.Model.Temporada;
import com.br.alura.screenmatch.Service.ConsumoApi;
import com.br.alura.screenmatch.Service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}
	private static final ConsumoApi consumoApi = new ConsumoApi();
	private static final ConverteDados conversor= new ConverteDados();
	@Override
	public void run(String... args) throws Exception {;

		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
