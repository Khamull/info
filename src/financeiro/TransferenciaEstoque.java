// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TransferenciaEstoque.java

package financeiro;

import cadastro.Empresa;
import cadastro.Usuario;

public class TransferenciaEstoque
{

    public TransferenciaEstoque()
    {
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String salvaTransferencia()
    {
        String salvar = "INSERT INTO transferenciaestoque ";
        salvar = (new StringBuilder(String.valueOf(salvar))).append("(usuarioID, empresaID, origemID, destinoID, quantidade) ").toString();
        salvar = (new StringBuilder(String.valueOf(salvar))).append("VALUES ").toString();
        salvar = (new StringBuilder(String.valueOf(salvar))).append("('").append(usuario.usuarioID).append("','").append(empresa.empresaID).append("','").append(origemID).append("','").append(destinoID).append("','").append(quantidade).append("')").toString();
        return salvar;
    }

    public int transferenciaID;
    public Usuario usuario;
    public Empresa empresa;
    public int origemID;
    public int destinoID;
    public float quantidade;
}
