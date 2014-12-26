// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cargo.java

package cadastro;


public class Cargo
{

    public Cargo()
    {
    }

    public String listaCargos()
    {
        return "SELECT * FROM cargo ORDER BY cargoTitulo ASC";
    }

    public String listaCargosAtivos()
    {
        return "SELECT * FROM cargo WHERE cargoAtivo = 'S' ORDER BY cargoTitulo ASC";
    }

    public String pesquisaCargo(String keyWord)
    {
        return (new StringBuilder("SELECT * FROM cargo WHERE cargoAtivo = 'S' AND cargoTitulo LIKE '%")).append(keyWord).append("%' ORDER BY cargoTitulo ASC").toString();
    }

    public String cargoPorId()
    {
        return (new StringBuilder("SELECT * FROM cargo WHERE cargoID = '")).append(cargoID).append("'").toString();
    }

    public String verificaCargo()
    {
        return (new StringBuilder("SELECT * FROM cargo WHERE cargoTitulo = '")).append(titulo).append("'").toString();
    }

    public String verificaCargoAlterar()
    {
        return (new StringBuilder("SELECT * FROM cargo WHERE cargoTitulo = '")).append(titulo).append("' AND cargoID <> '").append(cargoID).append("'").toString();
    }

    public String salvarCargo()
    {
        return (new StringBuilder("INSERT INTO cargo (cargoTitulo, cargoDescricao) VALUES ('")).append(titulo).append("', '").append(descricao).append("')").toString();
    }

    public String alteraCargo()
    {
        return (new StringBuilder("UPDATE cargo SET cargoTitulo = '")).append(titulo).append("', cargoDescricao = '").append(descricao).append("' WHERE cargoID = '").append(cargoID).append("'").toString();
    }

    public String excluiCargo()
    {
        return (new StringBuilder("DELETE FROM cargo WHERE cargoID = '")).append(cargoID).append("'").toString();
    }

    public String statusCargo(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE cargo SET cargoAtivo = 'N' WHERE cargoID = '")).append(cargoID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE cargo SET cargoAtivo = 'S' WHERE cargoID = '")).append(cargoID).append("'").toString();
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Cargo Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Cargo Alterado com Sucesso!";

        case 3: // '\003'
            return "Cargo Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe esse Cargo.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe esse Cargo.";
        }
        return "";
    }

    public int cargoID;
    public String titulo;
    public String descricao;
}
