// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Lancamentos.java

package financeiro;

import cadastro.Empresa;
import cadastro.Usuario;
import pdv.FormaPagamento;
import pdv.Venda;

// Referenced classes of package financeiro:
//            Receber, Pagar, Transferencias, ContasPagar, 
//            LivroCaixa

public class Lancamentos
{

    public Lancamentos()
    {
        receber = new Receber();
        pagar = new Pagar();
        venda = new Venda();
        transferencia = new Transferencias();
        contaPagar = new ContasPagar();
        livro = new LivroCaixa();
        formaPag = new FormaPagamento();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String insereEntrada()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("(receberID, vendaID, livroID, formID, valor, tipo, usuario, empresaID) ").toString();
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("VALUES ('").append(receber.receberID).append("', '").append(venda.vendaID).append("', '1', '1', '").append(valor).append("', 'R', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return salvaValor;
    }

    public String insereEntradaServico()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("(receberID, vendaID, livroID, formID, valor, tipo, usuario, empresaID) ").toString();
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("VALUES ('").append(receber.receberID).append("', '").append(venda.vendaID).append("', '1', '1', '").append(valor).append("', 'S', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return salvaValor;
    }

    public String pagaContaReceber()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("(receberID, vendaID, livroID, formID, valor, desconto, acrescimo, observacao, tipo, usuario, empresaID) ").toString();
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("VALUES ('").append(receber.receberID).append("', '").append(venda.vendaID).append("', '").append(livro.livroID).append("', '").append(formaPag.formPagID).append("', ").toString();
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("'").append(valor).append("', '").append(desconto).append("', '").append(acrescimo).append("', '").append(observacao).append("', 'R', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return salvaValor;
    }

    public String pagaContaReceberServico()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("(receberID, vendaID, livroID, formID, valor, desconto, acrescimo, observacao, tipo, usuario, empresaID) ").toString();
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("VALUES ('").append(receber.receberID).append("', '").append(venda.vendaID).append("', '").append(livro.livroID).append("', '").append(formaPag.formPagID).append("', ").toString();
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("'").append(valor).append("', '").append(desconto).append("', '").append(acrescimo).append("', '").append(observacao).append("', 'S', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return salvaValor;
    }

    public String pagaContaPagar()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("(pagarID, contaPagarID, livroID, formID, valor, desconto, acrescimo, favorecido, observacao, tipo, usuario, empresaID) ").toString();
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("VALUES ('").append(pagar.pagarID).append("', '").append(contaPagar.contaID).append("', '").append(livro.livroID).append("', '").append(formaPag.formPagID).append("', '").append(valor).append("', ").toString();
        salvaValor = (new StringBuilder(String.valueOf(salvaValor))).append("'").append(desconto).append("', '").append(acrescimo).append("', '").append(favorecido).append("', '").append(observacao).append("', 'P', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return salvaValor;
    }

    public String transfere()
    {
        String transf = "INSERT INTO lancamentos (transferenciaID, livroID, valor, formID, tipo, usuario, empresaID) ";
        transf = (new StringBuilder(String.valueOf(transf))).append("VALUES ('").append(transferencia.transferenciaID).append("', '").append(livro.livroID).append("', '").append(valor).append("', '1', 'T', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return transf;
    }

    public String deposito()
    {
        String transf = "INSERT INTO lancamentos (transferenciaID, livroID, valor, formID, tipo, usuario, empresaID) ";
        transf = (new StringBuilder(String.valueOf(transf))).append("VALUES ('").append(transferencia.transferenciaID).append("', '").append(livro.livroID).append("', '").append(valor).append("', '1', 'D', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return transf;
    }

    public String chequeVoltou()
    {
        String cheque = "INSERT INTO lancamentos (receberID, vendaID, livroID, formID, valor, observacao, tipo, usuario, empresaID) ";
        cheque = (new StringBuilder(String.valueOf(cheque))).append("VALUES ('").append(receber.receberID).append("', '").append(venda.vendaID).append("', '").append(livro.livroID).append("', '").append(formaPag.formPagID).append("', '").append(valor).append("', ").toString();
        cheque = (new StringBuilder(String.valueOf(cheque))).append("'").append(observacao).append("', 'C', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return cheque;
    }

    public String listaRecebimentos(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, lancamentos.* FROM lancamentos ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = lancamentos.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE lancamentos.livroID = '").append(livro.livroID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND lancamentos.data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append(" 23:59:59").append("'").toString();
        return pesquisa;
    }

    public String listaRecebimentosPorEmpresa(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, lancamentos.* FROM lancamentos ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = lancamentos.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE lancamentos.livroID = '").append(livro.livroID).append("' AND lancamentos.empresaID = '").append(empresa.empresaID).append("' ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("AND lancamentos.data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append(" 23:59:59").append("'").toString();
        return pesquisa;
    }

    public String dividasQuitadasTotal(String dataBusca, String clienteID)
    {
        String pesquisa = "SELECT venda.vendaID, venda.clienteID, cliente.clienteID, cliente.clienteNomeFantasia, lancamentos.vendaID, lancamentos.valor, SUM(lancamentos.valor) as total, lancamentos.formID ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM lancamentos INNER JOIN venda ON venda.vendaID = lancamentos.vendaID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN cliente ON cliente.clienteID = venda.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE lancamentos.data LIKE '").append(dataBusca).append("%' AND formID = '7' AND venda.clienteID = '").append(clienteID).append("'").toString();
        return pesquisa;
    }

    public String dividasQuitadas(String dataBusca, String clienteID)
    {
        String pesquisa = "SELECT venda.vendaID, venda.clienteID, venda.data AS dataVenda, cliente.clienteID, cliente.clienteNomeFantasia, lancamentos.* ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM lancamentos INNER JOIN venda ON venda.vendaID = lancamentos.vendaID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN cliente ON cliente.clienteID = venda.clienteID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE lancamentos.data LIKE '").append(dataBusca).append("%' AND formID = '7' AND venda.clienteID = '").append(clienteID).append("'").toString();
        return pesquisa;
    }

    public String ultimoLancamento()
    {
        return "SELECT * FROM lancamentos ORDER BY lancamentoID DESC LIMIT 1";
    }

    public String somaLancamentos(int lancamentoInicio, int lancamentoFim)
    {
        String soma = "SELECT SUM(valor) as totalLancamentos FROM lancamentos ";
        soma = (new StringBuilder(String.valueOf(soma))).append("WHERE lancamentoID BETWEEN '").append(lancamentoInicio).append("' AND '").append(lancamentoFim).append("' ").toString();
        soma = (new StringBuilder(String.valueOf(soma))).append("AND (formID = '7' OR formID = '6' OR formID = '5' OR formID = '4') ").toString();
        soma = (new StringBuilder(String.valueOf(soma))).append("AND livroID = '1' AND tipo = 'R' AND usuario = '").append(usuario.login).append("'").toString();
        return soma;
    }

    public String somaLancamentosCheque(int lancamentoInicio, int lancamentoFim)
    {
        String soma = "SELECT receber.receberID, receber.formID, receber.status, ";
        soma = (new StringBuilder(String.valueOf(soma))).append("SUM(lancamentos.valor) as totalLancamentos, lancamentos.receberID ").toString();
        soma = (new StringBuilder(String.valueOf(soma))).append("FROM lancamentos ").toString();
        soma = (new StringBuilder(String.valueOf(soma))).append("INNER JOIN receber ON receber.receberID = lancamentos.receberID ").toString();
        soma = (new StringBuilder(String.valueOf(soma))).append("WHERE lancamentos.formID = '7' AND receber.formID = '4' ").toString();
        soma = (new StringBuilder(String.valueOf(soma))).append("AND lancamentos.lancamentoID BETWEEN '").append(lancamentoInicio).append("' AND '").append(lancamentoFim).append("' ").toString();
        soma = (new StringBuilder(String.valueOf(soma))).append("AND lancamentos.usuario = '").append(usuario.login).append("'").toString();
        return soma;
    }

    public String contasRecebidas()
    {
        String busca = "SELECT livrocaixa.livroID, livrocaixa.banco, lancamentos.* ";
        busca = (new StringBuilder(String.valueOf(busca))).append("FROM lancamentos ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN livrocaixa ON livrocaixa.livroID = lancamentos.livroID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE receberID = '").append(receber.receberID).append("'").toString();
        return busca;
    }

    public String contasPagas()
    {
        String busca = "SELECT livrocaixa.livroID, livrocaixa.banco, lancamentos.* ";
        busca = (new StringBuilder(String.valueOf(busca))).append("FROM lancamentos ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN livrocaixa ON livrocaixa.livroID = lancamentos.livroID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE pagarID = '").append(pagar.pagarID).append("'").toString();
        return busca;
    }

    public int lancamentoID;
    public Receber receber;
    public Pagar pagar;
    public Venda venda;
    public Transferencias transferencia;
    public ContasPagar contaPagar;
    public LivroCaixa livro;
    public FormaPagamento formaPag;
    public float valor;
    public float desconto;
    public float acrescimo;
    public String favorecido;
    public String observacao;
    public String tipo;
    public Usuario usuario;
    public Empresa empresa;
}
