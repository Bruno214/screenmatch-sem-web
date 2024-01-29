package com.br.alura.screenmatch.Service;

public interface IConverteDados {
    public <T> T obterDados(String json, Class<T> type);
}
