// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Acesso.java

package cadastro;

import java.net.InetAddress;

public class Acesso
{

    public Acesso()
    {
    }

    public String retornaIP()
    {
        try
        {
            InetAddress i = InetAddress.getLocalHost();
            acessoIP = i.getHostAddress();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return acessoIP;
    }

    public String registraAcesso(String ip)
    {
        return (new StringBuilder("INSERT INTO acesso (acessoUsuario, acessoIP) VALUES ('")).append(usuario).append("', '").append(ip).append("')").toString();
    }

    public int acessoID;
    public String acessoIP;
    public String usuario;
}
