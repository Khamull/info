// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Orcamento.java

package pdv;

import cadastro.*;

// Referenced classes of package pdv:
//            FormaPagamento

public class Orcamento
{

    public Orcamento()
    {
        cliente = new Cliente();
        formPag = new FormaPagamento();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String orcamentoAberta()
    {
        return (new StringBuilder("SELECT * FROM orcamento WHERE status = '1' AND usuario = '")).append(usuario.login).append("'").toString();
    }

    public String clienteorcamentoID()
    {
        return (new StringBuilder("SELECT cliente.* , orcamento.* FROM orcamento LEFT JOIN cliente ON cliente.clienteID = orcamento.clienteID WHERE orcamento.orcamentoID = '")).append(orcamentoID).append("'").toString();
    }

    public String orcamentosFechados(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cliente.clienteID, cliente.clienteNomeFantasia, ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("orcamento.* FROM orcamento ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN formapagamento ON formapagamento.formID = orcamento.formPagID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("LEFT JOIN cliente ON cliente.clienteID = orcamento.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE orcamento.data BETWEEN '").append(dataInicial).append("' AND '").append(dataFinal).append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND orcamento.status = '2' AND orcamento.empresaID = '").append(empresa.empresaID).append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY data DESC").toString();
        return busca;
    }

    public String dadosOrcamento()
    {
        return (new StringBuilder("SELECT * FROM orcamento WHERE orcamentoID = '")).append(orcamentoID).append("'").toString();
    }

    public String ultimoOrcamentoPorUsuario()
    {
        return (new StringBuilder("SELECT * FROM orcamento WHERE usuario = '")).append(usuario.login).append("' AND status = '2' ORDER BY orcamentoID DESC LIMIT 1").toString();
    }

    public String ultimoOrcamento()
    {
        return "SELECT * FROM orcamento ORDER BY orcamentoID DESC LIMIT 1";
    }

    public String somaOrcamentos(int orcamentoInicio, int orcamentoFim)
    {
        String orcamentos = "SELECT SUM(valor) as totalorcamentos ";
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("FROM orcamento ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("WHERE orcamentoID BETWEEN '").append(orcamentoInicio).append("' AND '").append(orcamentoFim).append("' ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("AND usuario = '").append(usuario.login).append("'").toString();
        return orcamentos;
    }

    public String somaOrcamentosDinheiro(int orcamentoInicio, int orcamentoFim)
    {
        String orcamentos = "SELECT SUM(valor) as totalOrcamentos ";
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("FROM orcamento ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("WHERE orcamentoID BETWEEN '").append(orcamentoInicio).append("' AND '").append(orcamentoFim).append("' ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("AND usuario = '").append(usuario.login).append("' AND formPagID = '1'").toString();
        return orcamentos;
    }

    public String somaOrcamentoFormaPgto(int orcamentoInicio, int orcamentoFim)
    {
        String orcamentos = "SELECT formapagamento.formID, formapagamento.descricao, ";
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("SUM(orcamento.valor) as totalOrcamentos, orcamento.formPagID ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("FROM orcamento ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("INNER JOIN formapagamento ON formapagamento.formID = orcamento.formPagID ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("WHERE orcamento.orcamentoID BETWEEN '").append(orcamentoInicio).append("' AND '").append(orcamentoFim).append("' ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("AND orcamento.usuario = '").append(usuario.login).append("' ").toString();
        orcamentos = (new StringBuilder(String.valueOf(orcamentos))).append("GROUP BY orcamento.formPagID").toString();
        return orcamentos;
    }

    public String cadastraOrcamento()
    {
        String insere = "INSERT INTO orcamento (clienteID, formPagID, vezes, valor, entrada, troco, desconto, notaFiscal, usuario, empresaID) ";
        insere = (new StringBuilder(String.valueOf(insere))).append("VALUES ('0', '0', '0', '0', '0', '0', '0', '0', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return insere;
    }

    public String completaOrcamento()
    {
        String completa = "UPDATE orcamento ";
        completa = (new StringBuilder(String.valueOf(completa))).append("SET clienteID = '").append(cliente.clienteID).append("', formPagID = '").append(formPag.formPagID).append("', vezes = '").append(vezes).append("', ").toString();
        completa = (new StringBuilder(String.valueOf(completa))).append("valor = '").append(valor).append("', entrada = '").append(entrada).append("', troco = '").append(troco).append("', desconto = '").append(desconto).append("', status = '2' ").toString();
        completa = (new StringBuilder(String.valueOf(completa))).append("WHERE orcamentoID = '").append(orcamentoID).append("'").toString();
        return completa;
    }

    public String finalizaOrcamento()
    {
        return (new StringBuilder("UPDATE orcamento SET status = '2' WHERE orcamentoID = '")).append(orcamentoID).append("'").toString();
    }

    public String cancelaOrcamento()
    {
        return (new StringBuilder("DELETE FROM orcamento WHERE orcamentoID = '")).append(orcamentoID).append("'").toString();
    }

    public int orcamentoID;
    public Cliente cliente;
    public FormaPagamento formPag;
    public int vezes;
    public float valor;
    public float entrada;
    public float troco;
    public float desconto;
    public String notaFiscal;
    public Usuario usuario;
    public String status;
    public Empresa empresa;
}
