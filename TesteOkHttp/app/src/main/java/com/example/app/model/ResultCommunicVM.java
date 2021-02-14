package com.example.app.model;

public class ResultCommunicVM<T> {
    /// <summary>
    /// Padrão = Resultado.Erro
    /// </summary>
    public Resultado Resultado;
    public String Mensagem;
    public T Valor;

    public ResultCommunicVM()
    {
        Resultado = Resultado.Erro;
    }

    /// <summary>
    /// Operação Realizada com Sucesso
    /// </summary>
    public boolean Sucesso()
    {
        return Resultado == Resultado.Sucesso;
    }

    /// <summary>
    /// Operação Realizada com Sucesso
    /// </summary>
    public boolean ErroDeRegra()
    {
        return Resultado == Resultado.ErroDeRegra;
    }

    /// <summary>
    /// Erro na Operação - Retorno em Mensagem
    /// </summary>
    public boolean Erro()
    {
        return Resultado == Resultado.Erro;
    }

    /// <summary>
    /// Registro não Encontrado
    /// </summary>
    public boolean NaoEncontrado()
    {
        return Resultado == Resultado.NaoEncontrado;
    }

    /// <summary>
    /// Servidor não encontrado
    /// </summary>
    public boolean ServidorNaoEncontrado()
    {
        return Resultado == Resultado.ServidorNaoEncontrado;
    }

    /// <summary>
    /// Sem internet ou Servidor não encontrado
    /// </summary>
    public boolean SemInternetOuServidor()
    {
        return Resultado == Resultado.ServidorNaoEncontrado || Resultado == Resultado.SemInternet;
    }

    public enum Resultado
    {
        Sucesso,
        ErroDeRegra,
        Erro,
        NaoEncontrado,
        SemInternet,
        ServidorNaoEncontrado
    }
}
