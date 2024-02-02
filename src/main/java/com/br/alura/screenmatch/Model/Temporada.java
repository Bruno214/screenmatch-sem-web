package com.br.alura.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Temporada(@JsonAlias("Season") Integer numeroTemporada,
                        @JsonAlias("Episodes") List<Episodio> episodios) {

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder("\n" + "Número temporada: " + numeroTemporada());

        if (episodios() != null && !episodios().isEmpty()) {
            retorno.append("\n  Episodios: \n");
            for ( Episodio episodio : episodios()) {
                retorno.append(episodio).append("\n");
            }
        }

        return retorno.toString();


    }
}
