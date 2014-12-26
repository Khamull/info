// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Caixa.java

package caixaloja;

import cadastro.Funcionario;
import cadastro.Usuario;

public class Caixa
{

    public Caixa()
    {
        usuario = new Usuario();
        funcionario = new Funcionario();
    }

    public String verificaCaixa()
    {
        return (new StringBuilder("SELECT * FROM caixa WHERE status = 'A' and usuario = '")).append(usuario.login).append("'").toString();
    }

    public String caixaPorID()
    {
        return (new StringBuilder("SELECT * FROM caixa WHERE caixaID = '")).append(caixaID).append("'").toString();
    }

    public String abreCaixa()
    {
        String cadastra = "INSERT INTO caixa ";
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("(usuario, funcionario, valorInicial, valorFinal, vendaInicial, vendaFinal, servicoInicial, servicoFinal,").toString();
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append(" lancamentoInicial, lancamentoFinal, retiradaInicial, retiradaFinal, dataInicio) ").toString();
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("VALUES ").toString();
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("( '").append(usuario.login).append("', '").append(funcionario.nome).append("', '").append(valorInicial).append("', '0.00', '").append(vendaInicial).append("', '0', '").append(servicoInicial).append("',").toString();
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append(" '0', '").append(lancamentoInicial).append("', '0', '").append(retiradaInicial).append("', '0', CURRENT_TIMESTAMP)").toString();
        return cadastra;
    }

    public String fechaCaixa()
    {
        String fechamento = "UPDATE caixa SET ";
        fechamento = (new StringBuilder(String.valueOf(fechamento))).append("valorFinal = '").append(valorFinal).append("', vendaFinal = '").append(vendaFinal).append("', servicoFinal = '").append(servicoFinal).append("', ").toString();
        fechamento = (new StringBuilder(String.valueOf(fechamento))).append("lancamentoFinal = '").append(lancamentoFinal).append("', retiradaFinal = '").append(retiradaFinal).append("', status = 'F' ").toString();
        fechamento = (new StringBuilder(String.valueOf(fechamento))).append("WHERE caixaID = '").append(caixaID).append("'").toString();
        return fechamento;
    }

    public String listaFechamentos(String dataInicio, String dataFim)
    {
        String lista = "SELECT funcionario.funcionarioID, funcionario.funcionarioNome, caixa.* ";
        lista = (new StringBuilder(String.valueOf(lista))).append("FROM caixa ").toString();
        lista = (new StringBuilder(String.valueOf(lista))).append("INNER JOIN funcionario ON funcionario.funcionarioID = caixa.funcionario ").toString();
        lista = (new StringBuilder(String.valueOf(lista))).append("WHERE caixa.status = 'F' AND data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        lista = (new StringBuilder(String.valueOf(lista))).append("ORDER BY caixa.caixaID DESC").toString();
        return lista;
    }

    public String listaFechamentosPorUsuario(String dataInicio, String dataFim)
    {
        String lista = "SELECT funcionario.funcionarioID, funcionario.funcionarioNome, caixa.* ";
        lista = (new StringBuilder(String.valueOf(lista))).append("FROM caixa ").toString();
        lista = (new StringBuilder(String.valueOf(lista))).append("INNER JOIN funcionario ON funcionario.funcionarioID = caixa.funcionario ").toString();
        lista = (new StringBuilder(String.valueOf(lista))).append("WHERE caixa.status = 'F' AND usuario = '").append(usuario.login).append("' AND data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        lista = (new StringBuilder(String.valueOf(lista))).append("ORDER BY caixa.caixaID DESC").toString();
        return lista;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Caixa Aberto!";

        case 2: // '\002'
            return "Caixa Fechado!";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int caixaID;
    public Usuario usuario;
    public Funcionario funcionario;
    public float valorInicial;
    public float valorFinal;
    public int vendaInicial;
    public int vendaFinal;
    public int servicoInicial;
    public int servicoFinal;
    public int lancamentoInicial;
    public int lancamentoFinal;
    public int retiradaInicial;
    public int retiradaFinal;
}
