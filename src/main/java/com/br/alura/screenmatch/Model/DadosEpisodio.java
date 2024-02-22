package com.br.alura.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Episode") String numeroEpisodio,
        @JsonAlias("imdbRating") String avaliacao,
        @JsonAlias("Released") String dataLancamento
) {

    @Override
    public String toString() {
        return  "     Titulo: " + titulo()+
                "     Número episódio: " + numeroEpisodio()+
                "     Avaliação: " + avaliacao()+
                "     Data Lançamento: " + dataLancamento() + "\n";
    }
}
