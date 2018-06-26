/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koerpergewichtclient;

import exceptions.InvalidCharacterException;
import exceptions.NegativWertException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import koerper.BmiRemote;
import koerper.GewichtRemote;
import koerper.MenschDTO;

/**
 *
 * @author stea1th
 */
public class RechneService {

    private InitialContext context = null;

    public RechneService() {
        try {
            this.context = new InitialContext();
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getNormal(int gr) throws NegativWertException, NamingException{
        if(Pruef.pruef(gr).length()!=0)
            throw new NegativWertException(Pruef.pruef(gr).toString());
        GewichtRemote remote = (GewichtRemote) context.lookup("GewichtBean");
        return remote.getNormal(gr);
    }
    
    public double getIdeal(int gr, char c) throws NegativWertException, NamingException, InvalidCharacterException{
        if(Pruef.pruef(gr).length()!=0){
            if(!Pruef.pruefChar(c))
                throw new NegativWertException(Pruef.pruef(gr).toString()+" "+c);
            throw new NegativWertException(Pruef.pruef(gr).toString());
        }
        if(!Pruef.pruefChar(c))
            throw new InvalidCharacterException(""+c);
        GewichtRemote remote = (GewichtRemote) context.lookup("GewichtBean");
        return remote.getIdeal(gr, c);
    }
    
    public double getBmi(int gr, int gew) throws NegativWertException, NamingException{
        if(Pruef.pruef(gr, gew).length()!=0)
           throw new NegativWertException(Pruef.pruef(gr, gew).toString()); 
        BmiRemote remote = (BmiRemote) context.lookup("BmiBean");
        return remote.getBmi(gr, gew);
    }
    
    public MenschDTO getAll(int gr, char c, int gew) throws NegativWertException, NamingException, InvalidCharacterException{
        if(Pruef.pruef(gr, gew).length()!=0){
            if(!Pruef.pruefChar(c))
                throw new NegativWertException(Pruef.pruef(gr, gew).toString()+" "+c);
            throw new NegativWertException(Pruef.pruef(gr, gew).toString());
        }
        if(!Pruef.pruefChar(c))
            throw new InvalidCharacterException(""+c);
        BmiRemote remote = (BmiRemote) context.lookup("BmiBean");
        return remote.getAll(gr, c, gew);
    }
}
