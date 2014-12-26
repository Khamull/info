// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Transferencias.java

package financeiro;

import cadastro.Empresa;

public class Transferencias
{

    public Transferencias()
    {
        empresa = new Empresa();
    }

    public String ultimaTransferencia()
    {
        return "SELECT * FROM transferencias ORDER BY transferenciaID DESC LIMIT 1";
    }

    public String transferenciaPorID()
    {
        String pesquisaTransf = "SELECT empresa.empresaID, empresa.unidade, transferencias.* ";
        pesquisaTransf = (new StringBuilder(String.valueOf(pesquisaTransf))).append("FROM transferencias INNER JOIN empresa ON empresa.empresaID = transferencias.empresaID ").toString();
        pesquisaTransf = (new StringBuilder(String.valueOf(pesquisaTransf))).append("WHERE transferencias.transferenciaID = '").append(transferenciaID).append("'").toString();
        return pesquisaTransf;
    }

    public String cadastraTransferencia()
    {
        String cadastro = "INSERT INTO transferencias ";
        cadastro = (new StringBuilder(String.valueOf(cadastro))).append("(bancoDe, bancoPara, valor, observacoes, empresaID) ").toString();
        cadastro = (new StringBuilder(String.valueOf(cadastro))).append("VALUES ('").append(bancoDe).append("', '").append(bancoPara).append("', '").append(valor).append("', '").append(observacoes).append("', '").append(empresa.empresaID).append("')").toString();
        return cadastro;
    }

    public String listaTranferenciasPorData(String dataInicio, String dataFim)
    {
        String busca = "SELECT * FROM transferencias ";
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append(" 23:59:59").append("'").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY data ASC").toString();
        return busca;
    }

    public int transferenciaID;
    public int bancoDe;
    public int bancoPara;
    public float valor;
    public String observacoes;
    public String data;
    public Empresa empresa;
}
