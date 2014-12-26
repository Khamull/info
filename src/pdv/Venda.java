// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Venda.java

package pdv;

import cadastro.*;

// Referenced classes of package pdv:
//            FormaPagamento

public class Venda
{

    public Venda()
    {
        cliente = new Cliente();
        formPag = new FormaPagamento();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String vendaAberta()
    {
        return (new StringBuilder("SELECT * FROM venda WHERE status = '1' AND usuario = '")).append(usuario.login).append("'").toString();
    }

    public String clienteVendaID()
    {
        return (new StringBuilder("SELECT cliente.* , venda.* FROM venda LEFT JOIN cliente ON cliente.clienteID = venda.clienteID WHERE venda.vendaID = '")).append(vendaID).append("'").toString();
    }

    public String vendasFechadas(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cliente.clienteID, cliente.clienteNomeFantasia, ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("venda.* FROM venda ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE venda.data BETWEEN '").append(dataInicial).append("' AND '").append(dataFinal).append(" 23:59:59").append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND venda.status = '2' AND venda.empresaID = '").append(empresa.empresaID).append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY data DESC").toString();
        return busca;
    }

    public String listaVendasRelatorio(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cliente.clienteID, cliente.clienteNomeFantasia, ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("venda.* FROM venda ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE venda.data BETWEEN '").append(dataInicial).append("' AND '").append(dataFinal).append(" 23:59:59").append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND venda.status = '2' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY data ASC").toString();
        return busca;
    }

    public String listaVendasRelatorioTotal(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cliente.clienteID, cliente.clienteNomeFantasia, ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("venda.vendaID, venda.formPagID, venda.clienteID, SUM(valor) AS totalVenda FROM venda ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE venda.data BETWEEN '").append(dataInicial).append("' AND '").append(dataFinal).append(" 23:59:59").append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND venda.status = '2' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY data ASC").toString();
        return busca;
    }

    public String listaVendasRelatorioPorFormaPagmento(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cliente.clienteID, cliente.clienteNomeFantasia, ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("venda.* FROM venda ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE venda.data BETWEEN '").append(dataInicial).append("' AND '").append(dataFinal).append(" 23:59:59").append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND venda.status = '2' AND venda.formPagID = '").append(formPag.formPagID).append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY data ASC").toString();
        return busca;
    }

    public String listaVendasRelatorioPorFormaPagmentoTotal(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cliente.clienteID, cliente.clienteNomeFantasia, ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("venda.vendaID, venda.formPagID, venda.clienteID, SUM(valor) AS totalVenda FROM venda ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE venda.data BETWEEN '").append(dataInicial).append("' AND '").append(dataFinal).append(" 23:59:59").append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND venda.status = '2' AND venda.formPagID = '").append(formPag.formPagID).append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY data ASC").toString();
        return busca;
    }

    public String dadosVenda()
    {
        return (new StringBuilder("SELECT * FROM venda WHERE vendaID = '")).append(vendaID).append("'").toString();
    }

    public String ultimaVendaPorUsuario()
    {
        return (new StringBuilder("SELECT * FROM venda WHERE usuario = '")).append(usuario.login).append("' AND status = '2' ORDER BY vendaID DESC LIMIT 1").toString();
    }

    public String ultimaVenda()
    {
        return "SELECT * FROM venda ORDER BY vendaID DESC LIMIT 1";
    }

    public String somaVendas(int vendaInicio, int vendaFim)
    {
        String vendas = "SELECT SUM(valor) as totalVendas ";
        vendas = (new StringBuilder(String.valueOf(vendas))).append("FROM venda ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("WHERE vendaID BETWEEN '").append(vendaInicio).append("' AND '").append(vendaFim).append("' ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("AND usuario = '").append(usuario.login).append("'").toString();
        return vendas;
    }

    public String somaVendasDinheiro(int vendaInicio, int vendaFim)
    {
        String vendas = "SELECT SUM(valor) as totalVendas ";
        vendas = (new StringBuilder(String.valueOf(vendas))).append("FROM venda ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("WHERE vendaID BETWEEN '").append(vendaInicio).append("' AND '").append(vendaFim).append("' ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("AND usuario = '").append(usuario.login).append("' AND formPagID = '1'").toString();
        return vendas;
    }

    public String somaVendaFormaPgto(int vendaInicio, int vendaFim)
    {
        String vendas = "SELECT formapagamento.formID, formapagamento.descricao, ";
        vendas = (new StringBuilder(String.valueOf(vendas))).append("SUM(venda.valor) as totalVendas, venda.formPagID ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("FROM venda ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("WHERE venda.vendaID BETWEEN '").append(vendaInicio).append("' AND '").append(vendaFim).append("' ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("AND venda.usuario = '").append(usuario.login).append("' ").toString();
        vendas = (new StringBuilder(String.valueOf(vendas))).append("GROUP BY venda.formPagID").toString();
        return vendas;
    }

    public String cadastraVenda()
    {
        String insere = "INSERT INTO venda (clienteID, formPagID, vezes, valor, entrada, troco, desconto, notaFiscal, usuario, empresaID) ";
        insere = (new StringBuilder(String.valueOf(insere))).append("VALUES ('0', '0', '0', '0', '0', '0', '0', '0', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return insere;
    }

    public String completaVenda()
    {
        String completa = "UPDATE venda ";
        completa = (new StringBuilder(String.valueOf(completa))).append("SET clienteID = '").append(cliente.clienteID).append("', formPagID = '").append(formPag.formPagID).append("', vezes = '").append(vezes).append("', ").toString();
        completa = (new StringBuilder(String.valueOf(completa))).append("valor = '").append(valor).append("', entrada = '").append(entrada).append("', troco = '").append(troco).append("', desconto = '").append(desconto).append("', status = '2' ").toString();
        completa = (new StringBuilder(String.valueOf(completa))).append("WHERE vendaID = '").append(vendaID).append("'").toString();
        return completa;
    }

    public String finalizaVenda()
    {
        return (new StringBuilder("UPDATE venda SET status = '2' WHERE vendaID = '")).append(vendaID).append("'").toString();
    }

    public String cancelaVenda()
    {
        return (new StringBuilder("DELETE FROM venda WHERE vendaID = '")).append(vendaID).append("'").toString();
    }

    public int vendaID;
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
