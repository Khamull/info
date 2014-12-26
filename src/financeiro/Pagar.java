// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pagar.java

package financeiro;

import cadastro.Empresa;
import pdv.FormaPagamento;

// Referenced classes of package financeiro:
//            ContasPagar

public class Pagar
{

    public Pagar()
    {
        conta = new ContasPagar();
        forma = new FormaPagamento();
        empresa = new Empresa();
    }

    public String cadastraPagar()
    {
        String inserePagar = "INSERT INTO pagar ";
        inserePagar = (new StringBuilder(String.valueOf(inserePagar))).append("(contapagarID, formID, valor, vencimento, parcela, de, status, empresaID) ").toString();
        inserePagar = (new StringBuilder(String.valueOf(inserePagar))).append("VALUES ('").append(conta.contaID).append("', '").append(forma.formPagID).append("', '").append(valor).append("', '").append(vencimento).append("', '").append(parcela).append("', '").append(de).append("', '").append(status).append("', '").append(empresa.empresaID).append("')").toString();
        return inserePagar;
    }

    public String pesquisaConta(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("contapagar.contapagarID, contapagar.favorecido, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("pagar.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM pagar ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'D' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND pagar.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC").toString();
        return pesquisa;
    }

    public String pesquisaContaPorForma(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("contapagar.contapagarID, contapagar.favorecido, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("pagar.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM pagar ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'D' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND pagar.formID = '").append(forma.formPagID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND pagar.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC").toString();
        return pesquisa;
    }

    public String contaPaga(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("contapagar.contapagarID, contapagar.favorecido, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("pagar.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM pagar ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'P' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND pagar.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC").toString();
        return pesquisa;
    }

    public String contaPagasPorForma(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("contapagar.contapagarID, contapagar.favorecido, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("pagar.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM pagar ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'P' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND pagar.formID = '").append(forma.formPagID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND pagar.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC").toString();
        return pesquisa;
    }

    public String pagarPorID()
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("contapagar.contapagarID, contapagar.favorecido, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("pagar.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM pagar ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE pagarID = '").append(pagarID).append("'").toString();
        return pesquisa;
    }

    public String detalhePagamento()
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("contapagar.contapagarID, contapagar.favorecido, contapagar.valor as total, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("lancamentos.valor as pago, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, lancamentos.data, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("pagar.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM pagar ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN lancamentos ON lancamentos.pagarID = pagar.pagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE pagar.pagarID = '").append(pagarID).append("' ").toString();
        return pesquisa;
    }

    public String totalPagar(String dataInicio, String dataFim)
    {
        String total = "SELECT SUM(valor) as faltaPagar FROM pagar ";
        total = (new StringBuilder(String.valueOf(total))).append("WHERE status = 'D' AND vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("'").toString();
        return total;
    }

    public String pesquisaContaPorEmpresa(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("contapagar.contapagarID, contapagar.favorecido, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("pagar.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM pagar ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE status = 'D' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND pagar.vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND pagar.empresaID = '").append(empresa.empresaID).append("'").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC").toString();
        return pesquisa;
    }

    public String totalPagarPorEmpresa(String dataInicio, String dataFim)
    {
        String total = "SELECT SUM(valor) as faltaPagar FROM pagar ";
        total = (new StringBuilder(String.valueOf(total))).append("WHERE status = 'D' AND vencimento BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("' AND empresaID = '").append(empresa.empresaID).append("'").toString();
        return total;
    }

    public String alteraPagar()
    {
        return (new StringBuilder("UPDATE pagar SET valor = '")).append(valor).append("', vencimento = '").append(vencimento).append("' WHERE pagarID = '").append(pagarID).append("'").toString();
    }

    public String alteraStatus()
    {
        return (new StringBuilder("UPDATE pagar SET status = 'P' WHERE pagarID = '")).append(pagarID).append("'").toString();
    }

    public String excluiPagar()
    {
        return (new StringBuilder("DELETE FROM pagar WHERE pagarID = '")).append(pagarID).append("'").toString();
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Valor Pago com Sucesso!";

        case 2: // '\002'
            return "Conta a Pagar Alterada com Sucesso!";

        case 3: // '\003'
            return "Conta Cadastrada com Sucesso!";

        case 4: // '\004'
            return "Conta a Pagar Excluida com Sucesso!";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int pagarID;
    public ContasPagar conta;
    public FormaPagamento forma;
    public float valor;
    public String vencimento;
    public int parcela;
    public int de;
    public String status;
    public Empresa empresa;
}
