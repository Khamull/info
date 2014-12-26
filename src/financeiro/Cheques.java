// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cheques.java

package financeiro;

import cadastro.Cliente;

// Referenced classes of package financeiro:
//            Receber

public class Cheques
{

    public Cheques()
    {
        receber = new Receber();
        cliente = new Cliente();
    }

    public String cadastraCheque()
    {
        String cadastra = "INSERT INTO cheques (receberID, clienteID, valorCheque, numeroCheque, vencimentoCheque, observacoes) ";
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("VALUES ('").append(receber.receberID).append("', '").append(cliente.clienteID).append("', '").append(valor).append("', '").append(numero).append("', '").append(vencimento).append("', '").append(observacoes).append("')").toString();
        return cadastra;
    }

    public String listaCheques()
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, cliente.clienteTelefone, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cheques.* ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("FROM cheques ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY cheques.chequeID DESC").toString();
        return busca;
    }

    public String buscaCheques(String numeroCheque)
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, cliente.clienteTelefone, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cheques.* ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("FROM cheques ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE numeroCheque = '").append(numeroCheque).append("'").toString();
        return busca;
    }

    public String chequePorReceberID()
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, cliente.clienteTelefone, ";
        busca = (new StringBuilder(String.valueOf(busca))).append("cheques.* ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("FROM cheques ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE cheques.receberID = '").append(receber.receberID).append("'").toString();
        return busca;
    }

    public String excluiCheque()
    {
        return (new StringBuilder("DELETE FROM cheques WHERE chequeID = '")).append(chequeID).append("'").toString();
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Cheque Devolvido ao Contas a Receber com Sucesso!";

        case 2: // '\002'
            return "Registro Excluido com Sucesso";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int chequeID;
    public Receber receber;
    public Cliente cliente;
    public float valor;
    public String numero;
    public String vencimento;
    public String observacoes;
}
