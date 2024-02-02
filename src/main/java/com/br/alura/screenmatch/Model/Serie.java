package com.br.alura.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Serie(@JsonAlias("Title") String titulo,
                    @JsonAlias("totalSeasons") Integer totalTemporadas,
                    List<Temporada> temporadas) {
    public Serie {
        temporadas = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder(
                "   Título: " + titulo() +
                "   Total temporadas: " + totalTemporadas());

        if (temporadas() != null && !temporadas().isEmpty()) {
            for ( Temporada temporada : temporadas()) {
                retorno.append(temporada).append("\n");
            }
        }

        return retorno.toString();


    }
}
