// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Usuario.java

package cadastro;


// Referenced classes of package cadastro:
//            Funcionario, Empresa

public class Usuario
{

    public Usuario()
    {
        funcionario = new Funcionario();
        msgErro = "";
        empresa = new Empresa();
    }

    public String logar()
    {
        return (new StringBuilder("SELECT * FROM usuario WHERE usuarioLogin = '")).append(login).append("' AND usuarioSenha = '").append(senha).append("' AND usuarioAtivo = 'S'").toString();
    }

    public String logarUnidade()
    {
        String logaSis = (new StringBuilder("SELECT * FROM usuario WHERE usuarioLogin = '")).append(login).append("' AND ").toString();
        logaSis = (new StringBuilder(String.valueOf(logaSis))).append("usuarioSenha = '").append(senha).append("' AND empresaID = '").append(empresa.empresaID).append("' AND usuarioAtivo = 'S'").toString();
        return logaSis;
    }

    public String logarAdm()
    {
        return (new StringBuilder("SELECT * FROM usuario WHERE usuarioLogin = '")).append(login).append("' AND usuarioSenha = '").append(senha).append("' AND usuarioAtivo = 'S' AND usuarioNivel = '1'").toString();
    }

    public String verificaNome()
    {
        return (new StringBuilder("SELECT usuarioLogin FROM usuario WHERE usuarioLogin = '")).append(login).append("'").toString();
    }

    public String verificaNomeAlterar()
    {
        return (new StringBuilder("SELECT usuarioLogin FROM usuario WHERE usuarioLogin = '")).append(login).append("' AND usuarioID <> '").append(usuarioID).append("'").toString();
    }

    public String pesquisaUsuario(String keyWord)
    {
        return (new StringBuilder("SELECT * FROM usuario WHERE usuarionome LIKE '%")).append(keyWord).append("%' ORDER BY usuarioID DESC").toString();
    }

    public String listaUsuarios()
    {
        return "SELECT * FROM usuario ORDER BY usuarioID DESC";
    }

    public String listaUsuariosAtivos()
    {
        return "SELECT * FROM usuario WHERE usuarioAtivo = 'S' ORDER BY usuarioID DESC";
    }

    public String usuarioPorID()
    {
        String busca = "SELECT empresa.empresaID, empresa.unidade, usuario.* ";
        busca = (new StringBuilder(String.valueOf(busca))).append("FROM usuario INNER JOIN empresa ON empresa.empresaID = usuario.empresaID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE usuario.usuarioID = '").append(usuarioID).append("'").toString();
        return busca;
    }

    public String usuarioPorLogin()
    {
        return (new StringBuilder("SELECT * FROM usuario WHERE usuarioLogin = '")).append(login).append("'").toString();
    }

    public String listaUsuariosOrdenados()
    {
        return "SELECT * FROM usuario WHERE usuarioAtivo = 'S' ORDER BY usuarioNome ASC";
    }

    public String salvaUsuario()
    {
        String inserirNaBase = "INSERT INTO usuario ";
        inserirNaBase = (new StringBuilder(String.valueOf(inserirNaBase))).append("(funcionarioID, usuarioNome, usuarioTelefone, usuarioEmail, usuarioLogin, usuarioSenha, usuarioNivel, empresaID) ").toString();
        inserirNaBase = (new StringBuilder(String.valueOf(inserirNaBase))).append("VALUES ('").append(funcionario.funcionarioID).append("', '").append(nome).append("', '', '', '").append(login).append("', '").append(senha).append("', '").append(nivel).append("', '").append(empresa.empresaID).append("')").toString();
        return inserirNaBase;
    }

    public String editarUsuario()
    {
        String atualizaUsuario = "UPDATE usuario ";
        atualizaUsuario = (new StringBuilder(String.valueOf(atualizaUsuario))).append("SET funcionarioID = '").append(funcionario.funcionarioID).append("', usuarioNome = '").append(nome).append("', usuarioLogin = '").append(login).append("', ").toString();
        atualizaUsuario = (new StringBuilder(String.valueOf(atualizaUsuario))).append("usuarioSenha = '").append(senha).append("', usuarioNivel = '").append(nivel).append("', empresaID = '").append(empresa.empresaID).append("' ").toString();
        atualizaUsuario = (new StringBuilder(String.valueOf(atualizaUsuario))).append("WHERE usuarioID = '").append(usuarioID).append("'").toString();
        return atualizaUsuario;
    }

    public String excluiUsuario()
    {
        return (new StringBuilder("DELETE FROM usuario WHERE usuarioID = '")).append(usuarioID).append("'").toString();
    }

    public String statusUsuario(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE usuario SET usuarioAtivo = 'N' WHERE usuarioID = '")).append(usuarioID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE usuario SET usuarioAtivo = 'S' WHERE usuarioID = '")).append(usuarioID).append("'").toString();
        else
            return null;
    }

    public String erro(int numeroErro)
    {
        switch(numeroErro)
        {
        case 1: // '\001'
            return "Entre com seu login ou senha!";

        case 2: // '\002'
            return "Login ou senha n\343o Existe";

        case 3: // '\003'
            return "Sess\343o Expirou, entre novamente!";
        }
        return "";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Usu\341rio Cadstrado com Sucesso!";

        case 2: // '\002'
            return "Usu\341rio Alterado com Sucesso!";

        case 3: // '\003'
            return "Usu\341rio Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um usu\341rio com esse Login.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um usu\341rio com esse Login.";
        }
        return "";
    }

    public String nivelUsuario(int nivel)
    {
        switch(nivel)
        {
        case 1: // '\001'
            return "Nivel 1";

        case 2: // '\002'
            return "Nivel 2";

        case 3: // '\003'
            return "Nivel 3";

        case 4: // '\004'
            return "Nivel 4";

        case 5: // '\005'
            return "Nivel 5";

        case 6: // '\006'
            return "Nivel 6";
        }
        return null;
    }

    public int usuarioID;
    public Funcionario funcionario;
    public String nome;
    public String telefone;
    public String email;
    public String login;
    public String senha;
    public String nivel;
    public String msgErro;
    public Empresa empresa;
}
