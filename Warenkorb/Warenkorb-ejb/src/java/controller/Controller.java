/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import model.Model;
import model.ModelLocal;

/**
 *
 * @author stea1th
 */
@Stateful(mappedName = "ControllerBean")
public class Controller implements ControllerRemote {

    @EJB
    private Model model;
    
    private List<ArtikelDTO> warenkorb = new ArrayList<>();
    
    @Override
    public List<ArtikelDTO> getAllArtikels() throws SQLException, ClassNotFoundException{
       return model.getAllArtikels();
    }
    
    @Override
    public ArtikelDTO getArtikelById(int id) throws SQLException{
        
        /*for(ArtikelDTO i : getAllArtikels()){
            if(i.getId()==id)
                return i;
        }
        return null;*/
        return new ArtikelDTO(3, "Samsung", 7, 499.99);
    }
    
    @Override
    public ArtikelDTO getWarenkorbById(int id){
        
        for(ArtikelDTO i : warenkorb){
            if(i.getId()==id)
                return i;
        }
        return null;
    }
    
    @Override
    public List<ArtikelDTO> getWarenkorb(){
        return warenkorb;
    }
    
    @Override
    public void artikelInsWarenkorb(ArtikelDTO artikel, int menge) throws ClassNotFoundException, SQLException{
        if(artikel.getMenge()>= menge){
            warenkorb.add(artikel);
            artikel.setMenge(artikel.getMenge()-menge);
            model.saveToDb(artikel.getId(), artikel.getMenge());
        }
    }
    
    @Override
    public void artikelAusDemWarenkorb(ArtikelDTO artikel, int menge) throws ClassNotFoundException, SQLException{
        if(artikel.getMenge()>menge){
            artikel.setMenge(artikel.getMenge()-menge);
            model.saveToDb(artikel.getId(), artikel.getMenge());
        }
    }
    
}
