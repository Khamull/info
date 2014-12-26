// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServicoFechado.java

package servico;

import cadastro.Usuario;

// Referenced classes of package servico:
//            Servico

public class ServicoFechado
{

    public ServicoFechado()
    {
        servico = new Servico();
        usuario = new Usuario();
    }

    public String cadastraServicoFechado()
    {
        String cadastra = "INSERT INTO servicofechado (servicoID, valor, formPagID, usuario) ";
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("VALUES ('").append(servico.servicoID).append("', '").append(valor).append("', '").append(formPagID).append("', '").append(usuario.usuarioID).append("')").toString();
        return cadastra;
    }

    public String somaServicos(int servicoInicio, int servicoFim)
    {
        String servicos = "SELECT SUM(valor) as totalServicos ";
        servicos = (new StringBuilder(String.valueOf(servicos))).append("FROM servicofechado ").toString();
        servicos = (new StringBuilder(String.valueOf(servicos))).append("WHERE servicofechadoID BETWEEN '").append(servicoInicio).append("' AND '").append(servicoFim).append("' ").toString();
        servicos = (new StringBuilder(String.valueOf(servicos))).append("AND usuario = '").append(usuario.usuarioID).append("'").toString();
        return servicos;
    }

    public String somaServicoFormaPgto(int servicoInicio, int servicoFim)
    {
        String vendas = "SELECT formapagamento.formID, formapagamento.descricao, ";
        vendas = (new StringBuilder(String.valueOf(vendas))).append("SUM(servicofechado.valor) as totalServicos, servicofechado.formPagID ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("FROM servicofechado ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("INNER JOIN formapagamento ON formapagamento.formID = servicofechado.formPagID ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("WHERE servicofechado.servicofechadoID BETWEEN '").append(servicoInicio).append("' AND '").append(servicoFim).append("' ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("AND servicofechado.usuario = '").append(usuario.usuarioID).append("' ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("GROUP BY servicofechado.formPagID").toString();
        return vendas;
    }

    public String somaServicosDinheiro(int servicoInicio, int servicoFim)
    {
        String servicos = "SELECT SUM(valor) as totalServicos ";
        servicos = (new StringBuilder(String.valueOf(servicos))).append("FROM servicofechado ").toString();
        servicos = (new StringBuilder(String.valueOf(servicos))).append("WHERE servicofechadoID BETWEEN '").append(servicoInicio).append("' AND '").append(servicoFim).append("' ").toString();
        servicos = (new StringBuilder(String.valueOf(servicos))).append("AND usuario = '").append(usuario.usuarioID).append("' AND formPagID = '1'").toString();
        return servicos;
    }

    public String ultimaServicoPorUsuario()
    {
        return (new StringBuilder("SELECT * FROM servicofechado WHERE usuario = '")).append(usuario.usuarioID).append("' ORDER BY servicofechadoID DESC LIMIT 1").toString();
    }

    public String ultimoServico()
    {
        return "SELECT * FROM servicofechado ORDER BY servicofechadoID DESC LIMIT 1";
    }

    public int servicofechadoID;
    public Servico servico;
    public float valor;
    public int formPagID;
    public Usuario usuario;
}
