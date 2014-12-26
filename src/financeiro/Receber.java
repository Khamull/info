// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Receber.java

package financeiro;

import cadastro.Cliente;
import cadastro.Empresa;
import pdv.FormaPagamento;
import pdv.Venda;
import servico.Servico;

public class Receber
{

    public Receber()
    {
        venda = new Venda();
        servico = new Servico();
        cliente = new Cliente();
        forma = new FormaPagamento();
        empresa = new Empresa();
    }

    public String salvarReceber()
    {
        String salvaReceber = "INSERT INTO receber (vendaID, formID, clienteID, valor, vencimento, parcela, de, status, servico, empresaID) ";
        salvaReceber = (new StringBuilder(String.valueOf(salvaReceber))).append("VALUES ('").append(venda.vendaID).append("', '").append(forma.formPagID).append("', '").append(cliente.clienteID).append("', '").append(valor).append("', '").append(vencimento).append("', ").toString();
        salvaReceber = (new StringBuilder(String.valueOf(salvaReceber))).append("'").append(parcela).append("', '").append(de).append("', 'D', 'N', '").append(empresa.empresaID).append("')").toString();
        return salvaReceber;
    }

    public String salvarReceberServico()
    {
        String salvaReceber = "INSERT INTO receber (vendaID, formID, clienteID, valor, vencimento, parcela, de, status, servico, empresaID) ";
        salvaReceber = (new StringBuilder(String.valueOf(salvaReceber))).append("VALUES ('").append(servico.servicoID).append("', '").append(forma.formPagID).append("', '").append(cliente.clienteID).append("', '").append(valor).append("', '").append(vencimento).append("', ").toString();
        salvaReceber = (new StringBuilder(String.valueOf(salvaReceber))).append("'").append(parcela).append("', '").append(de).append("', 'D', 'S', '").append(empresa.empresaID).append("')").toString();
        return salvaReceber;
    }

    public String cadastraEntrada(float entrada)
    {
        String salvaReceber = "INSERT INTO receber (vendaID, formID, clienteID, valor, vencimento, parcela, de, status, servico, empresaID) ";
        salvaReceber = (new StringBuilder(String.valueOf(salvaReceber))).append("VALUES ('").append(venda.vendaID).append("', '").append(forma.formPagID).append("', '").append(cliente.clienteID).append("', '").append(entrada).append("', '").append(vencimento).append("', ").toString();
        salvaReceber = (new StringBuilder(String.valueOf(salvaReceber))).append("'1', '1', 'P', 'N', '").append(empresa.empresaID).append("')").toString();
        return salvaReceber;
    }

    public String cadastraEntradaServico(float entrada)
    {
        String salvaReceber = "INSERT INTO receber (vendaID, formID, clienteID, valor, vencimento, parcela, de, status, servico, empresaID) ";
        salvaReceber = (new StringBuilder(String.valueOf(salvaReceber))).append("VALUES ('").append(servico.servicoID).append("', '").append(forma.formPagID).append("', '").append(cliente.clienteID).append("', '").append(entrada).append("', '").append(vencimento).append("', ").toString();
        salvaReceber = (new StringBuilder(String.valueOf(salvaReceber))).append("'1', '1', 'P', 'S', '").append(empresa.empresaID).append("')").toString();
        return salvaReceber;
    }

    public String ultimoReceberID()
    {
        return (new StringBuilder("SELECT receberID FROM receber WHERE vendaID = '")).append(venda.vendaID).append("' ORDER BY receberID DESC LIMIT 1").toString();
    }

    public String ultimoReceberIDServico()
    {
        return (new StringBuilder("SELECT receberID FROM receber WHERE vendaID = '")).append(servico.servicoID).append("' ORDER BY receberID DESC LIMIT 1").toString();
    }

    public String receberPorID()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE receberID = '").append(receberID).append("'").toString();
        return pesquisa;
    }

    public String pesquisaConta(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'D' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String pesquisaContaFC(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'D' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.formID = '").append(forma.formPagID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.clienteID = '").append(cliente.clienteID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String pesquisaContaC(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'D' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.clienteID = '").append(cliente.clienteID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String pesquisaContaF(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'D' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.formID = '").append(forma.formPagID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String contaRecebida(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'P' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String contaRecebidaFC(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'P' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.formID = '").append(forma.formPagID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.clienteID = '").append(cliente.clienteID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String contaRecebidaC(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'P' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.clienteID = '").append(cliente.clienteID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String contaRecebidaF(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'P' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.formID = '").append(forma.formPagID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String detalheReceber()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("lancamentos.receberID, lancamentos.valor AS recebido, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("venda.vendaID , venda.valor AS total, venda.data, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN venda ON venda.vendaID = receber.vendaID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN lancamentos ON lancamentos.receberID = receber.receberID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE receber.receberID = '").append(receberID).append("'").toString();
        return pesquisa;
    }

    public String detalheReceberServico()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("lancamentos.receberID, lancamentos.valor AS recebido, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("servico.servicoID , servico.valor AS total, servico.dataFim, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN servico ON servico.servicoID = receber.vendaID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN lancamentos ON lancamentos.receberID = receber.receberID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE receber.receberID = '").append(receberID).append("'").toString();
        return pesquisa;
    }

    public String detalheReceberChequeVoltou()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("lancamentos.receberID, lancamentos.valor AS recebido, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("cheques.receberID, cheques.numeroCheque, cheques.valorCheque as valor, cheques.observacoes, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.valor as total, receber.vencimento, receber.parcela, receber.de ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM lancamentos ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN cheques ON cheques.receberID = lancamentos.receberID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = lancamentos.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN receber ON cheques.receberID = receber.receberID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE lancamentos.receberID = '").append(receberID).append("' AND lancamentos.tipo = 'C'").toString();
        return pesquisa;
    }

    public String detalheReceberCheque()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("lancamentos.receberID, lancamentos.valor AS recebido, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("cheques.receberID, cheques.numeroCheque, cheques.valorCheque as valor, cheques.observacoes, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.valor as total, receber.vencimento, receber.parcela, receber.de ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM lancamentos ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN cheques ON cheques.receberID = lancamentos.receberID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = lancamentos.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN receber ON cheques.receberID = receber.receberID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE lancamentos.receberID = '").append(receberID).append("' AND lancamentos.tipo = 'R'").toString();
        return pesquisa;
    }

    public String pesquisaContaCliente()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE receber.status = 'D' AND receber.formID = '7' AND receber.clienteID = '").append(cliente.clienteID).append("'").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC").toString();
        return pesquisa;
    }

    public String totalReceber(String dataInicio, String dataFim)
    {
        String total = "SELECT SUM(valor) as faltaPagar FROM receber ";
        total = (new StringBuilder(String.valueOf(total))).append("WHERE status = 'D' AND vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("'").toString();
        return total;
    }

    public String totalReceberVale()
    {
        String total = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, SUM(valor) as faltaPagar ";
        total = (new StringBuilder(String.valueOf(total))).append("FROM receber INNER JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        total = (new StringBuilder(String.valueOf(total))).append("WHERE receber.status = 'D' AND receber.formID = '7' AND receber.clienteID = '").append(cliente.clienteID).append("'").toString();
        return total;
    }

    public String pesquisaContaPorEmpresa(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("formapagamento.formID, formapagamento.descricao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("receber.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM receber ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = receber.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'D' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND receber.empresaID = '").append(empresa.empresaID).append("'").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY receber.vencimento ASC, receber.receberID  ASC").toString();
        return pesquisa;
    }

    public String totalReceberPorEmpresa(String dataInicio, String dataFim)
    {
        String total = "SELECT SUM(valor) as faltaPagar FROM receber ";
        total = (new StringBuilder(String.valueOf(total))).append("WHERE status = 'D' AND vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' AND empresaID = '").append(empresa.empresaID).append("'").toString();
        return total;
    }

    public String alteraReceber()
    {
        return (new StringBuilder("UPDATE receber SET valor = '")).append(valor).append("', vencimento = '").append(vencimento).append("' WHERE receberID = '").append(receberID).append("'").toString();
    }

    public String alteraStatus()
    {
        return (new StringBuilder("UPDATE receber SET status = 'P' WHERE receberID = '")).append(receberID).append("'").toString();
    }

    public String alteraFormaPgto()
    {
        return (new StringBuilder("UPDATE receber SET formID = '")).append(forma.formPagID).append("' WHERE receberID = '").append(receberID).append("'").toString();
    }

    public String excluiContaReceber()
    {
        return (new StringBuilder("DELETE FROM receber WHERE receberID = '")).append(receberID).append("'").toString();
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Valor Recebido com Sucesso!";

        case 2: // '\002'
            return "Conta a Receber Alterada com Sucesso!";

        case 3: // '\003'
            return "Conta a Receber Excluida com Sucesso!";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int receberID;
    public Venda venda;
    public Servico servico;
    public Cliente cliente;
    public FormaPagamento forma;
    public float valor;
    public String vencimento;
    public int parcela;
    public int de;
    public String status;
    public String tipoServico;
    public Empresa empresa;
}
