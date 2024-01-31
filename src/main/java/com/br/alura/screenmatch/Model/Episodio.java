package com.br.alura.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Episodio(
        @JsonAlias("Title") String tituloEpisodio,
        @JsonAlias("Episode") String numeroEpisodio,
        @JsonAlias("imdbRating") String avaliacaoEpisodio,
        @JsonAlias("Released") String dataLancamento
) {

    @Override
    public String toString() {
        return  "                Titulo: " + tituloEpisodio()+
                "                Número: " + numeroEpisodio()+
                "                Avaliação: " + avaliacaoEpisodio()+
                "                Data Lançamento: " + dataLancamento();
    }
}
