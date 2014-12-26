// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LivroCaixa.java

package financeiro;


public class LivroCaixa
{

    public LivroCaixa()
    {
    }

    public String listaTodosBancos()
    {
        return "SELECT * FROM livrocaixa ORDER BY status DESC, banco ASC";
    }

    public String listaBancos()
    {
        return "SELECT * FROM livrocaixa WHERE status = 'S' ORDER BY banco ASC";
    }

    public String pesquisaBancoPorNomeEditar()
    {
        return (new StringBuilder("SELECT * FROM livrocaixa WHERE banco = '")).append(banco).append("' AND livroID <> '").append(livroID).append("'").toString();
    }

    public String pesquisaBancoPorNome()
    {
        return (new StringBuilder("SELECT * FROM livrocaixa WHERE banco = '")).append(banco).append("'").toString();
    }

    public String bancoPorID()
    {
        return (new StringBuilder("SELECT * FROM livrocaixa WHERE livroID = '")).append(livroID).append("'").toString();
    }

    public String saldoEmCaixa()
    {
        return (new StringBuilder("SELECT saldo FROM livrocaixa WHERE livroID = '")).append(livroID).append("'").toString();
    }

    public String saldoTotal()
    {
        return "SELECT SUM(saldo) as total FROM livrocaixa WHERE status = 'S'";
    }

    public String saldoTotalBancos()
    {
        return "SELECT SUM(saldo) as total FROM livrocaixa WHERE livroID <> '1' AND status = 'S'";
    }

    public String cadastraBanco()
    {
        String cadastra = "INSERT INTO livrocaixa (banco, descricao, valorInicial, dataInicio, saldo) ";
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("VALUES ('").append(banco).append("', '").append(descricao).append("', '").append(valorInicial).append("', '").append(dataInicio).append("', '").append(valorInicial).append("')").toString();
        return cadastra;
    }

    public String atualizaSaldo()
    {
        return (new StringBuilder("UPDATE livrocaixa SET saldo = '")).append(saldo).append("' WHERE livroID = '").append(livroID).append("'").toString();
    }

    public String alteraBanco()
    {
        return (new StringBuilder("UPDATE livrocaixa SET banco = '")).append(banco).append("', descricao = '").append(descricao).append("' WHERE livroID = '").append(livroID).append("'").toString();
    }

    public String statusBanco(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE livrocaixa SET status = 'N' WHERE livroID = '")).append(livroID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE livrocaixa SET status = 'S' WHERE livroID = '")).append(livroID).append("'").toString();
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Novo Banco Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Nome do Banco Alterado com Sucesso!!";

        case 3: // '\003'
            return "IMPOSSIVEL CADASTRAR! J\301 EXISTE UM BANCO CADASTRADO COM ESSE NOME.";

        case 4: // '\004'
            return "IMPOSSIVEL ALTERAR! J\301 EXISTE UM BANCO CADASTRADO COM ESSE NOME.";

        case 5: // '\005'
            return "Trasferencia Realizada com Sucesso!";
        }
        return "";
    }

    public int livroID;
    public String banco;
    public String dataInicio;
    public float valorInicial;
    public float saldo;
    public String descricao;
}
