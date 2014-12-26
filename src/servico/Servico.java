// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Servico.java

package servico;

import cadastro.*;
import pdv.FormaPagamento;

public class Servico
{

    public Servico()
    {
        cliente = new Cliente();
        empresa = new Empresa();
        formaPagamento = new FormaPagamento();
        usuario = new Usuario();
    }

    public String pesquisaServico()
    {
        String pesquisaEmp = "SELECT cliente.*, servico.* ";
        pesquisaEmp = pesquisaEmp + "FROM servico INNER JOIN cliente ON cliente.clienteID = servico.clienteID ";
        pesquisaEmp = pesquisaEmp + "WHERE servico.servicoID = '" + servicoID + "'";
        return pesquisaEmp;
    }

    public String pesquisaServicoEmpresa()
    {
        String pesquisaEmp = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, servico.* ";
        pesquisaEmp = pesquisaEmp + "FROM servico INNER JOIN cliente ON cliente.clienteID = servico.clienteID ";
        pesquisaEmp = pesquisaEmp + "WHERE servico.servicoID = '" + servicoID + "' AND servico.empresaID = '" + empresa.empresaID + "'";
        return pesquisaEmp;
    }

    public String listaServicos()
    {
        return "SELECT * FROM servico ORDER BY servicoID DESC";
    }

    public String listaServicosPendentes()
    {
        String listaServ = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, servico.* ";
        listaServ = listaServ + "FROM servico INNER JOIN cliente ON cliente.clienteID = servico.clienteID ";
        listaServ = listaServ + "WHERE servico.status = 'M' AND servico.empresaID = '" + empresa.empresaID + "' ORDER BY servico.servicoID DESC";
        return listaServ;
    }

    public String pesquisaPorCliente(String keyword)
    {
        String listaServ = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, servico.* ";
        listaServ = listaServ + "FROM servico INNER JOIN cliente ON cliente.clienteID = servico.clienteID ";
        listaServ = listaServ + "WHERE servico.status = 'M' AND servico.empresaID = '" + empresa.empresaID + "' ";
        listaServ = listaServ + "AND cliente.clienteNomeFantasia LIKE '%" + keyword + "%' ORDER BY servico.servicoID DESC";
        return listaServ;
    }

    public String servicosFechados(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = busca + "cliente.clienteID, cliente.clienteNomeFantasia, ";
        busca = busca + "servico.* FROM servico ";
        busca = busca + "INNER JOIN formapagamento ON formapagamento.formID = servico.formPagID ";
        busca = busca + "LEFT JOIN cliente ON cliente.clienteID = servico.clienteID ";
        busca = busca + "WHERE servico.dataFim BETWEEN '" + dataInicial + "' AND '" + dataFinal + " 23:59:59" + "' ";
        busca = busca + "AND servico.status = 'F' AND servico.empresaID = '" + empresa.empresaID + "' ";
        busca = busca + "ORDER BY dataFim DESC";
        return busca;
    }

    public String somaServicos(int servicoInicio, int servicoFim)
    {
        String servicos = "SELECT SUM(valor) as totalServicos ";
        servicos = servicos + "FROM servico ";
        servicos = servicos + "WHERE servicoID BETWEEN '" + servicoInicio + "' AND '" + servicoFim + "' ";
        servicos = servicos + "AND usuario = '" + usuario.usuarioID + "' AND status = 'F'";
        return servicos;
    }

    public String somaServicosPorData(String dataFinal)
    {
        String servicos = "SELECT SUM(valor) as totalServicos ";
        servicos = servicos + "FROM servico ";
        servicos = servicos + "WHERE dataFim LIKE '%" + dataFinal + "%' ";
        servicos = servicos + "AND usuario = '" + usuario.usuarioID + "' AND status = 'F'";
        return servicos;
    }

    public String somaServicoFormaPgto(int servicoInicio, int servicoFim)
    {
        String vendas = "SELECT formapagamento.formID, formapagamento.descricao, ";
        vendas = vendas + "SUM(servico.valor) as totalServicos, servico.formPagID ";
        vendas = vendas + "FROM servico ";
        vendas = vendas + "INNER JOIN formapagamento ON formapagamento.formID = servico.formPagID ";
        vendas = vendas + "WHERE servico.servicoID BETWEEN '" + servicoInicio + "' AND '" + servicoFim + "' ";
        vendas = vendas + "AND servico.usuario = '" + usuario.usuarioID + "' AND servico.status = 'F' ";
        vendas = vendas + "GROUP BY servico.formPagID";
        return vendas;
    }

    public String somaServicoFormaPgtoPorData(String dataFinal)
    {
        String vendas = "SELECT formapagamento.formID, formapagamento.descricao, ";
        vendas = vendas + "SUM(servico.valor) as totalServicos, servico.formPagID ";
        vendas = vendas + "FROM servico ";
        vendas = vendas + "INNER JOIN formapagamento ON formapagamento.formID = servico.formPagID ";
        vendas = vendas + "WHERE servico.dataFim LIKE '%" + dataFinal + "%' ";
        vendas = vendas + "AND servico.usuario = '" + usuario.usuarioID + "' AND servico.status = 'F' ";
        vendas = vendas + "GROUP BY servico.formPagID";
        return vendas;
    }

    public String ultimaServicoPorUsuario()
    {
        return "SELECT * FROM servico WHERE usuario = '" + usuario.usuarioID + "' AND status = 'F' ORDER BY servicoID DESC LIMIT 1";
    }

    public String ultimoServico()
    {
        return "SELECT * FROM servico ORDER BY servicoID DESC LIMIT 1";
    }

    public String cadastraServico()
    {
        String salvaServ = "INSERT INTO servico ";
        salvaServ = salvaServ + "(clienteID, empresaID, descricao, dataInicio, valor, usuario) ";
        salvaServ = salvaServ + "VALUES ";
        salvaServ = salvaServ + "('" + cliente.clienteID + "', '" + empresa.empresaID + "', '" + descricao + "', '" + dataInicio + "', '" + valor + "', '" + usuario.usuarioID + "')";
        return salvaServ;
    }

    public String completaServico()
    {
        String completa = "UPDATE servico ";
        completa = completa + "SET formPagID = '" + formaPagamento.formPagID + "', vezes = '" + vezes + "', ";
        completa = completa + "valor = '" + valor + "', entrada = '" + entrada + "', troco = '" + troco + "', desconto = '" + desconto + "', status = 'F' ";
        completa = completa + "WHERE servicoID = '" + servicoID + "'";
        return completa;
    }

    public String atualizaServico()
    {
        String alterServ = "UPDATE servico ";
        alterServ = alterServ + "SET descricao = '" + descricao + "' ";
        alterServ = alterServ + "WHERE servicoID = '" + servicoID + "'";
        return alterServ;
    }

    public String atualizaValorServico()
    {
        String alterServ = "UPDATE servico ";
        alterServ = alterServ + "SET valor = '" + valor + "' ";
        alterServ = alterServ + "WHERE servicoID = '" + servicoID + "'";
        return alterServ;
    }

    public String visualizado()
    {
        return "UPDATE servico SET visualizacao = 'S' WHERE servicoID = '" + servicoID + "'";
    }

    public String naoVisualizado()
    {
        return "UPDATE servico SET visualizacao = 'N' WHERE servicoID = '" + servicoID + "'";
    }

    public String excluiServico()
    {
        return "DELETE FROM servico WHERE servicoID = '" + servicoID + "'";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Servi\347o Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Servi\347o Atualizado com Sucesso!";

        case 3: // '\003'
            return "Servi\347o Excluido com Sucesso!";

        case 4: // '\004'
            return "Confirmado a Visualiza\347\343o";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int servicoID;
    public Cliente cliente;
    public Empresa empresa;
    public String descricao;
    public FormaPagamento formaPagamento;
    public float entrada;
    public float troco;
    public int vezes;
    public float desconto;
    public String dataInicio;
    public String dataFim;
    public float valor;
    public Usuario usuario;
}
