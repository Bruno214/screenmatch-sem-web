package com.br.alura.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Serie(@JsonAlias("Title") String titulo,
                    @JsonAlias("totalSeasons") Integer totalTemporadas,
                    @JsonAlias("Season") String temporada,
                    List<Episodio> episodios) {
    public Serie {
        episodios = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder("\nSerie: \n " +
                "   Título: " + titulo() +
                "   Total temporadas: " + totalTemporadas() +
                "   Número temporada: " + temporada());

        if (episodios() != null && !episodios().isEmpty()) {
            retorno.append("\n          Episodios: \n");
            for ( Episodio episodio : episodios()) {
                retorno.append(episodio).append("\n");
            }
        }

        return retorno.toString();


    }
}
